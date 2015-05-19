package ch.fhnw.ds.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SimpleQueueSender {

	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("/queue/Q");
		
		try (JMSContext context = factory.createContext()) {
			JMSProducer sender = context.createProducer();
			// sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT).setTimeToLive(15000).setDeliveryDelay(10000);
			for (int i = 0; i < 3; i++) sender.send(queue, "This is message " + i);
		}
	}
}
