package org.test.student;

import java.util.List;
import java.util.Set;

public interface StudentDAO {

	public String createStudentTable();

	public String createStudent(Student student);

	public Set<Student> getAllStudents();

	public String countStudents();

	public Student getStudentById(String id);

	public List<Student> getStudentsByMajor(String major);

	public List<StudentInfo> getStudentInfo();
}
