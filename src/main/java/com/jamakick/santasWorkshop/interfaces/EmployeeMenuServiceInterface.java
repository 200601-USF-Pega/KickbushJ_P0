package com.jamakick.santasWorkshop.interfaces;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;

public interface EmployeeMenuServiceInterface {
	
	public <T> ArrayList<T> ViewNaughtyNiceList();
	public <T> ArrayList<T> ViewCurrentToyProduction();
	public <T> ArrayList<T> ViewToyHistory();
	public <T> ArrayList<T> ViewSpecificYearToyHistory(int year);
	public <T> ArrayList<T> ViewAllChildsToys(int childID);
	public boolean SendToyToHistory(int toyID, int newToyYear, boolean newToyDelivered);
	

}
