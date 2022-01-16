package org.test.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class WorksOnId implements Serializable {
	
	@Column(name = "employee_ssn")
	private long eSsn;
	
	@Column(name = "project_number")
	private Integer pNumber;

	public WorksOnId(long eSsn, Integer pNumber) {
		super();
		this.eSsn = eSsn;
		this.pNumber = pNumber;
	}

	public WorksOnId() {
		super();
	}
	
	

}
