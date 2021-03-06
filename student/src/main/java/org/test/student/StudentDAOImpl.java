package org.test.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		Connection conn = JDBCConfig.getConnection();
		String result = "";
		Integer noOfStudents = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(*) FROM public.student";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				noOfStudents = rs.getInt(1);
			}
			result = "Number of students in the database: " + noOfStudents;

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public Student getStudentById(String id) {
		Connection conn = JDBCConfig.getConnection();
		Student s = new Student();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.student WHERE indeks = '" + id + "';";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				s.setIndeks(rs.getString("indeks"));
				s.setName(rs.getString("name"));
				s.setSurname(rs.getString("surname"));
				s.setMajor(rs.getString("major"));
				s.setAddressId(rs.getInt("addressid"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}

	@Override
	public Set<Student> getAllStudents() {
		Connection conn = JDBCConfig.getConnection();

		Set<Student> students = new HashSet<Student>();
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

	@Override
	public List<Student> getStudentsByMajor(String major) {
		Connection con = JDBCConfig.getConnection();
		List<Student> result = new ArrayList<>();
		try {
			String query = "SELECT * FROM public.student WHERE major = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, major);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setName(rs.getString("name"));
				s.setIndeks(rs.getString("indeks"));
				s.setSurname(rs.getString("surname"));
				s.setMajor(rs.getString("major"));
				s.setAddressId(rs.getInt("addressId"));
				result.add(s);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<StudentInfo> getStudentInfo() {
		AddressDAO aDao = new AddressDAOImpl();
		List<StudentInfo> result = new ArrayList<>();

		Set<Student> allStudents = getAllStudents();
		for (Student s : allStudents) {
			StudentInfo sinfo = new StudentInfo();
			sinfo.setName(s.getName());
			sinfo.setSurname(s.getSurname());
			sinfo.setCity(aDao.getAddressById(s.getAddressId()).getCity());
			sinfo.setStreet(aDao.getAddressById(s.getAddressId()).getStreet());
			sinfo.setNumber(aDao.getAddressById(s.getAddressId()).getNumber());
			result.add(sinfo);
		}

		return result;
	}

}