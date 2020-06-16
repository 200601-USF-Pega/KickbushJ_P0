package com.jamakick.santasWorkshop.operation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		
		boolean validInput = false;
		int year = 0;
		
		while(!validInput) {
			
		try {
		System.out.println("What year would you like to view history from? 2010-2020");
		year = scanner.nextInt();
		scanner.nextLine();
		
		if (year < 2021 & year > 2009) {
			validInput = true;
		}
		else {
			System.out.println("Please enter a year from 2010-2020");
		}
		
		}
		catch (InputMismatchException e) {
			System.out.println("Please enter a year from 2010-2020");
			scanner.nextLine();
		}
		}
				
		ArrayList<PastToy> toys = toyHistoryService.getSpecificYearToyHistory(connection, year);
		
		Beautify.printToyHistoryTable(toys);
				
	}

	@Override
	public void ViewAllChildsToys(Scanner scanner) {
		
		boolean validInput = false;
		int childID = 0;
		
		while (!validInput) {
		try {
		System.out.println("What child ID's Toy History would you like to view?");
		childID = scanner.nextInt();
		scanner.nextLine();
		validInput = true;
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a child ID as a number.");
			scanner.nextLine();
			}
		}
		
		ArrayList<PastToy> toys = toyHistoryService.getChildToys(connection, childID);
		
		Beautify.printToyHistoryTable(toys);
	}

	@Override
	public void SendToyToHistory(Scanner scanner) {
		
		boolean validInput = false;
		int toyID = 0;
		int newToyYear = 0;
		boolean newToyDelivered = false;
		
		while (!validInput) {
		try {
		
			System.out.println("Which Toy ID would you like to send to the Toy History?");
			toyID = scanner.nextInt();
			scanner.nextLine();
			validInput = true;
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter Toy ID as a number.");
			scanner.nextLine();
			}
		}
		
		validInput = false;
		
		while (!validInput) {
		try {
			System.out.println("What year was the toy produced?");
			newToyYear = scanner.nextInt();
			scanner.nextLine();
			if (newToyYear > 2009 & newToyYear < 2021) {
			validInput = true;
			}
			else {
				System.out.println("Please enter year produced as a number greater than 2009 and less than 2021.");

			}
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter year produced as a number greater than 2009 and less than 2021.");
			scanner.nextLine();
			}
		}

		validInput = false;
		
		while (!validInput) {
		try {
			System.out.println("Was the toy delivered? (True/False)");
			newToyDelivered = scanner.nextBoolean();
			scanner.nextLine();
			validInput = true;
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter Delivered as true or false.");
			scanner.nextLine();
			}
		}
		
		
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
