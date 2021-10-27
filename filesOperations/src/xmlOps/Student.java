package xmlOps;

import java.util.ArrayList;

public class Student {

	// Student(name, surname, email, phone, address, index, subjects, grades)

	private String name;
	private String surname;
	private Phone phone;
	private ArrayList<String> email;
	private Address address;
	private String index;
	private ArrayList<Subject> subjects;
	private ArrayList<Grade> grades;
	private Double gpa;

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", index=" + index + ", subjects=" + subjects + ", grades=" + grades + ", gpa=" + gpa + "]";
	}

	public Student() {
		super();
	}

	public Student(String name, String surname, Phone phone, ArrayList<String> email, Address address, String index,
			ArrayList<Subject> subjects, ArrayList<Grade> grades, Double gpa) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.index = index;
		this.subjects = subjects;
		this.grades = grades;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

}
