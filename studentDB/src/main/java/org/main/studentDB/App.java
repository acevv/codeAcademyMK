package org.main.studentDB;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		StudentDAO start = new StudentDAOImpl();
		students = start.readStudent("Resources/data.txt");

//		start.printStudents();

//      start.createStudentTable();

//		start.insertStudents(students);

//		start.createProfesorTable();

//		start.createSubjectTabe();
//		start.insertProfesor(students);
//		start.insertSubject(students);
//		start.createStudentSubjectTable();
//		start.insertOcenka(students);
//		start.searchPolozenPoPredmet(SubjectNames.Istorija, 9);
		start.searchProfesor(1479, SubjectNames.Istorija);

	}
}
