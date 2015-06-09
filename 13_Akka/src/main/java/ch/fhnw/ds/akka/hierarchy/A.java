package ch.fhnw.ds.akka.hierarchy;

import akka.actor.Props;
import akka.actor.UntypedActor;

public class A extends UntypedActor {
	
	@Override
	public void preStart() throws Exception {
		getContext().actorOf(Props.create(B.class), "b1");
		getContext().actorOf(Props.create(B.class), "b2");
		super.preStart();
	}


	public void onReceive(Object msg) {
		System.out.println("A received " + msg);
	}

}