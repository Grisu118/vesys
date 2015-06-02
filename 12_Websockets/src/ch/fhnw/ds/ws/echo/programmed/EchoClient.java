package ch.fhnw.ds.ws.echo.programmed;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

public class EchoClient extends Endpoint {

	private static CountDownLatch latch = new CountDownLatch(1);
	
	@Override
    public void onOpen(final Session session, EndpointConfig config) {
		System.out.printf("onOpen [%s]\n", Thread.currentThread());
        try {
            session.getBasicRemote().sendText("Hello");
        } catch (IOException e) {
        	throw new RuntimeException(e);
        }

        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
            	System.out.printf("onMessage [%s] %s\n", Thread.currentThread(), message);
        		try {
					session.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
            }

        });

     }

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		System.out.printf("onClose [%s] Session %s closed because of %s\n", Thread.currentThread(), session.getId(), closeReason);
		latch.countDown();
	}

	@Override
	public void onError(Session session, Throwable exception) {
		System.out.printf("onError [%s] an error occured on connection %s: %s\n", Thread.currentThread(), session.getId(), exception);
	}
	

	public static void main(String[] args) throws Exception {
		// final URI url = new URI("ws://echo.websocket.org/");
		// final URI url = new URI("ws://localhost:8888/examples/websocket/echoProgrammatic");
		// final URI url = new URI("ws://localhost:8888/examples/websocket/echoAnnotation");
		// final URI url = new URI("ws://localhost:8888/examples/websocket/echoStreamAnnotation");
		final URI url = new URI("ws://localhost:2222/websockets/echo");

		System.out.println(Thread.currentThread());
		
		ClientManager client = ClientManager.createClient();
        ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
//        client.connectToServer(EchoClient.class, cec, url);
        client.connectToServer(new EchoClient(), cec, url);
		latch.await();
	}

}
