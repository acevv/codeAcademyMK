 package org.main.highschool.entity;

import javax.persistence.*;

import org.main.highschool.SubjectNames;

@Entity
@Table(name = "profesor")
public class Profesor {

	@Column(name = "profesorId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer profesorId;
	
	@Column(name = "profesorName")
	private String name;
	
	@Column(name = "subject")
	private SubjectNames subject;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(targetEntity = Subject.class, cascade = CascadeType.ALL)
	private Subject predmet;

	public Integer getProfesorId() {
		return profesorId;
	}

	public Subject getPredmet() {
		return predmet;
	}

	public void setPredmet(Subject predmet) {
		this.predmet = predmet;
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

	public SubjectNames getSubject() {
		return subject;
	}

	public void setSubject(SubjectNames subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profesor(String name, SubjectNames subject, String email) {
		super();
		this.name = name;
		this.subject = subject;
		this.email = email;
	}

	public Profesor() {
		super();
	}

	



}
