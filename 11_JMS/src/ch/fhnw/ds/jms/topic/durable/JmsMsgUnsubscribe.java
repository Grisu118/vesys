package ch.fhnw.ds.jms.topic.durable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsMsgUnsubscribe {

	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Topic topic = (Topic) jndiContext.lookup("/topic/APPL");

		System.out.println("topic.getTopicName() = " + topic.getTopicName());
		System.out.println("topic.toString() = " + topic.toString());

		try (JMSContext context = factory.createContext()) {
			context.setClientID("Gruntz");
			context.unsubscribe("S1");
			System.out.println("unregisgtered registered client=" + context.getClientID());
		}
	}
	
}

