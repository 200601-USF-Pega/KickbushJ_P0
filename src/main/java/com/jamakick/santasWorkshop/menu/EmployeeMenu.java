package com.jamakick.santasWorkshop.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.operation.EmployeeMenuService;

public class EmployeeMenu<T> implements MenuInterface {
	
	private EmployeeMenuService employeeMenuService = new EmployeeMenuService();
	private ArrayList<T> result;

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
			result = (ArrayList<T>) employeeMenuService.ViewNaughtyNiceList();
			System.out.println(result.toString());
			break;
		case "1":
			result = employeeMenuService.ViewCurrentToyProduction();
			break;
		case "2":
			result = employeeMenuService.ViewToyHistory();
			break;
		case "3":
			result = employeeMenuService.ViewSpecificYearToyHistory();
			break;
		case "4":
			result = employeeMenuService.ViewAllChildsToys();
			break;
		case "5":
			result = employeeMenuService.SendToyToHistory();
			break;
		case "6":
			System.out.println("Exiting..");
			break;
		default:
			System.out.println("Invalid input please try again!");
			}
		
		}
		
		while (!userInput.equals("6"));
		
		
	}

}
