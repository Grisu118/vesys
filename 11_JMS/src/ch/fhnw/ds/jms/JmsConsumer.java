package ch.fhnw.ds.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsConsumer {

	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("/queue/Q");

		try (JMSContext context = factory.createContext()) {
			JMSConsumer consumer = context.createConsumer(queue);
			System.out.println("JMS consumer is running...");
			int counter = 0;
			TextMessage message = (TextMessage) consumer.receive(1000);
			while (message != null) {
				counter++;
				System.out.println("consumed message " + message.getText());
				System.out.println("\tgetJMSCorrelationID = " + message.getJMSCorrelationID());
				System.out.println("\tgetJMSDeliveryMode = " + message.getJMSDeliveryMode());
				System.out.println("\tgetJMSDestination = " + message.getJMSDestination());
				System.out.println("\tgetJMSExpiration = " + message.getJMSExpiration());
				System.out.println("\tgetJMSMessageID = " + message.getJMSMessageID());
				System.out.println("\tgetJMSPriority = " + message.getJMSPriority());
				System.out.println("\tgetJMSRedelivered = " + message.getJMSRedelivered());
				System.out.println("\tgetJMSReplyTo = " + message.getJMSReplyTo());
				System.out.println("\tgetJMSTimestamp = " + message.getJMSTimestamp());
				System.out.println("\tgetJMSType = " + message.getJMSType());
				message = (TextMessage) consumer.receive(1000);
			}
			System.out.println(counter + " messages read");
			System.out.println("no further message available");
		}
	}
}
