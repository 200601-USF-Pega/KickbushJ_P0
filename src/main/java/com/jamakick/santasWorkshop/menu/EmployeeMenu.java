package com.jamakick.santasWorkshop.menu;

import java.util.Scanner;

import com.jamakick.santasWorkshop.interfaces.MenuInterface;

public class EmployeeMenu implements MenuInterface {

	@Override
	public void start(Scanner scanner) {
		
		String userInput;
		String bar = "-------------------------------------------------------------------";
		
		System.out.println("Welcome Employee, what would you like to do today?");
		System.out.println(bar);
		System.out.println("[0] View the Naughty and Nice list");
		System.out.println("[1] View the Current Toy Production (Toys Currently Slated to be Created)");
		System.out.println("[2] View Toy Production History from All Years");
		System.out.println("[3] View Toy Production by Specific Year");
		System.out.println("[4] View All Toys made for a Specific Child");
		System.out.println("[5] Confirm Delivery/Scrapping of a Current Toy");
		System.out.println(bar);
		
		userInput = scanner.nextLine();
		
		switch (userInput) {
		case "0":
			break;
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			break;
		default:
			System.out.println("Invalid input please try again!");
			System.out.println();
			this.start(scanner);
		}
		
	}

}
