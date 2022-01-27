package org.test.companyHibernate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class WorksOnEmbd implements Serializable {

	@ManyToOne(targetEntity = org.test.companyHibernate.entity.Employee.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "essn")
	Employee employee;

	@ManyToOne(targetEntity = org.test.companyHibernate.entity.Project.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "pno")
	Project project;

	public WorksOnEmbd() {
		super();
	}

	public WorksOnEmbd(Employee employee, Project project) {
		super();
		this.employee = employee;
		this.project = project;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
