package ch.fhnw.ds.jms.echo;

import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TemporaryQueue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsEchoClient {
	
	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("/queue/ECHO");
		
		try (JMSContext context = factory.createContext()) {
			TemporaryQueue tempQueue = context.createTemporaryQueue();
			
			JMSProducer sender = context.createProducer().setJMSReplyTo(tempQueue);
			JMSConsumer receiver = context.createConsumer(tempQueue);
			
			sender.send(queue, "Hello World [" + new Date() + "]");
			
			String res = receiver.receiveBody(String.class);
			System.out.println(res);

//			final CountDownLatch latch = new CountDownLatch(1);
//			receiver.setMessageListener((Message m) -> {
//					try {
//						System.out.println("Response: " + m.getBody(String.class));
//						latch.countDown(); // is only here because the context is closed when try-with is left
//					} catch (JMSException e) {
//						e.printStackTrace();
//					}
//				}
//			);
//			latch.await();
		}
	}
	
}
