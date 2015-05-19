package ch.fhnw.ds.jms.topic;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsMsgListener2 {

	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Topic topic = (Topic) jndiContext.lookup("/topic/APPL");

		System.out.println("topic.getTopicName() = " + topic.getTopicName());
		System.out.println("topic.toString() = " + topic.toString());

		// context is not closed (and keeps program alive)
		JMSContext context = factory.createContext();
		JMSConsumer subscriber = context.createConsumer(topic);
		System.out.println("Topic subscriber is listening...");

		subscriber.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message msg) {
				try {
					System.out.println("onMessage called with " + msg.getBody(String.class));
				} catch (JMSException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		// HornetQ terminates otherwise, i.e. an open context does not prevent the program to terminate.
		Object x = new Object();
		synchronized(x) { x.wait(); }
	}
}
