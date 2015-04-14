package ch.fhnw.ds.rest.doodle;

import com.doodle.types.poll.OptionsType;
import com.doodle.types.poll.ParticipantType;
import com.doodle.types.poll.PollType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.util.List;

public class DoodleClient1 {

	public static void main(String[] args) {
		Client c = ClientBuilder.newClient();
		WebTarget r = c.target("http://doodle-test.com/thisIsSuperRandom/polls/udw26k7f8wwwgghg");
		
		PollType res = r.request().accept(MediaType.APPLICATION_XML_TYPE).get(PollType.class);
		System.out.println("Title:       " + res.getTitle());
		System.out.println("Description: " + res.getDescription());

		System.out.println("Options:");
		List<OptionsType.Option> optionList = res.getOptions().getOption();
		for (OptionsType.Option o : optionList) {
			System.out.println("\t" + o.getValue());
		}
		System.out.println("Participants:");
		List<ParticipantType> participantList = res.getParticipants().getParticipant();
		for (ParticipantType p : participantList) {
			System.out.println("\t" + p.getName());
			List<BigInteger> prefList = p.getPreferences().getOption();
			System.out.print("\t\t");
			for (BigInteger i : prefList) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
	}

}
