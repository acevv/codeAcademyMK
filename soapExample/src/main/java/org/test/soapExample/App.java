package org.test.soapExample;

import javax.xml.ws.Endpoint;

import org.test.soapExample.services.PersonServiceImpl;

public class App {
	public static void main(String[] args) {

		{
			System.out.println("Hello");
			Endpoint.publish("http://localhost:8080/Person", new PersonServiceImpl());

			// komunikacija so baz i da ne gi snima site Person u lista tuku vo baza
		}

	}
}
