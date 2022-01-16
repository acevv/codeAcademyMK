package org.test.soapExample.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.test.soapExample.entity.Person;
import org.test.soapExample.entity.PersonDAO;

@WebService(endpointInterface = "org.test.soapExample.services.PersonService")
public class PersonServiceImpl implements PersonService {

	private static List<Person> personCatalog;

	public PersonServiceImpl() {
		initCatalog();
	}

	private void initCatalog() {
		if (personCatalog == null) {
			personCatalog = new ArrayList<Person>();
		}

		personCatalog.add(new Person(1, "Ognen", "Iloski", "Bitola"));
		personCatalog.add(new Person(2, "Borce", "Gjorgievski", "Skopje"));
		personCatalog.add(new Person(3, "Filip", "Nikoloski", "Tetovo"));

	}

	public String insertPerson(Person person) {

		String result = PersonDAO.openSession(person);

		return result;
	}

	public Person findPersonById(Integer id) {

		return PersonDAO.findByID(id);
	}

	public List<Person> getAll() {

		return PersonDAO.getAllFromDB();
	}

}
