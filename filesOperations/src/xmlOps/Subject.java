package xmlOps;

import java.util.ArrayList;

public class Subject {

	// Subjects(name, schedule, books, professor)

	private String name;
	private String schedule;
	private ArrayList<Book> books;
	private Professor professor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Subject(String name, String schedule, ArrayList<Book> books, Professor professor) {
		super();
		this.name = name;
		this.schedule = schedule;
		this.books = books;
		this.professor = professor;
	}

	public Subject() {
		super();
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", schedule=" + schedule + ", books=" + books + ", professor=" + professor
				+ "]";
	}

}
