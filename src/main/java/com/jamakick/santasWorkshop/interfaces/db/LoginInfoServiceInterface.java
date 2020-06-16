package com.jamakick.santasWorkshop.interfaces.db;

import java.sql.Connection;

import com.jamakick.santasWorkshop.object.LoginInfo;

public interface LoginInfoServiceInterface {
	
	public LoginInfo getLoginInfo(Connection connection, int empID);

}
