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
import com.jamakick.santasWorkshop.object.PastToy;
import com.jamakick.santasWorkshop.object.Toy;
import com.jamakick.santasWorkshop.tools.Beautify;

public class EmployeeMenuService implements EmployeeMenuServiceInterface {
	
	private Connection connection = ConnectionManager.getConnection();
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
		
		Beautify.printFullProductionTable(fullProd);

	}

	@Override
	public void ViewToyHistory() {
		
		ArrayList<PastToy> toys = toyHistoryService.getFullToyHistory(connection);
		
		Beautify.printToyHistoryTable(toys);
	}

	@Override
	public void ViewSpecificYearToyHistory(Scanner scanner) {
		
		System.out.println("What year would you like to view history from? 2010-2020");
		int year = scanner.nextInt();
		scanner.nextLine();
				
		ArrayList<PastToy> toys = toyHistoryService.getSpecificYearToyHistory(connection, year);
		
		Beautify.printToyHistoryTable(toys);
				
	}

	@Override
	public void ViewAllChildsToys(Scanner scanner) {
		
		System.out.println("What child ID's Toy History would you like to view?");
		int childID = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<PastToy> toys = toyHistoryService.getChildToys(connection, childID);
		
		Beautify.printToyHistoryTable(toys);
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
		
		if (created) {
			System.out.println("Toy ID: " + Integer.toString(toyID) + " was sent to the Toy History.");
		}
		else {
			System.out.println("Toy ID: " + Integer.toString(toyID) + " was unable to be sent to Toy History.");
		}

	}

}
