package ch.fhnw.ds.jms.filtering;

import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsProducer {

	public static void main(String[] args) throws Exception {
		Context jndiCcontext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiCcontext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiCcontext.lookup("/queue/Q");
		
		try (JMSContext context = factory.createContext()) {
			context.createProducer().setPriority(5).setProperty("dest", "Dominik").send(queue, "Hello World [" + new Date() + "]");
			context.createProducer().setPriority(3).setProperty("dest", "Dominik").send(queue, "Hello World [" + new Date() + "]");
			context.createProducer().setPriority(5).setProperty("dest", "Dominik2").send(queue, "Hello World [" + new Date() + "]");
		}
		System.out.println("Requests sent");
	}

}
