package com.jamakick.santasWorkshop.operation;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.NaughtyNiceService;
import com.jamakick.santasWorkshop.interfaces.EmployeeMenuServiceInterface;
import com.jamakick.santasWorkshop.object.Child;

public class EmployeeMenuService implements EmployeeMenuServiceInterface {
	
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connection = connectionManager.getDBConnection();

	@Override
	public ArrayList<Child> ViewNaughtyNiceList() {
		
		NaughtyNiceService naughtyNiceService = new NaughtyNiceService();
		
		ArrayList<Child> children;
		
		children = naughtyNiceService.getFullNaughtyNiceList(connection);
		
		return children;
	}

	@Override
	public <T> ArrayList<T> ViewCurrentToyProduction() {
		return null;
	}

	@Override
	public <T> ArrayList<T> ViewToyHistory() {
		return null;
	}

	@Override
	public <T> ArrayList<T> ViewSpecificYearToyHistory() {
		return null;
	}

	@Override
	public <T> ArrayList<T> ViewAllChildsToys() {
		return null;
	}

	@Override
	public <T> ArrayList<T> SendToyToHistory() {
		return null;
	}

}
