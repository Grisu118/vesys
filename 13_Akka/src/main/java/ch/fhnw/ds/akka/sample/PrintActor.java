package ch.fhnw.ds.akka.sample;

import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.Duration;
import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;

public class PrintActor extends UntypedActor {
	private int requestCounter = 0;
	
	@Override
	public void preStart() throws Exception {
		getContext().setReceiveTimeout(Duration.create(5, TimeUnit.SECONDS));
		super.preStart();
	}


	public void onReceive(Object msg) {
		requestCounter++;
		if (msg instanceof String) {
			String txt = (String) msg;
			System.err.println(requestCounter + ": received message " + txt + " from " + getSender());
			if(txt.equals("echo")) {
				getSelf().tell(txt+txt, getSelf());
			}
		} else if (msg instanceof ReceiveTimeout) {
			System.out.println(requestCounter + ": received timeout message");
		} else {
			System.err.println(requestCounter + ": received unknown message");
		}
	}

}