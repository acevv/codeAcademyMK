package org.test.student;

import java.util.Set;

public interface StudentDAO {

	public String createStudentTable();
	public String createStudent(Student student);
	public Set getAllStudents();
	
	public String countStudents();
	public Student getStudentById(Integer id);
	
	



}
