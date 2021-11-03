package jaxbStudent;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Predmet {
	@XmlElement
	private ArrayList<Subject> subjects;

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public Predmet() {
		super();
	}

}
