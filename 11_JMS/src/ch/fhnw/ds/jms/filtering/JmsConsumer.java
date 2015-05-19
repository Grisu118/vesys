package ch.fhnw.ds.jms.filtering;

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
			JMSConsumer consumer = context.createConsumer(queue, "JMSPriority > 3 AND dest='Dominik'");
			System.out.println("JMS consumer is running...");
			TextMessage message = (TextMessage) consumer.receive(1000);
			while (message != null) {
				System.out.println("consumed message " + message.getText());
				System.out.println("\tgetJMSPriority = " + message.getJMSPriority());
				System.out.println("\tgetProperty(\"dest\") = " + message.getStringProperty("dest"));
				message = (TextMessage) consumer.receive(1000);
			}
			System.out.println("no further message available");
		}
	}
}
