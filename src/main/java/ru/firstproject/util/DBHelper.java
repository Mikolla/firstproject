package ru.firstproject.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	static public Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

		DriverManager.registerDriver((Driver) Class.forName(PropertiesReader.getProperties("driver.class")).newInstance());

		String url = PropertiesReader.getProperties("connection.url") + "?user=" +
				PropertiesReader.getProperties("username") + "&password=" +
				PropertiesReader.getProperties("password");

		return DriverManager.getConnection(url);

	}
}
