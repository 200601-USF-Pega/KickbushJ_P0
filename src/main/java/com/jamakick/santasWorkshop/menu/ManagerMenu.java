package com.jamakick.santasWorkshop.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.operation.EmployeeMenuService;
import com.jamakick.santasWorkshop.operation.ManagerMenuService;

public class ManagerMenu<T> implements MenuInterface {
	
	private ManagerMenuService managerMenuService = new ManagerMenuService();
	private EmployeeMenuService employeeMenuService = new EmployeeMenuService();
	private ConnectionManager connectionManager = new ConnectionManager();

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
		System.out.println("[12] Add an Elven Worker");
		System.out.println("[13] Remove an Elven Worker");
		System.out.println("[14] Exit");
		System.out.println(bar);
		
		userInput = scanner.nextLine();
		
		switch (userInput) {
		case "0":
			employeeMenuService.ViewNaughtyNiceList();
			break;
		case "1":
			managerMenuService.addChildToList(scanner);
			break;
		case "2":
			managerMenuService.changeChildNaughtyStatus(scanner);
			break;
		case "3":
			employeeMenuService.ViewCurrentToyProduction();
			break;
		case "4":
			managerMenuService.addCurrentToy(scanner);
			break;
		case "5":
			managerMenuService.removeCurrentToy(scanner);
			break;
		case "6":
			employeeMenuService.ViewToyHistory();
			break;
		case "7":
			employeeMenuService.ViewSpecificYearToyHistory(scanner);
			break;
		case "8":
			employeeMenuService.ViewAllChildsToys(scanner);
			break;
		case "9":
			managerMenuService.viewToysMadeByWorker(scanner);
			break;
		case "10":
			employeeMenuService.SendToyToHistory(scanner);
			break;
		case "11":
			managerMenuService.totalDeliveredToys();
			break;
		case "12":
			managerMenuService.addElvenWorker(scanner);
			break;
		case "13":
			managerMenuService.removeElvenWorker(scanner);
			break;
		case "14":
			System.out.println("Exiting..");
			connectionManager.closeConnection();
			break;
		default:
			System.out.println("Invalid input please try again!");
			System.out.println();
			}
		}
		while (!userInput.equals("14"));
		
	}

}
