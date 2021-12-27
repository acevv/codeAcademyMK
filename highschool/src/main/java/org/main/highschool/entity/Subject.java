package org.main.highschool.entity;

import java.util.List;

import javax.persistence.*;

import org.main.highschool.SubjectNames;

@Entity
@Table(name = "subject")
public class Subject {

	@Column(name = "subjectId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;

	@Column(name = "subject_name")
	private String predmet;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private List<Profesor> profesor;

	private Integer ocenka;
	private boolean polozen;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getPredmet() {
		return predmet;
	}

	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}

	public List<Profesor> getProfesor() {
		return profesor;
	}

	public void setProfesor(List<Profesor> profesor) {
		this.profesor = profesor;
	}

	public Integer getOcenka() {
		return ocenka;
	}

	public void setOcenka(Integer ocenka) {
		this.ocenka = ocenka;
	}

	public boolean isPolozen() {
		return polozen;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

	public Subject(String predmet) {
		super();
		this.predmet = predmet;
	}

	public Subject() {
		super();
	}

}
