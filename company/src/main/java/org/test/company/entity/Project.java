package org.test.company.entity;

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
@Table(name = "project")
public class Project {

	@Column(name = "name")
	private String pName;

	@Id
	@Column(name = "number")
	private Integer pNumber;


	@Column(name = "location")
	private String pLocation;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "department_number", nullable = true)
	private Departmnet department;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
	private List<WorksOn> worksOn;

	public Departmnet getDepartment() {
		return department;
	}

	public void setDepartment(Departmnet department) {
		this.department = department;
	}

	public List<WorksOn> getWorksOn() {
		return worksOn;
	}

	public void setWorksOn(List<WorksOn> worksOn) {
		this.worksOn = worksOn;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpNumber() {
		return pNumber;
	}

	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}

	public String getpLocation() {
		return pLocation;
	}

	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}

	public Project(String pName, Integer pNumber, String pLocation, Departmnet department) {
		super();
		this.pName = pName;
		this.pNumber = pNumber;
		this.pLocation = pLocation;
		this.department = department;

	}

	public Project() {
		super();
	}

}
