package jaxbExample;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallerExample {

	public static void main(String[] args) {
		
		
		try {
			JAXBContext context = JAXBContext.newInstance(Fruits.class);

			File file = new File("/Users/acev/Desktop/fruit.xml");

			Unmarshaller unmarshaller = context.createUnmarshaller();

			Fruits f = (Fruits) unmarshaller.unmarshal(file);

			System.out.println("name: " + f.getFruits().get(1).getName());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
