package ch.fhnw.ds.akka.hierarchy;

import akka.actor.UntypedActor;

public class B extends UntypedActor {

	public void onReceive(Object msg) {
		System.out.println("B received " + msg);
	}

}