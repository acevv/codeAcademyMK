package org.main.studentDB;

public class Profesor {

	String name;
	SubjectNames subject;
	String email;

	@Override
	public String toString() {
		return "Profesor [name=" + name + ", subject=" + subject + ", email=" + email + "]";
	}

	public Profesor() {
		super();
	}

	public Profesor(String name, SubjectNames subject, String email) {
		super();
		this.name = name;
		this.subject = subject;
		this.email = email;
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

}
