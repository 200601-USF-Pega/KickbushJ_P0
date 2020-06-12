package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

public interface ToyHistoryServiceInterface {
	
	public <T> ArrayList<T> getFullToyHistory(Connection connection);
	public <T> ArrayList<T> getSpecificYearToyHistory(Connection connection, int year);
	public <T> ArrayList<T> getChildToys(Connection connection, int childID);
	public <T> ArrayList<T> viewToysMadeByWorker(Connection connection, int elvenID);
	public int[] totalDeliveredToys(Connection connection);

}
