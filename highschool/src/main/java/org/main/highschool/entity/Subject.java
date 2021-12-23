package org.main.highschool.entity;

import javax.persistence.*;

import org.main.highschool.SubjectNames;

@Entity
@Table(name = "subject")
public class Subject {

	@Column(name = "subjectId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;

	@Column(name = "subjectName")
	private SubjectNames predmet;

	
	private Integer ocenka;

	@Column(name = "profesorId")
	private Integer profesorId;
	
	@OneToOne(targetEntity = Profesor.class)
	private Profesor profesor;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public SubjectNames getPredmet() {
		return predmet;
	}

	public void setPredmet(SubjectNames predmet) {
		this.predmet = predmet;
	}

	public Integer getOcenka() {
		return ocenka;
	}

	public void setOcenka(Integer ocenka) {
		this.ocenka = ocenka;
	}

	public Integer getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Integer profesorId) {
		this.profesorId = profesorId;
	}

	public Subject(SubjectNames predmet, Integer ocenka, Integer profesorId) {
		super();
		this.predmet = predmet;
		this.ocenka = ocenka;

		this.profesorId = profesorId;
	}

	public Subject() {
		super();
	}

}
