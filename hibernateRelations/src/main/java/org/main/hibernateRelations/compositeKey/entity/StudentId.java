package org.main.hibernateRelations.compositeKey.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentId implements Serializable {

	
	private long id;

	private String index;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public StudentId(long id, String index) {
		super();
		this.id = id;
		this.index = index;
	}

	public StudentId() {
		super();
	}

	
	
}
