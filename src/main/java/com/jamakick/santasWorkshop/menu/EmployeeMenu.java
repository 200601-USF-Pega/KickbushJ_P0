package com.jamakick.santasWorkshop.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.operation.EmployeeMenuService;

public class EmployeeMenu<T> implements MenuInterface {
	
	private EmployeeMenuService employeeMenuService = new EmployeeMenuService();
	private ArrayList<T> result;
	private ConnectionManager connectionManager = new ConnectionManager();

	@Override
	public void start(Scanner scanner) {
		
		String userInput;
		final String bar = "-------------------------------------------------------------------";
		
		do {
		
		System.out.println();
		System.out.println("Welcome Employee, what would you like to do today?");
		System.out.println(bar);
		System.out.println("[0] View the Naughty and Nice list");
		System.out.println("[1] View the Current Toy Production (Toys Currently Slated to be Created)");
		System.out.println("[2] View Toy Production History from All Years");
		System.out.println("[3] View Toy Production by Specific Year");
		System.out.println("[4] View All Toys made for a Specific Child");
		System.out.println("[5] Confirm Delivery/Scrapping of a Current Toy");
		System.out.println("[6] Exit");
		System.out.println(bar);
		
		userInput = scanner.nextLine();
		
		switch (userInput) {
		case "0":
			result = employeeMenuService.ViewNaughtyNiceList();
			System.out.println(result.toString());
			break;
		case "1":
			result = employeeMenuService.ViewCurrentToyProduction();
			System.out.println(result.toString());
			break;
		case "2":
			result = employeeMenuService.ViewToyHistory();
			System.out.println(result.toString());
			break;
		case "3":
			System.out.println("What year would you like to view history from? 2010-2020");
			int year = scanner.nextInt();
			scanner.nextLine();
			result = employeeMenuService.ViewSpecificYearToyHistory(year);
			System.out.println(result.toString());
			break;
		case "4":
			System.out.println("What child ID's Toy History would you like to view?");
			int childID = scanner.nextInt();
			scanner.nextLine();
			result = employeeMenuService.ViewAllChildsToys(childID);
			System.out.println(result.toString());
			break;
		case "5":
			System.out.println("Which Toy ID would you like to send to the Toy History?");
			int toyID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("What year was the toy produced?");
			int newToyYear = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Was the toy delivered? (True/False)");
			boolean newToyDelivered = scanner.nextBoolean();
			scanner.nextLine();
			boolean created = employeeMenuService.SendToyToHistory(toyID, newToyYear, newToyDelivered);
			System.out.println(created);
			break;
		case "6":
			System.out.println("Exiting..");
			connectionManager.closeConnection();
			break;
		default:
			System.out.println("Invalid input please try again!");
			}
		
		}
		
		while (!userInput.equals("6"));
		
		
	}

}
