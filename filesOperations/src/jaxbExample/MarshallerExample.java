package jaxbExample;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerExample {

	public static void main(String[] args) throws FileNotFoundException {

		try {
			JAXBContext context = JAXBContext.newInstance(Fruits.class);

			Marshaller jaxbMarshaller = context.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Fruit fruit = new Fruit();
			fruit.setId(1);
			fruit.setName("Banana");
			fruit.setPrice("50mkd");

			Fruit fruit2 = new Fruit();
			fruit2.setId(2);
			fruit2.setName("Orange");
			fruit2.setPrice("60mkd");

			Fruit fruit3 = new Fruit();
			fruit3.setId(3);
			fruit3.setName("Watermelon");
			fruit3.setPrice("95mkd");

			Fruit fruit4 = new Fruit();
			fruit4.setId(4);
			fruit4.setName("Mango");
			fruit4.setPrice("120mkd");

			Fruits fr = new Fruits();
			fr.getFruits().add(fruit);
			fr.getFruits().add(fruit2);
			fr.getFruits().add(fruit3);
			fr.getFruits().add(fruit4);

			jaxbMarshaller.marshal(fr, new File("/Users/acev/Desktop/fruits.xml"));
		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
