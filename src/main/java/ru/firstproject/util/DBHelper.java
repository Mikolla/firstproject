package ru.firstproject.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/userbase?user=root&password=root";
		try {
			DriverManager.registerDriver((Driver) Class.forName(driver).newInstance());
			return DriverManager.getConnection(url);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
