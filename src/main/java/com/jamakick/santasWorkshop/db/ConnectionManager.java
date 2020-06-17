package com.jamakick.santasWorkshop.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionManager {
	
	private static final Logger logger = LogManager.getLogger(ConnectionManager.class);

	public ConnectionManager() {

		logger.debug("Creating Connection Manager");
		
		
	}
	
	public static Connection getConnection() {
		
		Connection connection;
		String url;
		String user;
		String pwd;
		
		String filePath = "resources/sql/sqlLogin.txt";
		BufferedReader reader;
		
		try {
			try {
			reader = new BufferedReader(new FileReader(filePath));
			
			url = reader.readLine();
			user = reader.readLine();
			pwd = reader.readLine();
			
			reader.close();
			}
			
			catch (IOException e) {
				System.out.println("SQL Login not found.");
				e.printStackTrace();
				return null;
				
			}
			connection = DriverManager.getConnection(url, user, pwd);
		}
		
		catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		return connection;
	}
	
	public void createTablesAndDummyData() {
		
		logger.debug("Creating Tables and Data");
		
		
		ScriptRunner sr = new ScriptRunner(ConnectionManager.getConnection());
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("resources/sql/CreateTables.sql"));
			sr.runScript(reader);
			
			reader = new BufferedReader(new FileReader("resources/sql/InsertDummyData.sql"));
			sr.runScript(reader);
			
			reader = new BufferedReader(new FileReader("resources/sql/CreateFunctions.sql"));
			sr.runScript(reader);
			
			reader = new BufferedReader(new FileReader("resources/sql/CreateProcedures.sql"));
			sr.runScript(reader);
			
			try {
				ConnectionManager.getConnection().close();
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
			ConnectionManager.getConnection().close();
		}
		
		catch (Exception e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		
		logger.debug("Closing Connection");
		
		try {
		ConnectionManager.getConnection().close();
		}
		catch (SQLException e) {
			System.out.println("Problem closing the database connection.");
			System.out.println("Exception: " + e);
		}
	}
		

}
