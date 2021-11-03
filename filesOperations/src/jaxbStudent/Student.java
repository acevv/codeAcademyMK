package jaxbStudent;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	// Student(name, surname, email, phone, address, index, subjects, grades)
	@XmlAttribute
	private String index;

	@XmlElement
	private String name;
	@XmlElement
	private String surname;
	@XmlElement
	private Phone phone;
	@XmlElement
	private ArrayList<String> email;
	@XmlElement
	private Address address;
	@XmlElement
	private ArrayList<Subject> subjects;
//	@XmlElement
//	private Predmet studenti;
	@XmlElement
	private ArrayList<Grade> grades;
	@XmlElement
	private Double gpa;

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", index=" + index + ", subjects= + subjects + "+ ", grades=" + grades + ", gpa=" + gpa + "]";
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
//		this.subjects = subjects;
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

//	public ArrayList<Subject> getSubjects() {
//		return subjects;
//	}

//	public void setSubjects(ArrayList<Subject> subjects) {
//		this.subjects = subjects;
//	}

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
