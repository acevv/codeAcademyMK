package org.main.studentDB;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private Integer index;
	private String name;
	private String surname;
	private City city;
	private List<Subject> subject = new ArrayList<>();

	public Student(Integer index, String name, String surname, City city, List<Subject> subject) {
		super();
		this.index = index;
		this.surname = surname;
		this.name = name;
		this.city = city;
		this.subject = subject;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public City getCity() {
		return this.city;
	}

	public Subject getMakedonski() {

		return subject.get(1);

	}

	public Subject getMatematika() {

		return subject.get(0);

	}

	public Subject getFizika() {

		return subject.get(3);

	}

	public Subject getIstorija() {

		return subject.get(2);

	}

	@Override
	public String toString() {
		return "Student [index=" + index + ", name=" + name + ", surname=" + surname + ", city=" + city + subject + "]\n";
	}

	public Student() {
		super();
	}
	
	

}
