package com.jamakick.santasWorkshop.interfaces;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;

public interface EmployeeMenuServiceInterface {
	
	public ArrayList<Child> ViewNaughtyNiceList();
	public <T> ArrayList<T> ViewCurrentToyProduction();
	public <T> ArrayList<T> ViewToyHistory();
	public <T> ArrayList<T> ViewSpecificYearToyHistory();
	public <T> ArrayList<T> ViewAllChildsToys();
	public <T> ArrayList<T> SendToyToHistory();
	

}
