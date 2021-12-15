package org.main.studentDB;

import java.util.List;

public interface StudentDAO {
	
	
	public List<Student> readStudent(String csvPath);
	public void printStudents();
	public void createStudentTable();
	public String createProfesorTable();
	public String createSubjectTabe();
	public void insertStudents(List<Student> students);
	public void insertSubject(List<Student> students);
	public void insertProfesor(List<Student> students);
	
	
	
	public void createStudentSubjectTable();
	public void insertOcenka(List<Student> students);
	
	public void searchPolozenPoPredmet (SubjectNames s, Integer ocenka);
	public void searchProfesor (Integer index, SubjectNames s);
	

}
