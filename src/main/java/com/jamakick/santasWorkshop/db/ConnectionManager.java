package com.jamakick.santasWorkshop.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

import com.jamakick.santasWorkshop.interfaces.ConnectionManagerInterface;

public class ConnectionManager implements ConnectionManagerInterface {
	
	private static Connection connection;
	private String url;
	private String user;
	private String pwd;
	
	private String filePath = "resources/sql/sqlLogin.txt";
	private BufferedReader reader;

	public ConnectionManager() {
		
		try {
			try {
			reader = new BufferedReader(new FileReader(filePath));
			
			url = reader.readLine();
			user = reader.readLine();
			pwd = reader.readLine();
			
			}
			
			catch (IOException e) {
				System.out.println("SQL Login not found.");
				e.printStackTrace();
				
			}
			
			connection = DriverManager.getConnection(url, user, pwd);
		}
		
		catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public Connection getConnection() {
		return connection;
	}
	
	public void createTablesAndDummyData() {
		
		
		ScriptRunner sr = new ScriptRunner(connection);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("resources/sql/CreateTables.sql"));
			BufferedReader reader2 = new BufferedReader(new FileReader("resources/sql/InsertDummyData.sql"));
			
			sr.runScript(reader);
			sr.runScript(reader2);
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		}
		
		catch (Exception e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		
		 try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
