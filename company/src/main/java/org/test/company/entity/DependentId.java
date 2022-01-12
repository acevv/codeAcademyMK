package org.test.company.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DependentId implements Serializable {
	
	private long eSsn;
	private String dependentName;
	public long geteSsn() {
		return eSsn;
	}
	public void seteSsn(long eSsn) {
		this.eSsn = eSsn;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public DependentId(long eSsn, String dependentName) {
		super();
		this.eSsn = eSsn;
		this.dependentName = dependentName;
	}
	public DependentId() {
		super();
	}
	

}
