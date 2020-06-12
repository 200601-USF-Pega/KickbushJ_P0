package com.jamakick.santasWorkshop.menu;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.Elf;
import com.jamakick.santasWorkshop.object.Toy;
import com.jamakick.santasWorkshop.operation.EmployeeMenuService;
import com.jamakick.santasWorkshop.operation.ManagerMenuService;

public class ManagerMenu<T> implements MenuInterface {
	
	private ManagerMenuService managerMenuService = new ManagerMenuService();
	private EmployeeMenuService employeeMenuService = new EmployeeMenuService();
	private ArrayList<T> result;
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
			result = employeeMenuService.ViewNaughtyNiceList();
			System.out.println(result.toString());
			break;
		case "1":
			System.out.println("What is the Child's Name?");
			String childName = scanner.nextLine();
			System.out.println("What is the Child's Age?");
			int childAge = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Is the Child naughty? (true/false)");
			boolean naughty = scanner.nextBoolean();
			scanner.nextLine();
			Child addChild = new Child(childName, childAge, naughty);
			boolean addChildResult = managerMenuService.addChildToList(addChild);
			System.out.println(addChildResult);
			break;
		case "2":
			System.out.println("What is the Child's ID?");
			int changeNaughtyChildID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Is the child naughty? (true/false)");
			boolean changeNaughty = scanner.nextBoolean();
			scanner.nextLine();
			boolean updateChildNaughty = managerMenuService.changeChildNaughtyStatus(
					changeNaughtyChildID, changeNaughty);
			System.out.println(updateChildNaughty);
			break;
		case "3":
			result = employeeMenuService.ViewCurrentToyProduction();
			System.out.println(result.toString());
			break;
		case "4":
			System.out.println("What is the Toy Name?");
			String addToyName = scanner.nextLine();
			System.out.println("What is the Toy Color?");
			String addToyColor = scanner.nextLine();
			System.out.println("How long will the Toy take to make?");
			float addToyWorktime = scanner.nextFloat();
			scanner.nextLine();
			System.out.println("What child ID is this Toy being made for?");
			int addToyChildID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("What elf worker ID is making this Toy?");
			int addToyElvenID = scanner.nextInt();
			scanner.nextLine();
			Toy addToy = new Toy(addToyName, addToyColor, addToyWorktime, addToyChildID, addToyElvenID);
			boolean addToyResult = managerMenuService.addCurrentToy(addToy);
			System.out.println(addToyResult);
			break;
		case "5":
			System.out.println("What is the Toy ID?");
			int removeToyID = scanner.nextInt();
			scanner.nextLine();
			boolean removeToyResult = managerMenuService.removeCurrentToy(removeToyID);
			System.out.println(removeToyResult);
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
			System.out.println("What elven worker's ID would you like to view Toy History for?");
			int viewToysElvenID = scanner.nextInt();
			scanner.nextLine();
			result = (ArrayList<T>) managerMenuService.viewToysMadeByWorker(viewToysElvenID);
			System.out.println(result.toString());
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
			Array deliveredResult = managerMenuService.totalDeliveredToys();
			Integer[] printDelivered = null;
			try {
				printDelivered = (Integer[]) deliveredResult.getArray();
			} catch (SQLException e) {
				System.out.println("Exception: " + e);
				e.printStackTrace();
			}
			System.out.println("Amount of Delivered Toys: " + printDelivered[0]);
			System.out.println("Amount of Scrapped Toys: " + printDelivered[1]);
			break;
		case "12":
			System.out.println("What is the Elf's Name?");
			String addElfName = scanner.nextLine();
			System.out.println("What is the Elf's Age?");
			int addElfAge = scanner.nextInt();
			scanner.nextLine();
			System.out.println("What is the Elf's Position Name?");
			String addElfPositionName = scanner.nextLine();
			System.out.println("What is the Elf's Shift Number? (1, 2, or 3)");
			int addElfShiftNum = scanner.nextInt();
			scanner.nextLine();
			System.out.println("How many toys has the elf produced?");
			int addElfToyProd = scanner.nextInt();
			scanner.nextLine();
			Elf addElf = new Elf(addElfName, addElfAge,
					addElfPositionName, addElfShiftNum, addElfToyProd);
			boolean addElfResult = managerMenuService.addElvenWorker(addElf);
			System.out.println(addElfResult);
			break;
		case "13":
			System.out.println("What is the Elf's ID?");
			int removeElfID = scanner.nextInt();
			scanner.nextLine();
			boolean removeElfResult = managerMenuService.removeElvenWorker(removeElfID);
			System.out.println(removeElfResult);
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
