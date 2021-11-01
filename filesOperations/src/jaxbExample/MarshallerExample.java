package jaxbExample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerExample {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(Fruit.class);

			Marshaller jaxbMarshaller = context.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Fruit fruit = new Fruit();
			fruit.setId(1);
			fruit.setName("Banana");
			fruit.setPrice("50");

			jaxbMarshaller.marshal(fruit, System.out);

		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
