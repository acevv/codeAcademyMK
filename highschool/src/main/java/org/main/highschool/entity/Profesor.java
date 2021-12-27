package org.main.highschool.entity;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

	@Column(name = "profesor_Id")
	@Id
	private Integer profesorId;

	@Column(name = "profesor_Name")
	private String name;

	@Column(name = "subject")
	private String subject;

	@Column(name = "email")
	private String email;

	public Integer getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Integer profesorId) {
		this.profesorId = profesorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profesor(Integer profesorId, String name, String subject, String email) {
		super();
		this.profesorId = profesorId;
		this.name = name;
		this.subject = subject;
		this.email = email;
	}

	public Profesor() {
		super();
	}

}
