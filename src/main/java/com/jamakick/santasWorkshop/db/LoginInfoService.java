package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jamakick.santasWorkshop.interfaces.db.LoginInfoServiceInterface;
import com.jamakick.santasWorkshop.object.LoginInfo;

public class LoginInfoService implements LoginInfoServiceInterface {

	@Override
	public LoginInfo getLoginInfo(Connection connection, int empID) {
		
		LoginInfo info = new LoginInfo();

		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM LoginInfo "
					+ "WHERE empID = ?");
			pst.setInt(1, empID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();			
			
			while (rs.next()) {
				
				info.setEmpID(empID);
				info.setPass(rs.getString("pass"));
				info.setManager(rs.getBoolean("manager"));

			}
		
		return info;
		}
		
		catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return info;
		
		}

	}
}
