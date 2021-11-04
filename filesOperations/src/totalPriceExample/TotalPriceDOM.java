package totalPriceExample;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TotalPriceDOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File f = new File("/Users/acev/Desktop/fruits.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		
		NodeList list = doc.getElementsByTagName("fruits");
		
		Integer totalPrice = 0;
		
		
		for (int i = 1; i < list.getLength(); i++) { // zosto koga e i=0 dva pati go cita prviot element ?
			
			Node node = list.item(i);
//			System.out.println("Node name: "+ node.getNodeName());
			
			if (node.getNodeType() == Node.ELEMENT_NODE) { 
				Element e = (Element) node;
				
				System.out.println("Fruit ID: " + e.getAttribute("id"));
				
				String name = e.getElementsByTagName("ovoshje").item(0).getTextContent();
				System.out.println("Name: " + name);
				
				String price = e.getElementsByTagName("price").item(0).getTextContent();
				System.out.println("Price: " + price);
				
				totalPrice += getPriceAsInt(price);
			}
		}
		
		System.out.println("\nTotal price of fruits: "+ totalPrice);
		
		
		

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

}
