package ch.fhnw.ds.jms.echo;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsEchoServer {

	public static void main(String[] args) throws Exception{
		Context jndiContext = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("/queue/ECHO");
		
		try (JMSContext context = factory.createContext()) {
			 JMSConsumer consumer = context.createConsumer(queue);
			 JMSProducer sender = context.createProducer();
			 
			 System.out.println("Echo service is running...");
			 while(true) {
				 Message request = consumer.receive();
				 System.out.println("Handle: " + request.getBody(String.class));
				 sender.send(request.getJMSReplyTo(), "Echo: " + request.getBody(String.class));
			 }
		}
	}
	
}
