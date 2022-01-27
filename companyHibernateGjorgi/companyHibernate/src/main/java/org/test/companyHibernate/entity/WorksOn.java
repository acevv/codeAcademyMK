package org.test.companyHibernate.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "works_on")
public class WorksOn {

	@EmbeddedId
	WorksOnEmbd employeeProject;

	@Column
	Integer hours;

	public WorksOn() {
		super();
	}

	public WorksOn(WorksOnEmbd employeeProject, Integer hours) {
		super();
		this.employeeProject = employeeProject;
		this.hours = hours;
	}

	public WorksOnEmbd getEmployeeProject() {
		return this.employeeProject;
	}

	public void setEmployeeProject(WorksOnEmbd employeeProject) {
		this.employeeProject = employeeProject;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

}
