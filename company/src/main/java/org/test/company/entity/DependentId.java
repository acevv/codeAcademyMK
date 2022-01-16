package org.test.company.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class DependentId implements Serializable {

	@Column(name = "employee_ssn")
	private long ssn;

	@Column(name = "dependent_name")
	private String dependentName;

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public DependentId(long ssn, String dependentName) {
		super();
		this.ssn = ssn;
		this.dependentName = dependentName;
	}

	public DependentId() {
		super();
	}

}
