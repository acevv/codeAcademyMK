package filesOperations;

public class User {
	private String name;
	private String surname;
	private String phone;
	private Address address;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}

	public User(String name, String surname, String phone, Address address, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", phone=" + phone + ", address=" + address + ", email="
				+ email + "]";
	}

//	@Override
//	public String toString() {
//		return "User [name=" + name + ", surname=" + surname + ", phone=" + phone + ", city=" + address.getCity()
//				+ ", street=" + address.getStreet() + ", number=" + address.getNumber() + ", email=" + email + "]";
//	}

}
