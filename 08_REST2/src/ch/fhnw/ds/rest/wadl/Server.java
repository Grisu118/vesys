package ch.fhnw.ds.rest.wadl;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

	public static void main(String[] args) throws IOException {

		final String baseUri = "http://localhost:8888/";

		final ResourceConfig rc = new ResourceConfig().packages("ch.fhnw.ds.rest.wadl");

		System.out.println("Starting grizzly...");
		HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);

		System.out.println(String.format("Jersey app started with WADL available at " + 
				"%sapplication.wadl\n" + 
				"%sapplication.wadl/xsd0.xsd\n" + 
				"Hit enter to stop it...", baseUri, baseUri));

		System.in.read();
		httpServer.shutdown();
	}

}
