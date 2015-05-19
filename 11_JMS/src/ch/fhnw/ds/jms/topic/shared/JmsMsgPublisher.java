package ch.fhnw.ds.jms.topic.shared;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsMsgPublisher {

	public static void main(String[] args) throws Exception {
		Context jndiContext = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Topic topic = (Topic) jndiContext.lookup("APPL");

		try (JMSContext context = factory.createContext()) {
			JMSProducer publisher = context.createProducer();
			System.out.println("Topic publisher started...");

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			String line = r.readLine();
			while (line != null && !"".equals(line.trim())) {
				publisher.send(topic, "[" + new Date() + "] " + line);
				line = r.readLine();
			}
		}
	}

}
