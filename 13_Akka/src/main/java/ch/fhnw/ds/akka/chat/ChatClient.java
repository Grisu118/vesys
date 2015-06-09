package ch.fhnw.ds.akka.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ChatClient {
	
	static ActorSystem system;

	public static void main(String[] args) {
        System.out.print("Username: ");
        String username = readInput();
        
        Config commonConfig = ConfigFactory.load().getConfig("ChatConfig");
        Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port="+getFreePort()).withFallback(commonConfig);
        System.out.println(config);

        system = ActorSystem.create("ChatApplication", config);
		ActorRef client = system.actorOf(Props.create(ChatActor.class), "ChatActor");
		System.out.println("Started Chat Client");

		ActorSelection serverActor = system.actorSelection("akka.tcp://ChatApplication@127.0.0.1:2552/user/ChatServer");
        serverActor.tell(new LoginMessage(username), client);
        while(true) {
            String message = readInput();
            if (message.trim().equals("bye")) break;
            serverActor.tell(new TextMessage(username, message), client);
        }
        serverActor.tell(new LogoutMessage(username), client);
	}
	
	static class ChatActor extends UntypedActor {

        public void onReceive(Object event) {
            if (event instanceof String) System.out.println("> " + event);
            else if(event instanceof LogoutMessage) {
                system.shutdown();
            }
            else {
            	System.out.println("UnHandled Message Received");
            	unhandled(event);
            }
        }

    }

    private static String readInput() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    
    public static int getFreePort() {
        return new Random().nextInt(10000) + 10000;
    }

}
