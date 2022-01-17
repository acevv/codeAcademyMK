package restExample;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonController {

	private static List<Person> persons;

	private void initPerson() {
		if (persons == null) {
			persons = new ArrayList<Person>();
		}
		persons.add(new Person(1, "Goran", "Stanic", "goran@gmail.com"));
		persons.add(new Person(2, "Aleksandar", "Vishinov", "vishinov@gmail.com"));
		persons.add(new Person(3, "Vlatko", "Doncev", "vlatko@gmail.com"));

	}

	public PersonController() {
		initPerson();
	}

	@GET
	@Path("/hello")
	public String hello() {
		return "Hello, World!";
	}

	@GET
	@Path("/getAll")
	public List<Person> getAll() {
		return persons;
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(Person person) {
		persons.add(new Person(person.getId(), person.getName(), person.getSurName(), person.getEmail()));
		return "Person added!";
	}

}
