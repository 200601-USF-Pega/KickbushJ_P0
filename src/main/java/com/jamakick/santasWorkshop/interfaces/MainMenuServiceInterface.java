package com.jamakick.santasWorkshop.interfaces;

import java.util.Scanner;

public interface MainMenuServiceInterface {
	
	public void toManagerMenu(Scanner scanner);
	public void toEmployeeMenu(Scanner scanner);
	public boolean[] isManager(Scanner scanner);

}
