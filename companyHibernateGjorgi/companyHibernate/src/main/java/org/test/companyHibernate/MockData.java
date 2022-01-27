package org.test.companyHibernate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MockData {

	public static final long adultBStartDate = Timestamp.valueOf("1965-01-01 00:00:00").getTime();
	public static final long adultBEndDate = Timestamp.valueOf("1985-12-31 00:00:00").getTime();

	public static final long mgrStartDate = Timestamp.valueOf("2000-01-01 00:00:00").getTime();
	public static final long mgrEndDate = Timestamp.valueOf("2015-12-31 00:00:00").getTime();

	public static final long oneYear = Timestamp.valueOf("2001-01-01 00:00:00").getTime() - Timestamp.valueOf("2000-01-01 00:00:00").getTime();
	
	public static final char[] initials = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public static final String[] carMake = { "Audi", "VW", "BMW", "Daimler", "JLR" };

	public static final String[] locations = { "Skopje", "Dublin", "Dortmund" };

	public static final String[] deptNames = { "R&D", "Engineering", "Purchasing", "Quality" };

	// RainLightSensor, ShiftByWire, RoofModule, SteeringColumnSwitches,
	// OnBoardChargers
	public static final String[] productType = { "RLS", "SbW", "RM", "SCS", "OBC" };

	public static char getRandChar() {
		return initials[(int) (Math.random() * initials.length)];
	}

	public static void randProjectsNames(int numOfProjects, Set<String> projectNames) {
		Integer randCarMake;
		Integer randProductType;
		while (projectNames.size() != numOfProjects) {

			randCarMake = (int) Math.floor(Math.random() * carMake.length);
			randProductType = (int) Math.floor(Math.random() * productType.length);
			projectNames.add(carMake[randCarMake].concat("-").concat(productType[randProductType]));
		}
	}

	public static List<String> readNames(String filePath, String firstNameOrLastName)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File(filePath);
		Document doc = db.parse(file);
		doc.normalize();

		NodeList list = doc.getElementsByTagName(firstNameOrLastName);
		List<String> names = new ArrayList<>();

		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeName() == firstNameOrLastName)
				names.add(list.item(i).getTextContent());
		}

		return names;
	}

	public static char maleOrFemale() {
		if (Math.random() < 0.5)
			return 'M';
		else
			return 'F';
	}

	public static List<String> readAddresses(String filePath) throws IOException {
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		List<String> addresses = new ArrayList<>();
		while (line != null) {
			addresses.add(line);
			line = br.readLine();
		}

		br.close();
		return addresses;
	}

	public static Date randDateBetween(long startDate, long endDate) {
		return new Date(startDate + (long) ((endDate - startDate) * Math.random()));
	}

	public static Integer randomSalary() {
		return 50000 + (int) ((90000 - 50000) * Math.random());
	}

	public static Set<Long> generateSsns(int numOfEmpls) {
		Set<Long> ssns = new HashSet<>();
		Long ssn;
		while (ssns.size() != numOfEmpls) {
			ssn = 100000000L + (long) ((999999999L - 100000000L) * Math.random());
			ssns.add(ssn);
		}

		return ssns;
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		List<String> maleNames = readNames("src\\main\\resources\\males.xml", "firstName");
		List<String> femaleNames = readNames("src\\main\\resources\\females.xml", "firstName");
		List<String> lastNames = readNames("src\\main\\resources\\lastnames.xml", "lastName");

		System.out.println(maleNames);
		System.out.println(femaleNames);
		System.out.println(lastNames);

		List<String> addresses = readAddresses("src\\main\\resources\\MOCK_ADDRESS.txt");
		System.out.println(addresses);

	}

}
