package com.jamakick.santasWorkshop.operation;

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
	
	public void toManagerMenu(Scanner scanner) {
		managerMenu.start(scanner);
	}
	
	public void toEmployeeMenu(Scanner scanner) {
		employeeMenu.start(scanner);
	}

	@Override
	public boolean[] isManager(Scanner scanner) {
		
		int empID;
		String pass;
		final String bar = "-------------------------------------------------------------------";
		
		System.out.println("Welcome to Santa's Workshop");
		System.out.println(bar);
		System.out.println("Please enter your Employee ID and Password");
		System.out.println("Employee ID:");
		empID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Password:");
		pass = scanner.nextLine();
		
		LoginInfo info = loginInfoService.getLoginInfo(ConnectionManager.getConnection(), empID);
		
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

}
