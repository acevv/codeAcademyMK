package org.test.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public String createStudentTable() {
		Connection conn = JDBCConfig.getConnection();
		String result = "";

		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.student (" + "indeks VARCHAR(10)," + "name VARCHAR(20),"
					+ "surname VARCHAR(30)," + "addressId INTEGER," + "major VARCHAR(50)," + "PRIMARY KEY(indeks),"
					+ "FOREIGN KEY(addressId) REFERENCES public.address(id)" + ");";
			Boolean status = stmt.execute(query);
			if (!status) {
				result = "Created student table.";
			} else {
				result = "Did NOT create student table.";
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public String createStudent(Student student) {
		Connection conn = JDBCConfig.getConnection();
		String result = "";
		try {
			String query = "INSERT INTO public.student(" + "	indeks, name, surname, addressid, major)"
					+ "	VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, student.getIndeks());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSurname());
			ps.setInt(4, student.getAddressId());
			ps.setString(5, student.getMajor());

			ps.execute();
			result = "Student inserted succsessfully.";

		} catch (Exception e) {
			result = "Student is not inserted sccsessfully";
			System.out.println(e);
		}
		return result;
	}

	@Override
	public String countStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getAllStudents() {
		Connection conn = JDBCConfig.getConnection();

		Set students = new HashSet();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.student;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Student student = new Student();
				student.setIndeks(rs.getString("indeks"));
				student.setName(rs.getString("name"));
				student.setSurname(rs.getString("surname"));
				student.setAddressId(rs.getInt("addressId"));
				student.setMajor(rs.getString("major"));
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			System.out.println(e);
		}
		return students;
	}

}
