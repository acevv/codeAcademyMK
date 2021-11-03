package totalPriceExample;

import java.io.File;
import java.io.IOException;

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

		System.out.println("Root element:" + doc.getDocumentElement().getNodeName());

		NodeList list = doc.getElementsByTagName("ovoshje");

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			System.out.println("Node name: " + node.getNodeName());
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				System.out.println(e);
			}

		}

	}

}
