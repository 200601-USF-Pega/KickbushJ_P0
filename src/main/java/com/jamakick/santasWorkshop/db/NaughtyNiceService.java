package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.interfaces.NaughtyNiceServiceInterface;
import com.jamakick.santasWorkshop.object.Child;

public class NaughtyNiceService implements NaughtyNiceServiceInterface {
	
	@Override
	public ArrayList<Child> getFullNaughtyNiceList(Connection connection) {
		
		ArrayList<Child> children = new ArrayList<Child>();
		
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
				
				children.add(child);
				
			}
			
			return children;
			
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			
		}
		
		return null;
	}

}
