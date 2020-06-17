package com.jamakick.santasWorkshop.operation;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	private ElvenWorkersService elvenWorkersService = new ElvenWorkersService();

	@Override
	public void addChildToList(Scanner scanner) {
		
		boolean validInput = false;
		int childAge = 0;
		boolean naughty = false;
		String childName = "";
		
		while (!validInput) {
			
			System.out.println("What is the Child's Name?");
			childName = scanner.nextLine();
			
			if (childName.matches("[a-zA-Z ]+")) {
				validInput = true;
			}
			
			else {
				System.out.println("Please enter a Child's Name, only letters and spaces.");
			}
		
		}
		
		validInput = false;
		
		while (!validInput) {
		try {
			System.out.println("What is the Child's Age?");
			childAge = scanner.nextInt();
			scanner.nextLine();
			if (childAge > -1 & childAge < 19) {
			validInput = true;
			}
			else {
				System.out.println("Please enter child age as a number between 0 and 18.");
			}
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter child age as a number between 0 and 18.");
			scanner.nextLine();
			}
		} 

		validInput = false;
		
		while (!validInput) {
		try {
			System.out.println("Is the Child naughty? (true/false)");
			naughty = scanner.nextBoolean();
			scanner.nextLine();
			validInput = true;
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter naughty as true or false.");
			scanner.nextLine();
			}
		} 

		
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
		
		boolean validInput = false;
		int childID = 0;
		boolean naughty = false;
		
		while (!validInput) {
			
		try {
		System.out.println("What is the Child's ID?");
		childID = scanner.nextInt();
		scanner.nextLine();
		if ( childID > -1) {
		validInput = true;
		}
		else {
			System.out.println("Please enter a non negative number for the child ID.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative number for the child ID.");
			scanner.nextLine();
		}
		
		}
		
		validInput = true;
		
		while (!validInput) {
		try {
			System.out.println("Is the child naughty? (true/false)");
			naughty = scanner.nextBoolean();
			scanner.nextLine();
			validInput = true;
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter naughty as true or false.");
			scanner.nextLine();
			}
		} 

		
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
		
		boolean validInput = false;
		String addToyName = "";
		String addToyColor = "";
		float addToyWorktime = 0;
		int addToyChildID = 0;
		int addToyElvenID = 0;
		
		while (!validInput) {
			
			System.out.println("What is the Toy Name?");
			addToyName = scanner.nextLine();
			
			if (addToyName.matches("[a-zA-Z0-9 ]+")) {
				validInput = true;
			}
			
			else {
				System.out.println("Please enter a Toy Name, with only letters, spaces, and numbers.");
			}
		
		}
		
		validInput = true;
		
		while (!validInput) {
			
			System.out.println("What is the Toy Color?");
			addToyColor = scanner.nextLine();
			
			if (addToyName.matches("[a-zA-Z ]+")) {
				validInput = true;
			}
			
			else {
				System.out.println("Please enter a Toy Color, with only letters and spaces.");
			}
		
		}
		
		validInput = true;
		
		while (!validInput) {
			
		try {
			System.out.println("How long will the Toy take to make?");
			addToyWorktime = scanner.nextFloat();
			scanner.nextLine();
			
		if (addToyWorktime >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative float for the Work Time.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative float for the Work Time.");
			scanner.nextLine();
		}
		
		}
		
		validInput = true;
		
		
		while (!validInput) {
			
		try {
			System.out.println("What child ID is this Toy being made for?");
			addToyChildID = scanner.nextInt();
			scanner.nextLine();
			
			
		if (addToyChildID >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative child ID.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative child ID.");
			scanner.nextLine();
		}
		
		}
		
		validInput = true;
		
		
		while (!validInput) {
			
		try {
			System.out.println("What elf worker ID is making this Toy?");
			addToyElvenID = scanner.nextInt();
			scanner.nextLine();
			
			
		if (addToyElvenID >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative elven ID.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative elven ID.");
			scanner.nextLine();
		}
		
		}
		
		
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
		
		boolean validInput = false;
		int toyID = 0;
		
		while (!validInput) {
			
		try {
			System.out.println("What is the Toy ID?");
			toyID = scanner.nextInt();
			scanner.nextLine();
			
			
		if (toyID >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative Toy ID.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative Toy ID.");
			scanner.nextLine();
		}
		
		}
		
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
		
		boolean validInput = false;
		int elvenID = 0;
		
		while (!validInput) {
			
		try {
			System.out.println("What elven worker's ID would you like to view Toy History for?");
			elvenID = scanner.nextInt();
			scanner.nextLine();
			
			
		if (elvenID >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative Elven ID.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative Elven ID.");
			scanner.nextLine();
		}
		
		}
		
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
		
		boolean validInput = false;
		String addElfName = "";
		int addElfAge = 0;
		String addElfPositionName = "";
		int addElfShiftNum = 0;
		int addElfToyProd = 0;
		
		while (!validInput) {
			
			System.out.println("What is the Elf's Name?");
			addElfName = scanner.nextLine();
			
			if (addElfName.matches("[a-zA-Z ]+")) {
				validInput = true;
			}
			
			else {
				System.out.println("Please enter an Elf name with only letters and spaces.");
			}
		
		}
		
		validInput = false;
		
		while (!validInput) {
			
		try {
			System.out.println("What is the Elf's Age?");
			addElfAge = scanner.nextInt();
			scanner.nextLine();
			
			
		if (addElfAge >= 0 & addElfAge < 120) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter an Elf Age from 0 to 120.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter an Elf Age from 0 to 120.");
			scanner.nextLine();
		}
		
		}

		validInput = false;
		
		
		while (!validInput) {
			
			System.out.println("What is the Elf's Position Name?");
			addElfPositionName = scanner.nextLine();
			
			if (addElfPositionName.matches("[a-zA-Z ]+")) {
				validInput = true;
			}
			
			else {
				System.out.println("Please enter a position name with only letters and spaces.");
			}
		
		}

		validInput = false;
		
		
		while (!validInput) {
			
		try {
			System.out.println("What is the Elf's Shift Number? (1, 2, or 3)");
			addElfShiftNum = scanner.nextInt();
			scanner.nextLine();
			
			
		if (addElfShiftNum > 0 & addElfShiftNum < 4) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a Shift Number (1,2,3)");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a Shift Number (1,2,3)");
			scanner.nextLine();
		}
		
		}
		
		validInput = false;
		
		while (!validInput) {
			
		try {
			System.out.println("How many toys has the elf produced?");
			addElfToyProd = scanner.nextInt();
			scanner.nextLine();
			
			
		if (addElfToyProd >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative number of produced toys.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative number of produced toys.");
			scanner.nextLine();
		}
		
		}
		
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
		
		boolean validInput = false;
		int elvenID = 0;
		
		
		while (!validInput) {
			
		try {
			System.out.println("What is the Elf's ID?");
			elvenID = scanner.nextInt();
			scanner.nextLine();
			
			
		if (elvenID >= 0) {
			validInput = true;
		}
		
		else {
			System.out.println("Please enter a non negative elven ID number.");
		}
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter a non negative elven ID number.");
			scanner.nextLine();
		}
		
		}
		
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
