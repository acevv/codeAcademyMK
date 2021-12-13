package org.test.student;

public interface AddressDAO {
	public String createAddressTable();
	public String createAddress(Address address);
	public Address getAddressById(Integer id);
	
}
