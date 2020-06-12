package com.jamakick.santasWorkshop.operation;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.db.CompositeTableService;
import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.CurrentToysService;
import com.jamakick.santasWorkshop.db.NaughtyNiceService;
import com.jamakick.santasWorkshop.db.ToyHistoryService;
import com.jamakick.santasWorkshop.interfaces.EmployeeMenuServiceInterface;

public class EmployeeMenuService implements EmployeeMenuServiceInterface {
	
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connection = connectionManager.getConnection();
	private ToyHistoryService toyHistoryService = new ToyHistoryService();
	private CurrentToysService currentToysService = new CurrentToysService();
	private NaughtyNiceService naughtyNiceService = new NaughtyNiceService();
	private CompositeTableService compositeTableService = new CompositeTableService();

	@Override
	public <T> ArrayList<T> ViewNaughtyNiceList() {
		
		 ArrayList<T> children = naughtyNiceService.getFullNaughtyNiceList(connection);
		 
		
		return children;
	}

	@Override
	public <T> ArrayList<T> ViewCurrentToyProduction() {
		
		ArrayList<T> toys = currentToysService.getFullToyProduction(connection);
		
		
		return toys;
	}

	@Override
	public <T> ArrayList<T> ViewToyHistory() {
		
		ArrayList<T> toys = toyHistoryService.getFullToyHistory(connection);
		
		
		return toys;
	}

	@Override
	public <T> ArrayList<T> ViewSpecificYearToyHistory(int year) {
		
		ArrayList<T> toys = toyHistoryService.getSpecificYearToyHistory(connection, year);
		
				
		return toys;
	}

	@Override
	public <T> ArrayList<T> ViewAllChildsToys(int childID) {
		
		ArrayList<T> toys = toyHistoryService.getChildToys(connection, childID);
		
		
		return toys;
	}

	@Override
	public boolean SendToyToHistory(int toyID, int newToyYear, boolean newToyDelivered) {
		
		boolean created = compositeTableService.sendToyToHistory(connection, toyID, newToyYear,
				newToyDelivered);
		
		
		return created;
	}

}
