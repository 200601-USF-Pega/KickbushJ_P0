package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Toy;

public interface CurrentToysServiceInterface {
	
	public <T> ArrayList<T> getFullToyProduction(Connection connection);
	public boolean addCurrentToy(Connection connection, Toy toy);
	public boolean removeCurrentToy(Connection connection, int toyID);

}
