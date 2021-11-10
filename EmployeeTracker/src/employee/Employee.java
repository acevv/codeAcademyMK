package employee;

public class Employee {

	private String firstName;
	private String lastName;
	private String profession;
	private String location;

	public void showStats() {
		System.out.println("Ime: " + firstName);
		System.out.println("Prezime: " + lastName);
		System.out.println("Pozicija: " + profession);
		System.out.println("Lokacija: " + location);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee(String firstName, String lastName, String profession, String location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.profession = profession;
		this.location = location;
	}

	public Employee() {
		super();
		
	}

	
	
	

}
