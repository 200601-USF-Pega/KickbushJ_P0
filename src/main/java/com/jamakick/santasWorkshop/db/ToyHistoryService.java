package com.jamakick.santasWorkshop.db;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.interfaces.db.ToyHistoryServiceInterface;
import com.jamakick.santasWorkshop.object.PastToy;

public class ToyHistoryService implements ToyHistoryServiceInterface {

	@Override
	public ArrayList<PastToy> getFullToyHistory(Connection connection) {
		
		ArrayList<PastToy> toys = new ArrayList<PastToy>();
		
		try {
			Statement s = connection.createStatement();
			s.executeQuery("SELECT * FROM ToyHistory;");
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				PastToy toy = new PastToy();
				toy.setToyID(rs.getInt("historyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));
				toy.setYearProduced(rs.getInt("yearProduced"));
				toy.setDelivered(rs.getBoolean("delivered"));
				
				toys.add(toy);
			}
			
			return toys;
			
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return null;
			
		}
		
	}

	@Override
	public ArrayList<PastToy> getSpecificYearToyHistory(Connection connection, int year) {
		
		ArrayList<PastToy> toys = new ArrayList<PastToy>();
		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM ToyHistory "
					+ "WHERE yearProduced = ?");
			pst.setInt(1, year);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();
			
			while (rs.next()) {
				
				PastToy toy = new PastToy();
				toy.setToyID(rs.getInt("historyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor")); 
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));
				toy.setYearProduced(rs.getInt("yearProduced"));
				toy.setDelivered(rs.getBoolean("delivered"));
				
				toys.add(toy);
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
	public ArrayList<PastToy> getChildToys(Connection connection, int childID) {
		
		ArrayList<PastToy> toys = new ArrayList<PastToy>();
		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM ToyHistory "
					+ "WHERE childID = ?");
			pst.setInt(1, childID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();
			
			while (rs.next()) {
				
				PastToy toy = new PastToy();
				toy.setToyID(rs.getInt("historyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));
				toy.setYearProduced(rs.getInt("yearProduced"));
				toy.setDelivered(rs.getBoolean("delivered"));
				
				toys.add(toy);
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
	public ArrayList<PastToy> viewToysMadeByWorker(Connection connection, int elvenID) {
		
		ArrayList<PastToy> toys = new ArrayList<PastToy>();
		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM ToyHistory "
					+ "WHERE elvenID = ?");
			pst.setInt(1, elvenID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();
			
			while (rs.next()) {
				
				PastToy toy = new PastToy();
				toy.setToyID(rs.getInt("historyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));
				toy.setYearProduced(rs.getInt("yearProduced"));
				toy.setDelivered(rs.getBoolean("delivered"));
				
				toys.add(toy);
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
	public Array totalDeliveredToys(Connection connection) {
		
		Array result = null;
		
		try {
			
			PreparedStatement pst = connection.prepareStatement("SELECT getDelivered()");
			
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();
			
			while (rs.next()) {
				
				result = rs.getArray("getdelivered");
				
			}
			
			return result;
			
			
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean insertIntoToyHistory(Connection connection, PastToy toy) {
				
		try {
		PreparedStatement pst = connection.prepareStatement("call addToyToHistory(?, ?, ?, ?, ?, ?, ?)");
		pst.setString(1, toy.getToyName());
		pst.setString(2, toy.getToyColor());	
		pst.setFloat(3, toy.getWorkTime());
		pst.setInt(4, toy.getChildID());
		pst.setInt(5, toy.getElvenID());
		pst.setInt(6, toy.getYearProduced());
		pst.setBoolean(7, toy.isDelivered());
		pst.executeUpdate();
		
		return true;
		
		}
		
		catch (SQLException e) {
			System.out.println("Exception : " + e);
			e.printStackTrace();
			return false;
		}
		
	}

}
