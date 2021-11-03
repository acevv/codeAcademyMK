package jaxbStudent;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Students {

	@XmlElement(name = "student")
	List<Student> students = new ArrayList<>();

	public List<Student> getStudents() {
		return students;
	}

	public Students() {
		super();
	}

}
