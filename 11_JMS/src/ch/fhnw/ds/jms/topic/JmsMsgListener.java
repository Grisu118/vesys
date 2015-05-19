package ch.fhnw.ds.jms.topic;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsMsgListener {

	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Topic topic = (Topic) jndiContext.lookup("/topic/APPL");

		System.out.println("topic.getTopicName() = " + topic.getTopicName());
		System.out.println("topic.toString() = " + topic.toString());

		try (JMSContext context = factory.createContext()) {
			 JMSConsumer subscriber = context.createConsumer(topic);
			 System.out.println("Topic subscriber is listening...");

			while (true) {
				System.out.println("Handle: " + subscriber.receiveBody(String.class));
			}
		}
	}

}
