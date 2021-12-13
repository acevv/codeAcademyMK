package org.test.dbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {

	public String insertUserInDB(Korisnik user) {

		String res = "";

		Connection dbConnection = JDBCConfig.getConnection();

		try {
			Statement stmt = dbConnection.createStatement();

			String query = "INSERT INTO public.Korisnik (id, name, email, user_pass) VALUES (" + user.getId() + ",'"
					+ user.getName() + "','" + user.getEmail() + "','" + user.getUser_pass() + "');";

			stmt.executeQuery(query);
			res = "User has been inserted successfully";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	public List<Korisnik> getAllUsers() {
		Connection dbCon = JDBCConfig.getConnection();
		List<Korisnik> users = new ArrayList<Korisnik>();

		try {
			Statement stmt = dbCon.createStatement();
			String query = "SELECT * FROM public.korisnik;";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Korisnik user = new Korisnik();
				user = extractUserFromResultSet(rs);
				users.add(user);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return users;
	}

	private Korisnik extractUserFromResultSet(ResultSet rs) throws SQLException {

		Korisnik korisnik = new Korisnik();
		korisnik.setId(rs.getInt("id"));
		korisnik.setName(rs.getString("name"));
		korisnik.setEmail(rs.getString("email"));
		korisnik.setUser_pass(rs.getString("user_pass"));

		return korisnik;
	}

	public Korisnik getUserByID(Integer id) {
		Korisnik user = new Korisnik();
		Connection conn = JDBCConfig.getConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.korisnik WHERE id=" + id + ";";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				user = extractUserFromResultSet(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public String insertUserInDBwithPreparedStatement(Korisnik user) {
		Connection conn = JDBCConfig.getConnection();
		String result = "";

		try {
			String query = "INSERT INTO public.korisnik(id, name, email, user_pass)\n" + "	VALUES (?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getUser_pass());

			int status = ps.executeUpdate();

			if (status == 1) {
				result = "Successfully inserted.";
			} else {
				result = "Record has not been inserted.";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
