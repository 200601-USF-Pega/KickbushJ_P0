package com.jamakick.santasWorkshop.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.operation.EmployeeMenuService;
import com.jamakick.santasWorkshop.operation.ManagerMenuService;

public class ManagerMenu<T> implements MenuInterface {
	
	private ManagerMenuService managerMenuService = new ManagerMenuService();
	private EmployeeMenuService employeeMenuService = new EmployeeMenuService();
	private ArrayList<T> result;

	@Override
	public void start(Scanner scanner) {
		
		String userInput;
		final String bar = "-------------------------------------------------------------------";
		
		do {
		
		System.out.println("Welcome Manager, what would you like to do today?");
		System.out.println(bar);
		System.out.println("[0] View the Naughty and Nice list");
		System.out.println("[1] Add a Child to the Naughty and Nice list");
		System.out.println("[2] Change a Child's Status to Naughty or Nice");
		System.out.println("[3] View the Current Toy Production (Toys Currently Slated to be Created)");
		System.out.println("[4] Add a Toy to the Production Line");
		System.out.println("[5] Remove a Toy from the Production Line");
		System.out.println("[6] View Toy Production History from All Years");
		System.out.println("[7] View Toy Production by Specific Year");
		System.out.println("[8] View All Toys made for a Specific Child");
		System.out.println("[9] View All Toys made by an Individual Worker");
		System.out.println("[10] Confirm Delivery/Scrapping of a Current Toy");
		System.out.println("[11] View Total Number of Toys Delivered vs Scrapped");
		System.out.println("[12] Exit");
		System.out.println(bar);
		
		userInput = scanner.nextLine();
		
		switch (userInput) {
		case "0":
			result = employeeMenuService.ViewNaughtyNiceList();
			System.out.println(result.toString());
			break;
		case "1":
			break;
		case "2":
			break;
		case "3":
			result = employeeMenuService.ViewCurrentToyProduction();
			System.out.println(result.toString());
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			result = employeeMenuService.ViewToyHistory();
			System.out.println(result.toString());
			break;
		case "7":
			System.out.println("What year would you like to view history from? 2010-2020");
			int year = scanner.nextInt();
			scanner.nextLine();
			result = employeeMenuService.ViewSpecificYearToyHistory(year);
			System.out.println(result.toString());
			break;
		case "8":
			System.out.println("What child ID's Toy History would you like to view?");
			int childID = scanner.nextInt();
			scanner.nextLine();
			result = employeeMenuService.ViewAllChildsToys(childID);
			System.out.println(result.toString());
			break;
		case "9":
			break;
		case "10":
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
		case "11":
			break;
		case "12":
			System.out.println("Exiting..");
			break;
		default:
			System.out.println("Invalid input please try again!");
			System.out.println();
			this.start(scanner);
			
			
			}
		}
		while (!userInput.equals("12"));
		
	}

}
