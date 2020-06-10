package com.jamakick.santasWorkshop.menu;

import java.util.Scanner;

import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.operation.MainMenuService;

public class MainMenu implements MenuInterface {
	
	private MainMenuService mainMenuService = new MainMenuService();
	
	public void start(Scanner scanner) {
		
		String userInput;
		String bar = "-------------------------------------------------------------------";
		
		System.out.println("Welcome to Santa's Workshop");
		System.out.println(bar);
		System.out.println("Are you a manager(head elf) or an employee(elf)?");
		System.out.println("[0] Manager");
		System.out.println("[1] Employee");
		System.out.println(bar);

		userInput = scanner.nextLine();

		switch (userInput) {
		case "0":
			System.out.println("Manager selected");
			mainMenuService.toManagerMenu(scanner);
			break;
		case "1":
			System.out.println("Employee selected");
			mainMenuService.toEmployeeMenu(scanner);
			break;
		default:
			System.out.println("Invalid input please try again!");
			System.out.println();
			this.start(scanner);
		}
		
	}
}
