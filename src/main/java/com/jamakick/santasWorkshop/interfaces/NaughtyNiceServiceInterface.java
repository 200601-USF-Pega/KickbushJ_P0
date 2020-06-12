package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

public interface NaughtyNiceServiceInterface {
	
	public <T> ArrayList<T> getFullNaughtyNiceList(Connection connection);

}
