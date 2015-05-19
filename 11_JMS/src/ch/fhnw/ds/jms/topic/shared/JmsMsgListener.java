package ch.fhnw.ds.jms.topic.shared;

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

		try (JMSContext context = factory.createContext()) {
			// JMSConsumer subscriber = context.createConsumer(topic);
			JMSConsumer subscriber = context.createSharedConsumer(topic, "S1");
			subscriber.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message msg) {
					try {
						System.out.println("S1: " + msg.getBody(String.class));
					} catch (JMSException e) {
					}
				}
			});

			Object x = new Object();
			synchronized (x) {
				x.wait();
			}

		}
	}

}