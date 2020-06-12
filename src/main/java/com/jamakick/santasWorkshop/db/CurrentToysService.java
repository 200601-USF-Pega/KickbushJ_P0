package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.interfaces.CurrentToysServiceInterface;
import com.jamakick.santasWorkshop.object.Toy;

public class CurrentToysService  implements CurrentToysServiceInterface {

	@Override
	public <T> ArrayList<T> getFullToyProduction(Connection connection) {
		
		ArrayList<T> toys = new ArrayList<T>();
		
		try {
			Statement s = connection.createStatement();
			s.executeQuery("SELECT * FROM CurrentToys;");
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				Toy toy = new Toy();
				toy.setToyID(rs.getInt("toyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));
				
				toys.add((T) toy);
				
			}
			
			return toys;
			
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			
		}
		
		
		return null;
	}

	@Override
	public boolean addCurrentToy(Connection connection, Toy toy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCurrentToy(Connection connection, int toyID) {
		// TODO Auto-generated method stub
		return false;
	}

}
