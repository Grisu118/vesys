package bank.jms;

import bank.*;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Set;

/**
 * Created by benjamin on 29.05.2015.
 */
public class Driver implements BankDriver2 {

    private static bank.Bank bank;

    @Override
    public void registerUpdateHandler(UpdateHandler handler) throws IOException {

    }

    @Override
    public void connect(String[] args) throws IOException {
        try {
            final Context jndiContext = new InitialContext();
            final ConnectionFactory factory =
                    (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            final Queue queue = (Queue) jndiContext.lookup("/queue/BANK");
            final Topic topic = (Topic) jndiContext.lookup("/topic/BANK");

            try (JMSContext context = factory.createContext()) {
                TemporaryQueue tempQueue = context.createTemporaryQueue();

                JMSProducer sender = context.createProducer().setJMSReplyTo(tempQueue);
                JMSConsumer receiver = context.createConsumer(tempQueue);
                bank = new Bank(sender, receiver);
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void disconnect() throws IOException {
    }

    @Override
    public bank.Bank getBank() {
        return bank;
    }

    static class Bank implements bank.Bank {
        private JMSProducer sender;
        private JMSConsumer receiver;
        private Queue queue;

        public Bank(JMSProducer sender, JMSConsumer receiver, Queue queue) {
            this.sender = sender;
            this.receiver = receiver;
            this.queue = queue;
        }

        @Override
        public String createAccount(String owner) throws IOException {
            sender.send(queue, "CREATE");

            return null;
        }

        @Override
        public boolean closeAccount(String number) throws IOException {
            return false;
        }

        @Override
        public Set<String> getAccountNumbers() throws IOException {
            return null;
        }

        @Override
        public bank.Account getAccount(String number) throws IOException {
            return null;
        }

        @Override
        public void transfer(bank.Account a, bank.Account b, double amount) throws IOException, IllegalArgumentException, OverdrawException, InactiveException {

        }
    }

    static class Account implements bank.Account {

        @Override
        public String getNumber() throws IOException {
            return null;
        }

        @Override
        public String getOwner() throws IOException {
            return null;
        }

        @Override
        public boolean isActive() throws IOException {
            return false;
        }

        @Override
        public boolean setInactive() throws IOException {
            return false;
        }

        @Override
        public void deposit(double amount) throws IOException, IllegalArgumentException, InactiveException {

        }

        @Override
        public void withdraw(double amount) throws IOException, IllegalArgumentException, OverdrawException, InactiveException {

        }

        @Override
        public double getBalance() throws IOException {
            return 0;
        }
    }
}
