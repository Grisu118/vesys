package ch.fhnw.ds.ws.echo.programmed;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

public class EchoServer extends Endpoint {

	@Override
	public void onOpen(final Session session, EndpointConfig config) {
		System.out.printf("New session %s\n", session.getId());
		final RemoteEndpoint.Basic remote = session.getBasicRemote();
		session.addMessageHandler(new MessageHandler.Whole<String>() {
			@Override
			public void onMessage(String message) {
				System.out.printf("received message over session %s: %s\n", session.getId(), message);
				try {
					remote.sendText("Echo " + message);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

			}
		});
	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		System.out.printf("Session %s closed because of %s\n", session.getId(), closeReason);
	}

	@Override
	public void onError(Session session, Throwable exception) {
		System.out.println("an error occured on connection " + session.getId() + ":" + exception);
	}

}