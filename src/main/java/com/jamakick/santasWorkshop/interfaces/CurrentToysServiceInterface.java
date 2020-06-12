package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

public interface CurrentToysServiceInterface {
	
	public <T> ArrayList<T> getFullToyProduction(Connection connection);

}
