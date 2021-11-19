package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ProductsJAXB {

	public Products unmarshall(String filePath) {

		Products productsList = new Products();

		try {

			JAXBContext jc = JAXBContext.newInstance(Products.class);
			File f = new File(filePath);
			Unmarshaller ums = jc.createUnmarshaller();
			Products products = (Products) ums.unmarshal(f);
			productsList = products;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productsList;

	}

	public void marshall(Products products) {

		try {
			JAXBContext jc = JAXBContext.newInstance(Products.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(products, new File("/Users/acev/Desktop/test/newProducts.xml"));

		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
