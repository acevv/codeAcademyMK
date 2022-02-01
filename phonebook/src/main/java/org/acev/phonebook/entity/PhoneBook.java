package org.acev.phonebook.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phonebook")
public class PhoneBook {

	@Id
	private Integer phoneNumber;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "country_code")
	private CountryCode countryCode;

	@ManyToOne
	@JoinColumn(name = "city_code")
	private CityAreaCode cityAreaCode;

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}

	public CityAreaCode getCityAreaCode() {
		return cityAreaCode;
	}

	public void setCityAreaCode(CityAreaCode cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}

	public PhoneBook(Integer phoneNumber, Person person, CountryCode countryCode, CityAreaCode cityAreaCode) {
		super();
		this.phoneNumber = phoneNumber;
		this.person = person;
		this.countryCode = countryCode;
		this.cityAreaCode = cityAreaCode;
	}

	public PhoneBook() {
		super();
	}

}
