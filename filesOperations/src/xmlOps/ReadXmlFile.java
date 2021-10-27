package xmlOps;

import java.util.ArrayList;

public class ReadXmlFile {

	public static void main(String[] args) {
		
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
		
		// read XML file
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		
//		File f = new File("resources/exampleStudent1.xml");
//		
//		Document doc = db.parse(f);
		
		
		
		
		
		
		
			
			
		
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
