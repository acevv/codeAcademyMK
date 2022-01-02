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

	@Column(name = "first_name")
	private String name;

	@Column(name = "last_name")
	private String surname;

	@Column(name = "email")
	private String email;

	@Column(name = "city")
	private String city;

	@ManyToMany(targetEntity = Subject.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "studentSubject", joinColumns = { @JoinColumn(name = "index") }, inverseJoinColumns = {
			@JoinColumn(name = "subject_id") })
	private List<Subject> subjects;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student(Integer index, String name, String surname, String email, String city) {
		super();
		this.index = index;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.city = city;

	}

	public Student() {
		super();
	}

}
