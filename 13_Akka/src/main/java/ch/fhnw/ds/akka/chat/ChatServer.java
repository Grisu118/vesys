package ch.fhnw.ds.akka.chat;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import akka.actor.*;
import scala.Option;

import com.typesafe.config.ConfigFactory;
import scala.concurrent.duration.Duration;

public class ChatServer {

	private static ActorSystem system;

	public static void main(String[] args) {
		system = ActorSystem.create("ChatApplication", ConfigFactory.load().getConfig("ChatConfig"));
		system.actorOf(Props.create(ChatActor.class), "ChatServer");
		System.out.println("Started Chat Application");
	}

	static class ChatActor extends UntypedActor {

		private final Map<String, ActorRef> sessions = new HashMap<>();

		public void onReceive(Object msg) {
			if (msg instanceof LoginMessage) {
				doLogin((LoginMessage) msg);
			} else if (msg instanceof TextMessage) {
				broadcastMessage((TextMessage) msg);
			} else if (msg instanceof LogoutMessage) {
				doLogout((LogoutMessage) msg);
			} else {
				System.out.println("UnHandled Message Received");
				unhandled(msg);
			}
		}

		private void doLogin(LoginMessage login) {
			String username = login.getUsername();
			ActorRef sender = getSender();
			sessions.put(username, sender);
			System.out.println(username + " just logged in");
			broadcastMessage(username, "I just logged in");
		}

		private void broadcastMessage(TextMessage textMessage) {
			if ("ex".equals(textMessage.getMessage())) {
				throw new RuntimeException("unsupported message");
			} else {
				broadcastMessage(textMessage.getUsername(), textMessage.getMessage());
			}
		}

		private void broadcastMessage(String sender, String message) {
			System.out.println(sender + " sent: " + message);
			for (Entry<String, ActorRef> entry : sessions.entrySet()) {
				if (!entry.getKey().equals(sender))
					entry.getValue().tell(sender + ": " + message, getSelf());
			}
		}

		private void doLogout(LogoutMessage logout) {
			String username = logout.getUsername();
			sessions.remove(username);
			System.out.println(username + " just logged out");
			broadcastMessage(username, "I just logged out");
			getSender().tell(logout, getSelf());
		}

		@Override
		public void preStart() throws Exception {
			System.out.printf("preStart on %s [%s]\n", this.getClass().getSimpleName(), System.identityHashCode(this));
			super.preStart();
		}

		@Override
		public void preRestart(Throwable reason, Option<Object> message) throws Exception {
			System.out.printf("preRestart on %s [%s]\n", this.getClass().getSimpleName(), System.identityHashCode(this));
			super.preRestart(reason, message);
		}

		@Override
		public void postRestart(Throwable reason) throws Exception {
			System.out.printf("postRestart on %s [%s]\n", this.getClass().getSimpleName(), System.identityHashCode(this));
			super.postRestart(reason);
		}

		@Override
		public void postStop() throws Exception {
			System.out.printf("postStop on %s [%s]\n", this.getClass().getSimpleName(), System.identityHashCode(this));
			super.postStop();
		}

        @Override
		public SupervisorStrategy supervisorStrategy() {
            return strategy;
        }

        private static SupervisorStrategy strategy = new OneForOneStrategy(10, Duration.create("1 minute"), (Throwable t) -> { return SupervisorStrategy.resume(); } );
	}

}
