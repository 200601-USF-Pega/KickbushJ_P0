package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jamakick.santasWorkshop.interfaces.db.CompositeTableServiceInterface;
import com.jamakick.santasWorkshop.object.PastToy;

public class CompositeTableService implements CompositeTableServiceInterface {

	@Override
	public boolean sendToyToHistory(Connection connection, int toyID, int newToyYear,
			boolean newToyDelivered) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM CurrentToys "
					+ "WHERE toyID = ?");
			pst.setInt(1, toyID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();
			
			PastToy toy = new PastToy();
			
			while (rs.next()) {
				
				
				toy.setToyID(rs.getInt("toyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));
				toy.setYearProduced(newToyYear);
				toy.setDelivered(newToyDelivered);

			}
			
			pst = connection.prepareStatement("DELETE FROM CurrentToys "
					+ "WHERE toyID = ?");
			pst.setInt(1,  toyID);
			pst.executeUpdate();
			
			pst = connection.prepareStatement("INSERT INTO ToyHistory "
					+ "(toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
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
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
			
		}
	}

}
