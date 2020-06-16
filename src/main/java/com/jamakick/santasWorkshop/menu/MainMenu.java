package com.jamakick.santasWorkshop.menu;

import java.util.Scanner;

import com.jamakick.santasWorkshop.interfaces.MenuInterface;
import com.jamakick.santasWorkshop.operation.MainMenuService;

public class MainMenu implements MenuInterface {
	
	private MainMenuService mainMenuService = new MainMenuService();
//	private ConnectionManager connectionManager = new ConnectionManager();
	
	
	public void start(Scanner scanner) {
		
//		connectionManager.createTablesAndDummyData();
		
		boolean[] results = mainMenuService.isManager(scanner);
		
		if (results[0] == true) {
			
			if (results[1] == true) {
				mainMenuService.toManagerMenu(scanner);
			}
			
			else if (results[1] == false) {
				mainMenuService.toEmployeeMenu(scanner);
			}
			
		}
		
		else if (results[0] == false) {
			
			System.out.println("Employee Login Details Were Not Entered Correctly, Exiting...");
			this.start(scanner);
		}
		
	}
}
