package org.acev.phonebook.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.acev.phonebook.entity.ContactInfo;
import org.acev.phonebook.entity.Person;
import org.acev.phonebook.entity.PhoneBook;

@Path("/contacts")
public class PhoneBookService {

	@GET
	@Path("/hello")
	public String hello() {
		return "Hello, world!";
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createContact(ContactInfo contact) {
		try {
			PhonebookDAO.createContact(contact);

			return "Contact added succsessfully!";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Did not succeed to add contact!";
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateContact(@QueryParam("embg") Long embg, ContactInfo contact) {
		try {
			PhonebookDAO.updateContact(embg, contact);

			return "Update success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail to ubdate!";
		}

	}

	@DELETE
	@Path("/delete")
	public String deleteContact(@QueryParam("embg") Long embg) {
		try {
			PhonebookDAO.deleteContact(embg);
			return "Delete Success!";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Delete Failed!";
	}

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PhoneBook> getAll() {
		return PhonebookDAO.getAllFromDB();
	}

	@GET
	@Path("/getContactByPhoneNumber")
	@Produces(MediaType.APPLICATION_JSON)
	public PhoneBook getByPhoneNumber(@QueryParam("phone") String phone) {

		return PhonebookDAO.getByPhoneNumber(phone);
	}

	@GET
	@Path("/getAllContactsByFirstName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PhoneBook> getAllByFirstName(@QueryParam("firstName") String fName) {
		return PhonebookDAO.getAllByFirstName(fName);
	}

	@GET
	@Path("/getContactByCountryCode")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PhoneBook> getContactByCountryCode(@QueryParam("countryCode") String code) {
		return PhonebookDAO.getContactByCountryCode(code);
	}

	@GET
	@Path("/getContactByCityCode")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PhoneBook> getContactByCityCode(@QueryParam("cityCode") String code) {
		return PhonebookDAO.getByCityCode(code);
	}

	@GET
	@Path("/getAllContactsByPerson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PhoneBook> getAllContactsByPerson(Person person) {
		return PhonebookDAO.getAllByPerson(person);
	}
}
