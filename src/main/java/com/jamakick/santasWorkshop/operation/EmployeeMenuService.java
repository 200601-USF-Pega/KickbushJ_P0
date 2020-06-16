package com.jamakick.santasWorkshop.operation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.db.CompositeTableService;
import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.CurrentToysService;
import com.jamakick.santasWorkshop.db.NaughtyNiceService;
import com.jamakick.santasWorkshop.db.ToyHistoryService;
import com.jamakick.santasWorkshop.interfaces.EmployeeMenuServiceInterface;
import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.FullProductionObject;
import com.jamakick.santasWorkshop.object.Toy;
import com.jamakick.santasWorkshop.tools.Beautify;

public class EmployeeMenuService implements EmployeeMenuServiceInterface {
	
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connection = connectionManager.getConnection();
	private ToyHistoryService toyHistoryService = new ToyHistoryService();
	private CurrentToysService currentToysService = new CurrentToysService();
	private NaughtyNiceService naughtyNiceService = new NaughtyNiceService();
	private CompositeTableService compositeTableService = new CompositeTableService();

	@Override
	public void ViewNaughtyNiceList() {
		
		 ArrayList<Child> children = naughtyNiceService.getFullNaughtyNiceList(connection);
		 
		 Beautify.printChildTable(children);
		 
	}

	@Override
	public void ViewCurrentToyProduction() {
		
		ArrayList<FullProductionObject> fullProd = currentToysService.getFullToyProduction(connection);
		
		System.out.println(fullProd.toString());

	}

	@Override
	public void ViewToyHistory() {
		
		ArrayList<Toy> toys = toyHistoryService.getFullToyHistory(connection);
		
		System.out.println(toys.toString());
		
	}

	@Override
	public void ViewSpecificYearToyHistory(Scanner scanner) {
		
		System.out.println("What year would you like to view history from? 2010-2020");
		int year = scanner.nextInt();
		scanner.nextLine();
				
		ArrayList<Toy> toys = toyHistoryService.getSpecificYearToyHistory(connection, year);
		
		System.out.println(toys.toString());
				
	}

	@Override
	public void ViewAllChildsToys(Scanner scanner) {
		
		System.out.println("What child ID's Toy History would you like to view?");
		int childID = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<Toy> toys = toyHistoryService.getChildToys(connection, childID);
		
		System.out.println(toys.toString());
	}

	@Override
	public void SendToyToHistory(Scanner scanner) {
		
		System.out.println("Which Toy ID would you like to send to the Toy History?");
		int toyID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("What year was the toy produced?");
		int newToyYear = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Was the toy delivered? (True/False)");
		boolean newToyDelivered = scanner.nextBoolean();
		scanner.nextLine();
		
		boolean created = compositeTableService.sendToyToHistory(connection, toyID, newToyYear,
				newToyDelivered);
		
		System.out.println(created);

	}

}
