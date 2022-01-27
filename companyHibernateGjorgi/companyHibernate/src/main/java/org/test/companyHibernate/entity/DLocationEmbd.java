package org.test.companyHibernate.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class DLocationEmbd implements Serializable {

	private String dlocation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dnumber")
	Department department;

	public DLocationEmbd() {
		super();
	}

	public DLocationEmbd(String dlocation, Department department) {
		super();
		this.dlocation = dlocation;
		this.department = department;
	}

	public String getDlocation() {
		return this.dlocation;
	}

	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
