package ch.fhnw.ds.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SimpleQueueReceiver {
	
	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("/queue/Q");
		
		try (JMSContext context = factory.createContext()) {
			 JMSConsumer receiver = context.createConsumer(queue);
			 while(true) {
				 System.out.println(receiver.receiveBody(String.class));
			 }
		}
	}
}
