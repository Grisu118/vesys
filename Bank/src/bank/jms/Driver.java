package bank.jms;


import bank.*;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by benjamin on 29.05.2015.
 */
public class Driver implements BankDriver2 {

    private static bank.Bank bank;
    private JMSUpdateHandler handler;

    @Override
    public void registerUpdateHandler(UpdateHandler handler) throws IOException {
        System.out.println("Register");
        this.handler.registerUpdateHandler(handler);
    }

    @Override
    public void connect(String[] args) throws IOException {
        bank = new Bank();
        try {
            handler = new JMSUpdateHandler();
            handler.start();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() throws IOException {
        bank = null;
    }

    @Override
    public bank.Bank getBank() {
        return bank;
    }

    class Bank implements bank.Bank {
        private ConnectionFactory connectionFactory;
        private Context jndiContext;
        private Queue queue;

        public Bank() {
            try {
                jndiContext = new InitialContext();
                connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
                final ConnectionFactory factory =
                        connectionFactory;
                queue = (Queue) jndiContext.lookup("/queue/BANK");
            } catch (NamingException e) {
                e.printStackTrace();
            }

        }

        private <T> T send(String msg, Class<T> tClass) {
            try (JMSContext context = connectionFactory.createContext()) {
                TemporaryQueue tempQueue = context.createTemporaryQueue();

                JMSProducer sender = context.createProducer().setJMSReplyTo(tempQueue);
                JMSConsumer receiver = context.createConsumer(tempQueue);

                sender.send(queue, msg);
                return receiver.receiveBody(tClass);
            }
        }

        @Override
        public String createAccount(String owner) throws IOException {
            if (owner == null || "".equals(owner)) { return null;}
            return send("CREATEACC:" + owner, String.class);
        }

        @Override
        public boolean closeAccount(String number) throws IOException {
            if (number == null || "".equals(number)) { return false; }
            return send("CLOSEACC:" + number, Boolean.class);
        }

        @Override
        public Set<String> getAccountNumbers() throws IOException {
            String s = send("GETACCNUMBERS:", String.class);
            String[] a = s.split(":");
            Set<String> set;
            if (a.length > 0 && a.length <= 1 && "".equals(a[0])) {
                set = new HashSet<>();
            } else {
                set = new HashSet<>(Arrays.asList(a));
            }
            return set;
        }

        @Override
        public bank.Account getAccount(String number) throws IOException {
            if (number == null || number.equals("")) { return null;}
            String msg = send("GETACC:" + number, String.class);
            if ("NULL".equals(msg)) {
                return null;
            }
            return new Account(msg.split(":"));
        }

        @Override
        public void transfer(bank.Account a, bank.Account b, double amount) throws IOException, IllegalArgumentException, OverdrawException, InactiveException {
            String msg = send("TRANSFER:" + a.getNumber() + ":" + b.getNumber() + ":" + amount, String.class);
            switch (msg) {
                case "ILLEGAL":
                    throw new IllegalArgumentException();
                case "OVERDRAW":
                    throw new OverdrawException();
                case "INACTIVE":
                    throw new InactiveException();
                default:
                    break;
            }
        }

        class Account implements bank.Account {

            private String number;
            private String owner;
            private double balance;
            private boolean isActive;

            public Account(String number, String owner, double balance, boolean isActive) {
                this.number = number;
                this.owner = owner;
                this.balance = balance;
                this.isActive = isActive;
            }

            public Account(String[] args) {
                this.number = args[0];
                this.owner = args[1];
                this.balance = Double.parseDouble(args[2]);
                System.out.println(balance);
                this.isActive = Boolean.parseBoolean(args[3]);
            }


            @Override
            public String getNumber() throws IOException {
                return number;
            }

            @Override
            public String getOwner() throws IOException {
                return owner;
            }

            @Override
            public boolean isActive() throws IOException {
                return isActive;
            }

            @Override
            public boolean setInactive() throws IOException {
                if (balance > 0) {
                    return false;
                }
                isActive = false;
                return true;
            }

            @Override
            public void deposit(double amount) throws IOException, IllegalArgumentException, InactiveException {
                String msg = send("DEPOSIT:" + getNumber() + ":" + amount, String.class);
                switch (msg) {
                    case "ILLEGAL":
                        throw new IllegalArgumentException();
                    case "INACTIVE":
                        throw new InactiveException();
                    default:
                        break;
                }
            }

            @Override
            public void withdraw(double amount) throws IOException, IllegalArgumentException, OverdrawException, InactiveException {
                String msg = send("WITHDRAW:" + getNumber() + ":" + amount, String.class);;
                switch (msg) {
                    case "ILLEGAL":
                        throw new IllegalArgumentException();
                    case "OVERDRAW":
                        throw new OverdrawException();
                    case "INACTIVE":
                        throw new InactiveException();
                    default:
                        break;
                }
            }

            @Override
            public double getBalance() throws IOException {
                return balance;
            }
        }
    }


}
