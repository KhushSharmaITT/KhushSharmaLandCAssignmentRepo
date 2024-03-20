package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private static Connection connection;

	public static synchronized Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/LandCAssignment";
				String username = "root";
				String password = "kh@2632";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, username, password);
			}
		} catch (ClassNotFoundException | SQLException issue) {
			System.err.println("Failed to load JDBC driver: " + issue.getMessage());
		}
		return connection;
	}
}
