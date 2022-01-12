package org.test.company.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
	private List<WorksOn> worksOn;

//	private Integer dNumber;

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

	public Project(String pName, Integer pNumber, String pLocation) {
		super();
		this.pName = pName;
		this.pNumber = pNumber;
		this.pLocation = pLocation;

	}

	public Project() {
		super();
	}

}
