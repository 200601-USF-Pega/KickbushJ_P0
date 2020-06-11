package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jamakick.santasWorkshop.interfaces.ConnectionManagerInterface;

public class ConnectionManager implements ConnectionManagerInterface {
	
	Connection connection;
	String url;
	String user;
	String pwd;

	@Override
	public Connection getDBConnection() {
		
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		}
		
		catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

}
