package org.test.companyHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Column
	private String pname;

	@Column(name = "pnumber")
	@Id
	private Integer pnumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "plocation", referencedColumnName = "dlocation"),
		@JoinColumn(name = "dnum", referencedColumnName = "dnumber") })
	private DLocation dLocation;

	public Project() {
		super();
	}

	public Project(String pname, Integer pnumber, DLocation dLocation) {
		super();
		this.pname = pname;
		this.pnumber = pnumber;
		this.dLocation = dLocation;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	public DLocation getDLocation() {
		return this.dLocation;
	}

	public void setDLocation(DLocation dlocation) {
		this.dLocation = dlocation;
	}

}
