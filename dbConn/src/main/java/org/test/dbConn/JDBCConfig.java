package org.test.dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConfig {

	private static String jdbcURL = "jdbc:postgresql://localhost:5432/users";
	private static String jdbcUsername = "postgres";
	private static String jdbcPassword = "1104";

	private static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {

		try {
			Connection con = getConnection();

			if (con != null) {
				System.out.println("Connected successfully");
			} else {
				System.out.println("Connection failed.");
			}
			
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
			if (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
