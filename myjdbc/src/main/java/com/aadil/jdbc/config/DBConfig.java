package com.aadil.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
}
