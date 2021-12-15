package org.main.studentDB;

public class Subject {

	private SubjectNames predmet;
	private Integer ocenka;
	private boolean polozen;
	private Profesor profesor;

	@Override
	public String toString() {
		return "\n Subject [predmet=" + predmet + ", ocenka=" + ocenka + ", polozen=" + polozen + ", profesor=" + profesor
				+ "]";
	}

	public Subject(SubjectNames predmet, Integer ocenka, Profesor profesor) {
		this.predmet = predmet;
		this.ocenka = ocenka;
		if (ocenka > 5)
			polozen = true;
		else
			polozen = false;
		this.profesor = profesor;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public void setOcenka(Integer ocenka) {
		this.ocenka = ocenka;
	}

	public SubjectNames getPredmet() {
		return predmet;
	}

	public void setPredmet(SubjectNames predmet) {
		this.predmet = predmet;
	}

	public int getOcenka() {
		return ocenka;
	}

	public void setOcenka(int ocenka) {
		this.ocenka = ocenka;
	}

	public boolean isPolozen() {
		if (ocenka > 5) {
			return true;
		}
		return false;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

}
