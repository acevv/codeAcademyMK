package org.test.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDAOImpl implements AddressDAO {

	@Override
	public String createAddressTable() {
		Connection conn = JDBCConfig.getConnection();
		String result = "";
		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.address (" + "id INTEGER NOT NULL," + "street VARCHAR(50),"
					+ "number VARCHAR," + "city VARCHAR," + "PRIMARY KEY(id)" + ");";
			Boolean status = stmt.execute(query);
			if (!status) {
				result = "Table address is created.";
			} else {
				result = "Table address is NOT created.";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public String createAddress(Address address) {
		Connection conn = JDBCConfig.getConnection();
		String result = "";
		try {
			String query = "INSERT INTO public.address(" + "	id, street, \"number\", city)"
					+ "	VALUES (?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, address.getId());
			ps.setString(2, address.getStreet());
			ps.setString(3, address.getNumber());
			ps.setString(4, address.getCity());

			ps.execute();
			result = "Address inserted succsessfully";

		} catch (Exception e) {
			result = "Address is not inserted.";
			System.out.println(e);
		}
		return result;
	}

	@Override
	public Address getAddressById(Integer id) {
		Connection conn = JDBCConfig.getConnection();
		Address addr = new Address();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.address AS a WHERE a.id=" + id + ";";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				addr.setId(rs.getInt("id"));
				addr.setStreet(rs.getString("street"));
				addr.setNumber(rs.getString("number"));
				addr.setCity(rs.getString("city"));
			} 

		} catch (Exception e) {
			System.out.println(e);
		}
		return addr;
	}

}
