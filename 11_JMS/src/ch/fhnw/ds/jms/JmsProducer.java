package ch.fhnw.ds.jms;

import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


public class JmsProducer {

	public static void main(String[] args) throws Exception {
		Context jndiCcontext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiCcontext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiCcontext.lookup("/queue/Q");
		
		try (JMSContext context = factory.createContext()) {
			JMSProducer sender = context.createProducer();
			sendMessage(sender, queue, context.createTextMessage("Hello World [" + new Date() + "]"));
		}
		System.out.println("Request sent");
	}

	private static void sendMessage(JMSProducer producer, Queue q, TextMessage request) throws JMSException {
		System.out.println("BEFORE SEND");
		System.out.println("message: " + request.getText());
		
		System.out.println("\tgetJMSCorrelationID = " + request.getJMSCorrelationID());
		System.out.println("\tgetJMSDeliveryMode = " + request.getJMSDeliveryMode());
		System.out.println("\tgetJMSDeliveryTime = " + request.getJMSDeliveryTime());
		System.out.println("\tgetJMSDestination = " + request.getJMSDestination());
		System.out.println("\tgetJMSExpiration = " + request.getJMSExpiration());
		System.out.println("\tgetJMSMessageID = " + request.getJMSMessageID());
		System.out.println("\tgetJMSPriority = " + request.getJMSPriority());
		System.out.println("\tgetJMSRedelivered = " + request.getJMSRedelivered());
		System.out.println("\tgetJMSReplyTo = " + request.getJMSReplyTo());
		System.out.println("\tgetJMSTimestamp = " + request.getJMSTimestamp());
		System.out.println("\tgetJMSType = " + request.getJMSType());

//		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
//		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
//		producer.setPriority(4);
//		producer.setTimeToLive(5000);

		producer.send(q, request);

		System.out.println("AFTER SEND");
		System.out.println("message: " + request.getText());
		System.out.println("\tgetJMSCorrelationID = " + request.getJMSCorrelationID());
		System.out.println("\tgetJMSDeliveryMode = " + request.getJMSDeliveryMode());
		System.out.println("\tgetJMSDeliveryTime = " + request.getJMSDeliveryTime());
		System.out.println("\tgetJMSDestination = " + request.getJMSDestination());
		System.out.println("\tgetJMSExpiration = " + request.getJMSExpiration());
		System.out.println("\tgetJMSMessageID = " + request.getJMSMessageID());
		System.out.println("\tgetJMSPriority = " + request.getJMSPriority());
		System.out.println("\tgetJMSRedelivered = " + request.getJMSRedelivered());
		System.out.println("\tgetJMSReplyTo = " + request.getJMSReplyTo());
		System.out.println("\tgetJMSTimestamp = " + request.getJMSTimestamp());
		System.out.println("\tgetJMSType = " + request.getJMSType());
	}
}
