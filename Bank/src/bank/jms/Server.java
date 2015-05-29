package bank.jms;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;
import bank.Server.ServerBank;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Set;

/**
 * Created by benjamin on 29.05.2015.
 */
public class Server {

    private static Bank bank = new ServerBank();
    private static ConnectionFactory factory;
    private static Topic topic;

    public static void main(String[] args) {

        try {
            final Context jndiContext = new InitialContext();
            factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            final Queue queue = (Queue) jndiContext.lookup("/queue/BANK");
            topic = (Topic) jndiContext.lookup("/topic/BANK");

            try (JMSContext context = factory.createContext()) {
                JMSConsumer consumer = context.createConsumer(queue);
                JMSProducer sender = context.createProducer();

                System.out.println("Bank service is running...");
                while(true) {
                    Message request = consumer.receive();
                    String msg = request.getBody(String.class);
                    System.out.println("Handle: " + msg);
                    String[] a = msg.split(":");
                    switch (a[0]) {
                        case "GETACCNUMBERS" :
                            Set<String> set = bank.getAccountNumbers();
                            StringBuilder builder = new StringBuilder();
                            for (String s : set) {
                                builder.append(s);
                                builder.append(':');
                            }
                            sender.send(request.getJMSReplyTo(), builder.toString());
                            break;
                        case "GETACC" :
                            Account acc = bank.getAccount(a[1]);
                            if (acc == null) {
                                sender.send(request.getJMSReplyTo(), "NULL");
                            } else {
                                sender.send(request.getJMSReplyTo(), acc.getNumber() + ":" + acc.getOwner() + ":" + acc.getBalance() + ":" + acc.isActive());
                            }
                            break;
                        case "CREATEACC" :
                            String number = bank.createAccount(a[1]);
                            System.out.println("Account Created: " + number);
                            sender.send(request.getJMSReplyTo(), number);
                            update(number);
                            break;
                        case "CLOSEACC" :
                            boolean result = bank.closeAccount(a[1]);
                            sender.send(request.getJMSReplyTo(), result);
                            update(a[1]);
                            break;
                        case "TRANSFER" :
                            Account from = bank.getAccount(a[1]);
                            Account to = bank.getAccount(a[2]);
                            Double amount = Double.parseDouble(a[3]);
                            try {
                                bank.transfer(from, to, amount);
                                sender.send(request.getJMSReplyTo(), "DONE");
                                update(from.getNumber());
                                update(to.getNumber());
                            } catch (IllegalArgumentException e) {
                                sender.send(request.getJMSReplyTo(), "ILLEGAL");
                            } catch (OverdrawException e) {
                                sender.send(request.getJMSReplyTo(), "OVERDRAW");
                            } catch (InactiveException e) {
                                sender.send(request.getJMSReplyTo(), "INACTIVE");
                            }
                            break;
                        case "DEPOSIT" : {
                            Account account = bank.getAccount(a[1]);
                            try {
                                account.deposit(Double.parseDouble(a[2]));
                                sender.send(request.getJMSReplyTo(), "DONE");
                                update(account.getNumber());
                            } catch (IllegalArgumentException e) {
                                sender.send(request.getJMSReplyTo(), "ILLEGAL");
                            } catch (InactiveException e) {
                                sender.send(request.getJMSReplyTo(), "INACTIVE");
                            }
                        }
                            break;
                        case "WITHDRAW" :
                            Account account = bank.getAccount(a[1]);
                            try {
                                account.withdraw(Double.parseDouble(a[2]));
                                sender.send(request.getJMSReplyTo(), "DONE");
                                update(account.getNumber());
                            } catch (IllegalArgumentException e) {
                                sender.send(request.getJMSReplyTo(), "ILLEGAL");
                            } catch (OverdrawException e) {
                                sender.send(request.getJMSReplyTo(), "OVERDRAW");
                            } catch (InactiveException e) {
                                sender.send(request.getJMSReplyTo(), "INACTIVE");
                            }
                            break;
                    }


                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } catch (NamingException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void update(String number) {
        try (JMSContext context = factory.createContext()) {
            JMSProducer publisher = context.createProducer();
            System.out.println("\tSended Update: " + number);
            publisher.send(topic, number);
        }
    }


}
