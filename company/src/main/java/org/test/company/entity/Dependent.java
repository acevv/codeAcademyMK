package org.test.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "dependent")
public class Dependent  {

	@EmbeddedId
	private DependentId dependentId;

	@Column(name = "sex")
	private char dependentSex;

	@Column(name = "birth_date")
	private Date dependentDate;

	@Column(name = "relationship")
	private String relation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId("employeeId")
	private Employee employee;

	public DependentId getDependentId() {
		return dependentId;
	}

	public void setDependentId(DependentId dependentId) {
		this.dependentId = dependentId;
	}

	public char getDependentSex() {
		return dependentSex;
	}

	public void setDependentSex(char dependentSex) {
		this.dependentSex = dependentSex;
	}

	public Date getDependentDate() {
		return dependentDate;
	}

	public void setDependentDate(Date dependentDate) {
		this.dependentDate = dependentDate;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Dependent(char dependentSex, Date dependentDate, String relation, Employee employee, String name) {
		super();

		this.dependentSex = dependentSex;
		this.dependentDate = dependentDate;
		this.relation = relation;
		this.dependentId = new DependentId(employee.getSsn(), name);
	}

	public Dependent() {
		super();
	}

}
