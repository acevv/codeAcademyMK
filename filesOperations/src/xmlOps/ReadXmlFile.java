package xmlOps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlFile {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

		// Student(name, surname, email, phone, address, index, subjects, grades)
		// Address(street, number, city
		// Phone(mobile, work, home)
		// Subjects(name, schedule, books, professor)
		// Grades(Subject, grade, Student)

		Student student1 = new Student();
		Address adresa = new Address();
		Phone phone = new Phone();
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<Subject> subjects = new ArrayList<Subject>();

		student1.setName("Aleksandar");
		student1.setSurname("Acev");
		student1.setIndex("123/2021");

		adresa.setCity("Strumica");
		adresa.setNumber("20");
		adresa.setStreet("Partizanska");
		student1.setAddress(adresa);

		phone.setHome("034300200");
		phone.setMobile("075275255");
		phone.setWork("072381282");
		student1.setPhone(phone);

		emails.add("aleksandar@email.com");
		emails.add("a.acev@email.com");
		emails.add("acev@email.com");
		student1.setEmail(emails);

// Subject 1
		Subject matematika1 = new Subject();
		matematika1.setName("Matematika");
		matematika1.setSchedule("Ponedelnik, Sreda, Petok");

		ArrayList<Book> knigi = new ArrayList<Book>();

		Book kniga1 = new Book();
		kniga1.setName("Funkcionalni redovi");
		kniga1.setAuthor("Goran Stanic");

		knigi.add(kniga1);
		matematika1.setBooks(knigi);

		Professor profMat = new Professor();
		profMat.setName("Aleksandar");
		profMat.setSurname("Smilevski");
		profMat.setEmail("asmilevski@email.com");

		matematika1.setProfessor(profMat);

		subjects.add(matematika1);

// Subject 2
		Subject programiranje = new Subject();
		programiranje.setName("programiranje 1");
		programiranje.setSchedule("Ponedelnik, Sreda");

		ArrayList<Book> knigiProgramiranje = new ArrayList<>();

		Book java = new Book();
		java.setName("Java fundamentals");
		java.setAuthor("Goran Trajkov");

		knigiProgramiranje.add(java);
		programiranje.setBooks(knigiProgramiranje);

		Professor profProg = new Professor();
		profProg.setName("Dimitar");
		profProg.setSurname("Josifov");
		profProg.setEmail("jdimitar@gmail.com");

		programiranje.setProfessor(profProg);

		subjects.add(programiranje);

		student1.setSubjects(subjects);

		ArrayList<Grade> oceni = new ArrayList<>();

		Grade ocenaMat = new Grade();
		ocenaMat.setStudentIndex(student1.getIndex());
		ocenaMat.setSubject(matematika1);
		ocenaMat.setGrade(8);

		Grade ocenaProg = new Grade();
		ocenaProg.setStudentIndex(student1.getIndex());
		ocenaProg.setSubject(programiranje);
		ocenaProg.setGrade(10);

		oceni.add(ocenaProg);
		oceni.add(ocenaMat);

		student1.setGrades(oceni);

		Double gpa = prosek(student1.getGrades());

		student1.setGpa(gpa);

		System.out.println(student1.toString());

//		 read XML file
		File f = new File("resources/exampleStudent1.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);

//		doc.getDocumentElement().normalize(); - zosto sluzi ova ?

		// read root element doc locate root get root eleement name
		System.out.println("Root element:" + doc.getDocumentElement().getNodeName());

		// array od student elementi
		NodeList list = doc.getElementsByTagName("student");

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			System.out.println("Node name: " + node.getNodeName());

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;

				String name = e.getElementsByTagName("name").item(0).getTextContent();
				System.out.println("Name: " + name);

				String surname = e.getElementsByTagName("surname").item(0).getTextContent();
				System.out.println("Surname: " + surname);

				String index = e.getElementsByTagName("index").item(0).getTextContent();
				System.out.println("Index: " + index);

				// gpa1 bidejki pogore imame ista promenliva gpa
				String gpa1 = e.getElementsByTagName("gpa").item(0).getTextContent();
				System.out.println("GPA: " + gpa1);

				NodeList adrList = doc.getElementsByTagName("address");
				for (int j = 0; j < adrList.getLength(); j++) {
					Node node2 = adrList.item(j);
					System.out.print("Adresa: ");

					if (node2.getNodeType() == Node.ELEMENT_NODE) {
						Element e2 = (Element) node2;

						String street = e2.getElementsByTagName("street").item(0).getTextContent();
						System.out.print("Street: " + street);

						String city = e2.getElementsByTagName("city").item(0).getTextContent();
						System.out.print(", City: " + city);

						String number = e2.getElementsByTagName("number").item(0).getTextContent();
						System.out.println(", Number: " + number);
					}
				}

				NodeList phoneList = doc.getElementsByTagName("phone");
				for (int j2 = 0; j2 < phoneList.getLength(); j2++) {
					Node node3 = phoneList.item(j2);
					System.out.print("Phone: ");

					if (node3.getNodeType() == Node.ELEMENT_NODE) {
						Element e3 = (Element) node3;

						String mobile = e3.getElementsByTagName("mobile").item(0).getTextContent();
						System.out.print("Mobile: " + mobile);

						String work = e3.getElementsByTagName("work").item(0).getTextContent();
						System.out.print(", Work: " + work);

						String home = e3.getElementsByTagName("home").item(0).getTextContent();
						System.out.println(", Home: " + home);
					}
				}

				String email1 = e.getElementsByTagName("emails").item(0).getTextContent();
				System.out.println("Email: " + email1);

				String email2 = e.getElementsByTagName("emails").item(1).getTextContent();
				System.out.println("Email: " + email2);

				String email3 = e.getElementsByTagName("emails").item(2).getTextContent();
				System.out.println("Email: " + email3);

				NodeList subjectsList = doc.getElementsByTagName("subjects");
				for (int j3 = 0; j3 < subjectsList.getLength(); j3++) {
					Node node4 = subjectsList.item(j3);
					System.out.print("Subjects: ");

					if (node4.getNodeType() == Node.ELEMENT_NODE) {
						Element e4 = (Element) node4;

						String subject1 = e4.getElementsByTagName("subject").item(0).getTextContent();
						System.out.print("Predmet 1: " + subject1);

						String subject2 = e4.getElementsByTagName("subject").item(1).getTextContent();
						System.out.print("Predmet 2: " + subject2);
					}
				}

				NodeList gradesList = doc.getElementsByTagName("grades");

				for (int j4 = 0; j4 < gradesList.getLength(); j4++) {
					Node node5 = gradesList.item(j4);
					System.out.print("Grades: ");

					if (node5.getNodeType() == Node.ELEMENT_NODE) {
						Element e5 = (Element) node5;

						String grade1 = e5.getElementsByTagName("grade").item(0).getTextContent();
						System.out.print("Grade 1: " + grade1);

						// .item(0) e objektot <grade> a .item(1) e variablata grade vo objektot grade
						// isto i so .item(2) i .item(3)

						System.out.println(
								"Grade for subject 1: " + e5.getElementsByTagName("grade").item(1).getTextContent());

						String grade2 = e5.getElementsByTagName("grade").item(2).getTextContent();
						System.out.print("Grade 2: " + grade2);

						System.out.println(
								"Grade for subject 2: " + e5.getElementsByTagName("grade").item(3).getTextContent());
					}
				}

			}

		}

		XPathFactory xpf = XPathFactory.newInstance();
		XPath xp = xpf.newXPath();
		String subject = (String) xp.evaluate("student/subjects/subject", doc, XPathConstants.STRING);
		System.out.println("XPATH FACTORY" + subject);

		getBook(xp, "student/surname", doc);

	}

	private static void getBook(XPath xp, String path, Document doc) throws XPathExpressionException {
		String element = (String) xp.evaluate(path, doc, XPathConstants.STRING);
		System.out.println(element);
	}

	private static Double prosek(ArrayList<Grade> grades) {
		Double sum = 0.00;
		Double gpa = 0.00;

		for (Grade ocena : grades) {
			sum += ocena.getGrade();
		}
		gpa = sum / grades.size();
		return gpa;
	}

}
