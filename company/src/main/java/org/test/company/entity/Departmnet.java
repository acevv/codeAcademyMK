package org.test.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Departmnet {

	@Column(name = "name")
	private String dName;

	@Id
	@Column(name = "number")
	private Integer dNumber;

	@Column(name = "super_ssn")
	private long superSsn;

	@Column(name = "start_date")
	private Date dDate;

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Integer getdNumber() {
		return dNumber;
	}

	public void setdNumber(Integer dNumber) {
		this.dNumber = dNumber;
	}

	public long getSuperSsn() {
		return superSsn;
	}

	public void setSuperSsn(long superSsn) {
		this.superSsn = superSsn;
	}

	public Date getdDate() {
		return dDate;
	}

	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}

	public Departmnet(String dName, Integer dNumber, long superSsn, Date dDate) {
		super();
		this.dName = dName;
		this.dNumber = dNumber;
		this.superSsn = superSsn;
		this.dDate = dDate;
	}

	public Departmnet() {
		super();
	}

}
