package org.test.companyHibernate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class DependentEmbd implements Serializable {

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "essn")
	private Employee essn;

	@Column(name = "dependent_name", length = 25)
	private String dependentName;

	public Employee getEssn() {
		return essn;
	}

	public void setEssn(Employee essn) {
		this.essn = essn;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public DependentEmbd(Employee essn, String dependentName) {
		super();
		this.essn = essn;
		this.dependentName = dependentName;
	}

	public DependentEmbd() {
		super();
	}

}
