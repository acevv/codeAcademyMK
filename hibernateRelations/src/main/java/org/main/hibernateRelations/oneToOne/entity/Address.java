package org.main.hibernateRelations.oneToOne.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "street", nullable = false)
	private String sreet;

	@Column(name = "number")
	private Integer number;

	@Column(name = "city")
	private String city;

	@OneToOne(targetEntity = org.main.hibernateRelations.oneToOne.entity.Student.class, cascade = CascadeType.ALL)
	private Student student;

	public String getSreet() {
		return sreet;
	}

	public void setSreet(String sreet) {
		this.sreet = sreet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Address(String sreet, String city, Integer number) {
		super();
		this.sreet = sreet;
		this.city = city;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address() {
		super();
	}

}
