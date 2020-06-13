package com.jamakick.santasWorkshop.interfaces;

import java.util.Scanner;

public interface EmployeeMenuServiceInterface {
	
	public void ViewNaughtyNiceList();
	public void ViewCurrentToyProduction();
	public void ViewToyHistory();
	public void ViewSpecificYearToyHistory(Scanner scanner);
	public void ViewAllChildsToys(Scanner scanner);
	public void SendToyToHistory(Scanner scanner);
	

}
