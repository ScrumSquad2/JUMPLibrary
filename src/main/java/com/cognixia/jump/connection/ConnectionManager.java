package com.cognixia.jump.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection = null;

	private static final String MACURL = "jdbc:mysql://localhost:3306/library?serverTimezone=EST5EDT";
	private static final String WINURL = "jdbc:mysql://localhost:3306/library";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@123";

	private static void makeConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(MACURL, USERNAME, PASSWORD);
			System.out.println("Connected");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		if (connection == null) {
			makeConnection();
		}

		return connection;
	}
}
