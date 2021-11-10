package jaxbStudent;

import java.util.ArrayList;
import java.util.List;

public class Subjects {
	
	List<Subjects>	subjects = new ArrayList<>();

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public Subjects(List<Subjects> subjects) {
		super();
		this.subjects = subjects;
	}

	public Subjects() {
		super();
	}
	

}
