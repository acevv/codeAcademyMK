package filesOperations;

public class Address {
	
	private String city;
	private Integer number;
	private String street;
	
	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", number=" + number + ", street=" + street + "]";
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Address(String city, Integer number, String street) {
		super();
		this.city = city;
		this.number = number;
		this.street = street;
	}
	public Address() {
		super();
	}
	
	

}
