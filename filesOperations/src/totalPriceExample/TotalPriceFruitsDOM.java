package totalPriceExample;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TotalPriceFruitsDOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		File f = new File("/Users/acev/Desktop/fruits.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);

		doc.getDocumentElement().normalize();

		// read root element doc locate root get root eleement name
		System.out.println("Root element:" + doc.getDocumentElement().getNodeName());

		// array od student elementi
		NodeList list = doc.getElementsByTagName("student");

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				
				
			}

		}

	}

}
