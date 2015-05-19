package ch.fhnw.ds.jms.topic.durable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
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
			context.setClientID("Gruntz");
			JMSConsumer subscriber1 = context.createDurableConsumer(topic, "S1");
			subscriber1.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message msg) {
					try {
						System.out.println("S1: " + msg.getBody(String.class));
					} catch (JMSException e) {
					}
				}
			});

			System.in.read();
		}
	}

}