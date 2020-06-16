package com.jamakick.santasWorkshop.operation;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jamakick.santasWorkshop.db.CompositeTableService;
import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.CurrentToysService;
import com.jamakick.santasWorkshop.db.ElvenWorkersService;
import com.jamakick.santasWorkshop.db.NaughtyNiceService;
import com.jamakick.santasWorkshop.db.ToyHistoryService;
import com.jamakick.santasWorkshop.interfaces.ManagerMenuServiceInterface;
import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.Elf;
import com.jamakick.santasWorkshop.object.PastToy;
import com.jamakick.santasWorkshop.object.Toy;
import com.jamakick.santasWorkshop.tools.Beautify;

public class ManagerMenuService implements ManagerMenuServiceInterface {
	
	private Connection connection = ConnectionManager.getConnection();
	private ToyHistoryService toyHistoryService = new ToyHistoryService();
	private CurrentToysService currentToysService = new CurrentToysService();
	private NaughtyNiceService naughtyNiceService = new NaughtyNiceService();
	private CompositeTableService compositeTableService = new CompositeTableService();
	private ElvenWorkersService elvenWorkersService = new ElvenWorkersService();

	@Override
	public void addChildToList(Scanner scanner) {
		
		System.out.println("What is the Child's Name?");
		String childName = scanner.nextLine();
		System.out.println("What is the Child's Age?");
		int childAge = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Is the Child naughty? (true/false)");
		boolean naughty = scanner.nextBoolean();
		scanner.nextLine();
		Child child = new Child(childName, childAge, naughty);
		
		boolean result = naughtyNiceService.addChildToList(connection, child);
		
		if (result) {
			System.out.println("Child added to the Naughty Nice list.");
		}
		else {
			System.out.println("Child could not be added to the Naughty Nice list.");
		}
	}

	@Override
	public void changeChildNaughtyStatus(Scanner scanner) {
		
		System.out.println("What is the Child's ID?");
		int childID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Is the child naughty? (true/false)");
		boolean naughty = scanner.nextBoolean();
		scanner.nextLine();
		
		boolean result = naughtyNiceService.changeChildNaughtyStatus(connection, childID, naughty);
		
		if (result) {
			System.out.println("Child ID: " + Integer.toString(childID) + " had their naughty status changed to " + naughty + ".");
		}
		else {
			System.out.println("Child ID: " + Integer.toString(childID) + "'s naughty status could not be changed.");
		}
	}

	@Override
	public void addCurrentToy(Scanner scanner) {
		
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
		Toy toy = new Toy(addToyName, addToyColor, addToyWorktime, addToyChildID, addToyElvenID);
		
		boolean result = currentToysService.addCurrentToy(connection, toy);
		
		if (result) {
			System.out.println(addToyName + " was added to the Toy Production. ");
		}
		else {
			System.out.println(addToyName + " could not be added to the Toy Production. ");
		}
	}

	@Override
	public void removeCurrentToy(Scanner scanner) {
		
		System.out.println("What is the Toy ID?");
		int toyID = scanner.nextInt();
		scanner.nextLine();
		
		boolean result = currentToysService.removeCurrentToy(connection, toyID);
		
		if (result) {
			System.out.println("Toy ID: " + Integer.toString(toyID) + " was removed from Toy Production.");
		}
		else {
			System.out.println("Toy ID: " + Integer.toString(toyID) + " could not be removed from Toy Production.");
		}
	}

	@Override
	public void viewToysMadeByWorker(Scanner scanner) {
		
		System.out.println("What elven worker's ID would you like to view Toy History for?");
		int elvenID = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<PastToy> toys = toyHistoryService.viewToysMadeByWorker(connection, elvenID);
		
		Beautify.printToyHistoryTable(toys);
	}

	@Override
	public void totalDeliveredToys() {
		
		Array results = toyHistoryService.totalDeliveredToys(connection);
		
		Integer[] printDelivered = null;
		try {
			printDelivered = (Integer[]) results.getArray();
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
		System.out.println("Amount of Delivered Toys: " + printDelivered[0]);
		System.out.println("Amount of Scrapped Toys: " + printDelivered[1]);
		
		
	}

	@Override
	public void addElvenWorker(Scanner scanner) {
		
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
		Elf elf = new Elf(addElfName, addElfAge,
				addElfPositionName, addElfShiftNum, addElfToyProd);
		
		boolean result = elvenWorkersService.addElvenWorker(connection, elf);
		
		if (result) {
			System.out.println(addElfName + " was added to the list of Elven Workers. ");
		}
		else {
			System.out.println(addElfName + " could not be added to the list of Elven Workers. ");
		}
	}

	@Override
	public void removeElvenWorker(Scanner scanner) {
		
		System.out.println("What is the Elf's ID?");
		int elvenID = scanner.nextInt();
		scanner.nextLine();
		
		boolean result = elvenWorkersService.removeElvenWorker(connection, elvenID);
		
		if (result) {
			System.out.println("Elven ID: " + Integer.toString(elvenID) + " was removed from the list of Elven Workers.");
		}
		else {
			System.out.println("Elven ID: " + Integer.toString(elvenID) + " could not be removed from the list of Elven Workers.");
		}
	}
	
	@Override
	public void viewElvenWorkers() {
		
		ArrayList<Elf> elves = elvenWorkersService.viewElvenWorkers(connection);
		
		Beautify.printElvenWorkersTable(elves);
		
	}

}
