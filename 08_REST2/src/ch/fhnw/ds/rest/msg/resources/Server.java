package ch.fhnw.ds.rest.msg.resources;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

	public static void main(String[] args) throws IOException {

		final String baseUri = "http://localhost:9998/";

	    final ResourceConfig rc = new ResourceConfig().packages("ch.fhnw.ds.rest.msg.resources");
		
		System.out.println("Starting grizzly...");
		HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);
		
		System.out.println(String.format("Jersey app started with WADL available at "
								+ "%sapplication.wadl\nTry out %smsg\nHit enter to stop it...",
								baseUri, baseUri));

		System.in.read();
		httpServer.shutdown();
	}
	
}

