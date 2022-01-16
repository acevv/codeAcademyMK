package org.test.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class DepartmentLocationsId implements Serializable {

	@Column(name = "department_number")
	private Integer dNumber;

	@Column(name = "location")
	private String dLocation;

	public Integer getdNumber() {
		return dNumber;
	}

	public void setdNumber(Integer dNumber) {
		this.dNumber = dNumber;
	}

	public String getdLocation() {
		return dLocation;
	}

	public void setdLocation(String dLocation) {
		this.dLocation = dLocation;
	}

	public DepartmentLocationsId(Integer dNumber, String dLocation) {
		super();
		this.dNumber = dNumber;
		this.dLocation = dLocation;
	}

	public DepartmentLocationsId() {
		super();
	}

}