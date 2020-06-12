package com.jamakick.santasWorkshop.interfaces.db;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;

public interface NaughtyNiceServiceInterface {
	
	public <T> ArrayList<T> getFullNaughtyNiceList(Connection connection);
	public boolean addChildToList(Connection connection, Child child);
	public boolean changeChildNaughtyStatus(Connection connection, int childID, boolean naughty);

}
