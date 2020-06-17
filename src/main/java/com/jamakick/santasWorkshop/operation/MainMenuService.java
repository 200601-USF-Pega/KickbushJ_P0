package com.jamakick.santasWorkshop.operation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.LoginInfoService;
import com.jamakick.santasWorkshop.interfaces.MainMenuServiceInterface;
import com.jamakick.santasWorkshop.menu.EmployeeMenu;
import com.jamakick.santasWorkshop.menu.ManagerMenu;
import com.jamakick.santasWorkshop.object.LoginInfo;

public class MainMenuService implements MainMenuServiceInterface {
	
	private ManagerMenu managerMenu = new ManagerMenu();
	private EmployeeMenu employeeMenu = new EmployeeMenu();
	private LoginInfoService loginInfoService = new LoginInfoService();
	private ConnectionManager connectionManager = new ConnectionManager();
	
	public void toManagerMenu(Scanner scanner) {
		managerMenu.start(scanner);
	}
	
	public void toEmployeeMenu(Scanner scanner) {
		employeeMenu.start(scanner);
	}

	@Override
	public boolean[] isManager(Scanner scanner) {
		
		int empID = 0;
		LoginInfo info = new LoginInfo();
		String pass;
		boolean validInput = false;
		final String bar = "-------------------------------------------------------------------";
		
		System.out.println("Welcome to Santa's Workshop");
		System.out.println(bar);
		System.out.println("Please enter your Employee ID and Password");
		while (!validInput) {
		try {
		System.out.print("Employee ID:");
		empID = scanner.nextInt();
		scanner.nextLine();
		validInput = true;
		}
		catch (InputMismatchException e) {
			System.out.println("Please input a number for your Employee ID.");
			scanner.nextLine();

		}
		}
		System.out.print("Password:");
		pass = scanner.nextLine();

		try {
		info = loginInfoService.getLoginInfo(ConnectionManager.getConnection(), empID);
		
		boolean passMatch = false;
		boolean manager = false;
		
		if (info.getPass().equals(pass)) {
			passMatch = true;
		}
		
		if (info.isManager() == true) {
			manager = true;
		}
		
		boolean[] results = {passMatch, manager};
		
		return results;
		
		}
		
		catch (NullPointerException e) {
			System.out.println("Invalid Credentials given. Exiting...");
			System.exit(0);
			
		}

		return null;
	}

}
