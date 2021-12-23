package org.main.highschool.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.main.highschool.City;

@Entity
@Table(name = "student")
public class Student {

	@Column(name = "index")
	@Id
	private Integer index;

	@Column(name = "firstName")
	private String name;

	@Column(name = "surName")
	private String surname;

	@Column(name = "city")
	private City city;

	@ManyToMany(targetEntity = Subject.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "studentSubject", joinColumns = { @JoinColumn(name = "index") }, inverseJoinColumns = {
			@JoinColumn(name = "subjectId") })
	private List<Subject> subjects = new ArrayList<>();

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student(Integer index, String name, String surname, City city, List<Subject> subjects) {
		super();
		this.index = index;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.subjects = subjects;
	}

	public Student() {
		super();
	}

}
