package org.bildit.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "user";
	private static final String databaseName = "web_phonebook";

	public static Connection connect() throws SQLException {
		Connection connection = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/" + databaseName, USERNAME,
					PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}
