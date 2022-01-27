package org.test.companyHibernate.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name = "department")
public class Department {

	@Column(name = "dname")
	private String dname;

	@Column(name = "dnumber")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short dnumber;

	@OneToOne(targetEntity = org.test.companyHibernate.entity.Employee.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "mgr_ssn")
	private Employee mgrssn;

	@Column(name = "mgrstartdate")
	private Date mgrStartDate;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Short getDnumber() {
		return dnumber;
	}

	public void setDnumber(Short dnumber) {
		this.dnumber = dnumber;
	}

	public Employee getMgrssn() {
		return mgrssn;
	}

	public void setMgrssn(Employee mgrssn) {
		this.mgrssn = mgrssn;
	}

	public Date getMgrStartDate() {
		return mgrStartDate;
	}

	public void setMgrStartDate(Date mgrStartDate) {
		this.mgrStartDate = mgrStartDate;
	}

	public Department(String dname, Short dnumber, Date mgrStartDate) {
		super();
		this.dname = dname;
		this.dnumber = dnumber;
		this.mgrStartDate = mgrStartDate;

	}

	public Department() {
		super();
	}

}
