package org.acev.phonebook.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	private Long embg;

	private String firstName;
	private String lastName;

	public Long getEmbg() {
		return embg;
	}

	public void setEmbg(Long embg) {
		this.embg = embg;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person(Long embg, String firstName, String lastName) {
		super();
		this.embg = embg;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public Person() {
		super();
	}

}
