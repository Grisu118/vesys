package bank.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by benjamin on 29.05.2015.
 */
public class Server {

    public static void main(String[] args) {

        try {
            final Context jndiContext = new InitialContext();
            final ConnectionFactory factory =
                    (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            final Queue queue = (Queue) jndiContext.lookup("/queue/BANK");
            final Topic topic = (Topic) jndiContext.lookup("/topic/BANK");

            try (JMSContext context = factory.createContext()) {
                JMSConsumer consumer = context.createConsumer(queue);
                //JMSProducer sender = context.createProducer(topic);

                System.out.println("Bank service is running...");
                while(true) {
                    Message request = consumer.receive();
                    System.out.println("Handle: " + request.getBody(String.class));
                    //sender.send(request.getJMSReplyTo(), "Echo: " + request.getBody(String.class));
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


}
