package org.acev.phonebook.entity;

public class ContactInfo {

	private String fName;
	private String lName;
	private Long embg;
	private String city;
	private String street;
	private String streetNumber;
	private String phoneNumber;

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

	public Long getEmbg() {
		return embg;
	}

	public void setEmbg(Long embg) {
		this.embg = embg;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ContactInfo(String fName, String lName, Long embg, String city, String street, String streetNumber,
			String phoneNumber) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.embg = embg;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.phoneNumber = phoneNumber;
	}

	public ContactInfo() {
		super();

	}

	@Override
	public String toString() {
		return "ContactInfo [fName=" + fName + ", lName=" + lName + ", embg=" + embg + ", city=" + city + ", street="
				+ street + ", streetNumber=" + streetNumber + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
