package com.jamakick.santasWorkshop.interfaces.db;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.PastToy;

public interface ToyHistoryServiceInterface {
	
	public ArrayList<PastToy> getFullToyHistory(Connection connection);
	public ArrayList<PastToy> getSpecificYearToyHistory(Connection connection, int year);
	public ArrayList<PastToy> getChildToys(Connection connection, int childID);
	public ArrayList<PastToy> viewToysMadeByWorker(Connection connection, int elvenID);
	public Array totalDeliveredToys(Connection connection);
	public boolean insertIntoToyHistory(Connection connection, PastToy toy);

}
