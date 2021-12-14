package org.test.student;

public class Student {
	private String indeks;
	private String name;
	private String surname;
	private Integer addressId;
	private String major;

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Student(String indeks, String name, String surname, Integer addressId, String major) {
		super();
		this.indeks = indeks;
		this.name = name;
		this.surname = surname;
		this.addressId = addressId;
		this.major = major;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [indeks=" + indeks + ", name=" + name + ", surname=" + surname + ", addressId=" + addressId
				+ ", major=" + major + "]";
	}

}
