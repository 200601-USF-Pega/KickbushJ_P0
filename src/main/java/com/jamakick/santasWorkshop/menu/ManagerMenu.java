package com.jamakick.santasWorkshop.menu;

import java.util.Scanner;

import com.jamakick.santasWorkshop.interfaces.MenuInterface;

public class ManagerMenu implements MenuInterface {

	@Override
	public void start(Scanner scanner) {
		
		String userInput;
		String bar = "-------------------------------------------------------------------";
		
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
		case "6":
			break;
		case "7":
			break;
		case "8":
			break;
		case "9":
			break;
		case "10":
			break;
		case "11":
			break;
		default:
			System.out.println("Invalid input please try again!");
			System.out.println();
			this.start(scanner);
		}
		
	}

}
