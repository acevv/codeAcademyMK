package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ArticlesJAXB {

	public void marshall(Articles articles) {

		try {
			JAXBContext jc = JAXBContext.newInstance(Articles.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(articles, new File("/Users/acev/Desktop/products.xml"));

		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	public Articles unmarshall(String filePath) {

		Articles articlesList = new Articles();

		try {

			JAXBContext jc = JAXBContext.newInstance(Articles.class);
			File f = new File(filePath);
			Unmarshaller ums = jc.createUnmarshaller();
			Articles articles = (Articles) ums.unmarshal(f);
			articlesList = articles;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return articlesList;

	}

}
