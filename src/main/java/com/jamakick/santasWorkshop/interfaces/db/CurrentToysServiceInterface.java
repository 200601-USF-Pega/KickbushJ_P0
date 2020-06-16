package com.jamakick.santasWorkshop.interfaces.db;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.FullProductionObject;
import com.jamakick.santasWorkshop.object.Toy;

public interface CurrentToysServiceInterface {
	
	public ArrayList<FullProductionObject> getFullToyProduction(Connection connection);
	public boolean addCurrentToy(Connection connection, Toy toy);
	public boolean removeCurrentToy(Connection connection, int toyID);
	public Toy selectFromToysByID(Connection connection, int toyID);

}
