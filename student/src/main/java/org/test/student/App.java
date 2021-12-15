package org.test.student;

import java.util.List;

public class App {
	public static void main(String[] args) {
		AddressDAO addressDAO = new AddressDAOImpl();
//    	System.out.println(addressDAO.createAddressTable());

		StudentDAO studentDAO = new StudentDAOImpl();
//    	System.out.println(studentDAO.createStudentTable());

//		Address add = new Address(3, "Ilindenska", "11", "Skopje");
//    	addressDAO.createAddress(add);

//		Student st1 = new Student("333", "Ognen", "Ilioski", add.getId(), "CS");
//    	studentDAO.createStudent(st1);

//		studentDAO.getAllStudents();
//		System.out.println(addressDAO.getAddressById(1).toString());

//		System.out.println(studentDAO.countStudents());
//
//		Student s2 = new Student();
//		s2 = studentDAO.getStudentById("333");
//		System.out.println(s2.toString());

//		List<Student> studentWithSameMajor = studentDAO.getStudentsByMajor("CS");
//		for (Student student : studentWithSameMajor) {
//			System.out.println(student);
//		}
		
		List<StudentInfo> studentsInfo = studentDAO.getStudentInfo();
		for (StudentInfo studentInfo : studentsInfo) {
			System.out.println(studentInfo);
		}
	}
}
