package org.test.soapExample.entity;

public class Person {

	private Integer id;
	private String fName;
	private String lName;
	private String location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Person(Integer id, String fName, String lName, String location) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.location = location;
	}

	public Person() {
		super();
	}

}
