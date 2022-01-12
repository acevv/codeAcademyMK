package org.test.company.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Column(name = "first_name")
	private String fName;

	@Column(name = "m_init")
	private char mInit;

	@Column(name = "last_name")
	private String lName;

	@Id
	@Column(name = "ssn")
	private long ssn;

	@Column(name = "birth_date")
	private Date bDate;

	@Column(name = "address")
	private String address;

	@Column(name = "sex")
	private char sex;

	@Column(name = "salary")
	private Integer salary;

	@Column(name = "super_ssn")
	private long superSsn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Departmnet department;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_ssn")
	private List<Dependent> dependents;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
	private List<WorksOn> worksOn;

	
	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public List<WorksOn> getWorksOn() {
		return worksOn;
	}

	public void setWorksOn(List<WorksOn> worksOn) {
		this.worksOn = worksOn;
	}

	public Departmnet getDepartment() {
		return department;
	}

	public void setDepartment(Departmnet department) {
		this.department = department;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public char getmInit() {
		return mInit;
	}

	public void setmInit(char mInit) {
		this.mInit = mInit;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
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

	public long getSuperSsn() {
		return superSsn;
	}

	public void setSuperSsn(long superSsn) {
		this.superSsn = superSsn;
	}

	public Employee(String fName, char mInit, String lName, long ssn, Date bDate, String address, char sex,
			Integer salary, long superSsn) {
		super();
		this.fName = fName;
		this.mInit = mInit;
		this.lName = lName;
		this.ssn = ssn;
		this.bDate = bDate;
		this.address = address;
		this.sex = sex;
		this.salary = salary;
		this.superSsn = superSsn;

	}

	public Employee() {
		super();
	}

}
