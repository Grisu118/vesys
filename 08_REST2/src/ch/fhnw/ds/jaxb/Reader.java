package ch.fhnw.ds.jaxb;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Reader {

	public static void main(String[] args) throws Exception {
		StringReader r = new StringReader(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
						+ "<p:player xmlns:p=\"http://www.fhnw.ch/types\">"
						+ "    <birthday>1979-08-30T00:00:00+01:00</birthday>"
						+ "    <name>Peter Müller</name>" 
						+ "</p:player>");

		JAXBContext context = JAXBContext.newInstance( Player.class );
		Unmarshaller m = context.createUnmarshaller();
		Object result = m.unmarshal(r);
		System.out.println(result);
	}

}
