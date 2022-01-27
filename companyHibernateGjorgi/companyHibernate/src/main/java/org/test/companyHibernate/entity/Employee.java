package org.test.companyHibernate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Column(name = "fname")
	private String fname;

	@Column(name = "minit")
	private char minit;

	@Column(name = "lname")
	private String lname;

	@Column(name = "ssn")
	@Id
	private Long ssn; // pkey

	@Column(name = "bdate")
	private Date bdate;

	@Column(name = "address")
	private String address;
	@Column(name = "sex")
	private char sex;

	@Column(name = "salary")
	private Integer salary;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "superssn", nullable = true)
	private Employee superssn; // fkey from employee table --> referencing from same table

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dno", nullable = false)
	private Department dno; // fkey from department table

	public Employee() {
		super();
	}

	public Employee(String fname, char minit, String lname, Long ssn, Date bdate, String address, char sex,
			Integer salary) {
		super();
		this.fname = fname;
		this.minit = minit;
		this.lname = lname;
		this.ssn = ssn;
		this.bdate = bdate;
		this.address = address;
		this.sex = sex;
		this.salary = salary;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public char getMinit() {
		return minit;
	}

	public void setMinit(char minit) {
		this.minit = minit;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employee getSuperssn() {
		return superssn;
	}

	public void setSuperssn(Employee superssn) {
		this.superssn = superssn;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

}
