package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;

public interface NaughtyNiceServiceInterface {
	
	public ArrayList<Child> getFullNaughtyNiceList(Connection connection);

}
