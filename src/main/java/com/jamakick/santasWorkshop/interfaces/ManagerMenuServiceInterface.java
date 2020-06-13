package com.jamakick.santasWorkshop.interfaces;

import java.util.Scanner;

public interface ManagerMenuServiceInterface {
	
	public void addChildToList(Scanner scanner);
	public void changeChildNaughtyStatus(Scanner scanner);
	public void addCurrentToy(Scanner scanner);
	public void removeCurrentToy(Scanner scanner);
	public void viewToysMadeByWorker(Scanner scanner);
	public void totalDeliveredToys();
	public void addElvenWorker(Scanner scanner);
	public void removeElvenWorker(Scanner scanner);

}
