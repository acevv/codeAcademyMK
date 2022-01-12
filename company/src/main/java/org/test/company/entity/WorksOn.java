package org.test.company.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "works_on")
public class WorksOn {

	@EmbeddedId
	private WorksOnId worksOnId;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eSsn")
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pNumber")
	private Project project;

	
	private double hours;

}
