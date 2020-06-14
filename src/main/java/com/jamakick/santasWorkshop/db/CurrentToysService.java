package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.interfaces.db.CurrentToysServiceInterface;
import com.jamakick.santasWorkshop.object.PastToy;
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
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call addToy(?, ?, ?, ?, ?);");
			
			pst.setString(1, toy.getToyName());
			pst.setString(2, toy.getToyColor());
			pst.setFloat(3, toy.getWorkTime());
			pst.setInt(4, toy.getChildID());
			pst.setInt(5, toy.getElvenID());
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean removeCurrentToy(Connection connection, int toyID) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call removeToy(?);");
			
			pst.setInt(1, toyID);
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
		}

		
	}

	@Override
	public Toy selectFromToysByID(Connection connection, int toyID) {
		
		Toy toy = new Toy();

		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM CurrentToys "
					+ "WHERE toyID = ?");
			pst.setInt(1, toyID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();			
			
			while (rs.next()) {
				
				
				toy.setToyID(rs.getInt("toyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));

			}
		
		return toy;
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return toy;
		}

	}
}