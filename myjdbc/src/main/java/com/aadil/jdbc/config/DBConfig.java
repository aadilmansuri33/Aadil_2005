package com.aadil.jdbc.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {

	public static Connection getConnection() {
		Properties properties = new Properties();
		Connection connection = null;

		try {
			properties.load(DBConfig.class.getClassLoader().getResourceAsStream("DBConnection.properties"));
			Class.forName(properties.getProperty("jdbc.driver"));
			connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
