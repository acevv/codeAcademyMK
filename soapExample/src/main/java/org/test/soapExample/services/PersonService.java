package org.test.soapExample.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.test.soapExample.entity.Person;

@WebService
public interface PersonService {

	@WebMethod(operationName = "insert")
	public String insertPerson(Person person);

	@WebMethod(operationName = "findById")
	public Person findPersonById(Integer id);

	@WebMethod(operationName = "getAll")
	public List<Person> getAll();

}
