package org.test.dbConn;

public class Address {

	private Integer id;
	private String street;
	private String number;
	private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address(Integer id, String street, String number, String city) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
	}

	public Address() {
		super();
	}

}
