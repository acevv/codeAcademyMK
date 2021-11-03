package totalPriceExample;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jaxbExample.Fruit;
import jaxbExample.Fruits;

public class TotalPriceFruits {

	public static void main(String[] args) {

		System.out.println("Total price: " + totalPrice("/Users/acev/Desktop/fruits.xml"));
//		getPriceAsInt();

	}

	private static Integer getPriceAsInt(String priceWithMkd) {

		Integer x = 0;

		if (priceWithMkd.endsWith("mkd")) {

			char[] listFromStrings = priceWithMkd.toCharArray();
			Integer length = listFromStrings.length;

			String value = priceWithMkd.substring(0, length - 3);

			Integer value2 = Integer.parseInt(value);
			x += value2;
		}
		return x;

	}

	private static Integer totalPrice(String filePath) {

		File file = new File(filePath);
		Fruits f = new Fruits();

		try {
			JAXBContext context = JAXBContext.newInstance(Fruits.class);

			Unmarshaller unmarshaller = context.createUnmarshaller();

			f = (Fruits) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		Integer price = 0;
		for (Fruit fruit : f.getFruits()) {

//			if (fruit.getPrice().endsWith("mkd")) {
//
//				char[] listFromStrings = fruit.getPrice().toCharArray();
//				Integer length = listFromStrings.length;
//
//				String value = fruit.getPrice().substring(0, length - 3);
//
//				Integer value2 = Integer.parseInt(value);
//				price += value2;
//			}
			price += getPriceAsInt(fruit.getPrice());
		}
		return price;
	}

}
