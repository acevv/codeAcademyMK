package org.test.company.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WorksOnId implements Serializable {
	
	
	private long eSsn;
	
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
