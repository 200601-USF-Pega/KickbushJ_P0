package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

public interface CompositeTableServiceInterface {
	
	public boolean sendToyToHistory(Connection connection, int toyID,
			int newToyYear, boolean newToyDelivered);

}
