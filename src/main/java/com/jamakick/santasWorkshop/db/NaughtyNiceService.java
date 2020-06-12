package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.interfaces.db.NaughtyNiceServiceInterface;
import com.jamakick.santasWorkshop.object.Child;

public class NaughtyNiceService implements NaughtyNiceServiceInterface {
	
	@Override
	public <T> ArrayList<T> getFullNaughtyNiceList(Connection connection) {
		
		ArrayList<T> children = new ArrayList<T>();
		
		try {
			Statement s = connection.createStatement();
			s.executeQuery("SELECT * FROM NaughtyNice;");
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				Child child = new Child();
				child.setChildID(rs.getInt("childID"));
				child.setChildName(rs.getString("childName"));
				child.setChildAge(rs.getInt("childAge"));
				child.setNaughty(rs.getBoolean("naughty"));
				
				children.add((T) child);
				
			}
			
			return children;
			
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public boolean addChildToList(Connection connection, Child child) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call insertChild(?, ?, ?);");
			pst.setString(1, child.getChildName());
			pst.setInt(2, child.getChildAge());
			pst.setBoolean(3, child.getNaughty());
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean changeChildNaughtyStatus(Connection connection, int childID, boolean naughty) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call changeChildNaughty(?, ?);");

			pst.setInt(1, childID);
			pst.setBoolean(2, naughty);
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;

		}

	}
	
}
