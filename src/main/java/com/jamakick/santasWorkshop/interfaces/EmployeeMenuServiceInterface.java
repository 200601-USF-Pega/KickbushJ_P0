package com.jamakick.santasWorkshop.interfaces;

import java.util.ArrayList;

public interface EmployeeMenuServiceInterface {
	
	public <T> ArrayList<T> ViewNaughtyNiceList();
	public <T> ArrayList<T> ViewCurrentToyProduction();
	public <T> ArrayList<T> ViewToyHistory();
	public <T> ArrayList<T> ViewSpecificYearToyHistory();
	public <T> ArrayList<T> ViewAllChildsToys();
	public <T> ArrayList<T> SendToyToHistory();
	

}
