package ch.fhnw.ds.rest.doodle;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.doodle.types.poll.ObjectFactory;
import com.doodle.types.poll.ParticipantType;


public class DoodleClient2 {

	public static void main(String[] args) {
		Client c = ClientBuilder.newClient();
		WebTarget r = c.target("http://doodle-test.com/thisIsSuperRandom/polls/udw26k7f8wwwgghg/participants");

		ParticipantType p = participate("Dominik2", new boolean[] { false, false, false, true });

		Response resp = r.request().post(Entity.entity(new ObjectFactory().createParticipant(p), MediaType.APPLICATION_XML_TYPE));

		System.out.println("status:   " + resp.getStatus());
		System.out.println("Location: " + resp.getLocation());
		System.out.println("Content-Location: " + resp.getHeaders().getFirst("Content-Location"));

		System.out.println("Headers:");
		MultivaluedMap<String, String> headers = resp.getStringHeaders();
		for (Entry<String, List<String>> entry : headers.entrySet()) {
			System.out.println("\t" + entry);
		}
	}
		
	public static ParticipantType participate(String name, boolean[] options) {
		// TODO: create new instance of class  ParticipantType
		// TODO: set the name
		// TODO: create new Preferences
		// TODO: add the preferences (BigInteger.ONE or BigInteger.ZERO) to the preferences
		// TODO: set the preferences on the paricipant type object
		return null;
	}
}
