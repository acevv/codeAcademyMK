package org.test.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {
	
	static ConfigurationReader confReader = new ConfigurationReader();
	
	
	private static String jdbcURL = confReader.getProperty("db.url"); 
			// "jdbc:postgresql://localhost:5432/student";
	private static String jdbcUsername = confReader.getProperty("db.username");
	private static String jdbcPassword = confReader.getProperty("db.password");

	public static Connection getConnection() {
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
			getConnection();
			System.out.println("Successfuly connected.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
