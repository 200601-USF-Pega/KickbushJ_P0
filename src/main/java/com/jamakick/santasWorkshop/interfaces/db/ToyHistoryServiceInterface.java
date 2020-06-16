package com.jamakick.santasWorkshop.interfaces.db;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.PastToy;

public interface ToyHistoryServiceInterface {
	
	public <T> ArrayList<T> getFullToyHistory(Connection connection);
	public <T> ArrayList<T> getSpecificYearToyHistory(Connection connection, int year);
	public <T> ArrayList<T> getChildToys(Connection connection, int childID);
	public <T> ArrayList<T> viewToysMadeByWorker(Connection connection, int elvenID);
	public Array totalDeliveredToys(Connection connection);
	public boolean insertIntoToyHistory(Connection connection, PastToy toy);

}