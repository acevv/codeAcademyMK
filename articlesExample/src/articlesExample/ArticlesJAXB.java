package articlesExample;

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

	public Articles unmarshall() {

		Articles art = new Articles();

		try {

			JAXBContext jc = JAXBContext.newInstance(Articles.class);
			File f = new File(
					"/Users/acev/Documents/DESKTOP!/ACEV Aleksandar/Coding Material/CodeAcademy Mk 2021/Home Work/HW 1/products.xml");
			Unmarshaller ums = jc.createUnmarshaller();
			Articles article = (Articles) ums.unmarshal(f);
			art = article;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return art;

	}

}
