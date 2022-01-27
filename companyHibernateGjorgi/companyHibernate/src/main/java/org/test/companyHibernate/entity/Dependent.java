package org.test.companyHibernate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dependent")
public class Dependent {

	@EmbeddedId
	DependentEmbd essnDependent;

	@Column(name = "sex")
	private char sex;

	@Column(name = "bdate")
	private Date bDate;

	@Column(name = "relationship", length = 25)
	private String relationship;

	public Dependent() {
		super();
	}

	public Dependent(DependentEmbd essnDependent, char sex, Date bDate, String relationship) {
		super();
		this.essnDependent = essnDependent;
		this.sex = sex;
		this.bDate = bDate;
		this.relationship = relationship;
	}

	public DependentEmbd getEssnDependent() {
		return essnDependent;
	}

	public void setEssnDependent(DependentEmbd essnDependent) {
		this.essnDependent = essnDependent;
	}

	public char getSex() {
		return this.sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getBdate() {
		return this.bDate;
	}

	public void setBdate(Date bDate) {
		this.bDate = bDate;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}
