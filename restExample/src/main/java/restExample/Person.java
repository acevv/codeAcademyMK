package restExample;

public class Person {

	private Integer id;
	private String name;
	private String surName;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person(Integer id, String name, String surName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.email = email;
	}

	public Person() {
		super();
	}

}
