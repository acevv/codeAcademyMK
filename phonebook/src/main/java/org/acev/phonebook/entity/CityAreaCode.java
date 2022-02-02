package org.acev.phonebook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city_code")
public class CityAreaCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cityAreaCode;
	private String cityLocalAreaCode;
	private String cityName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityAreaCode() {
		return cityAreaCode;
	}

	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}

	public String getCityLocalAreaCode() {
		return cityLocalAreaCode;
	}

	public void setCityLocalAreaCode(String cityLocalAreaCode) {
		this.cityLocalAreaCode = cityLocalAreaCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public CityAreaCode(String cityAreaCode, String cityLocalAreaCode, String cityName) {
		super();

		this.cityAreaCode = cityAreaCode;
		this.cityLocalAreaCode = cityLocalAreaCode;
		this.cityName = cityName;
	}

	public CityAreaCode() {
		super();
	}

}
