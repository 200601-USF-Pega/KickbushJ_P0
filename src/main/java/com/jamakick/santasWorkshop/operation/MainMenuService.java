package com.jamakick.santasWorkshop.operation;

import java.util.Scanner;

import com.jamakick.santasWorkshop.menu.EmployeeMenu;
import com.jamakick.santasWorkshop.menu.ManagerMenu;

public class MainMenuService {
	
	private ManagerMenu managerMenu = new ManagerMenu();
	private EmployeeMenu employeeMenu = new EmployeeMenu();
	
	public void toManagerMenu(Scanner scanner) {
		managerMenu.start(scanner);
	}
	
	public void toEmployeeMenu(Scanner scanner) {
		employeeMenu.start(scanner);
	}

}
