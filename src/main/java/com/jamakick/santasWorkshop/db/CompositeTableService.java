package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jamakick.santasWorkshop.interfaces.db.CompositeTableServiceInterface;
import com.jamakick.santasWorkshop.object.PastToy;
import com.jamakick.santasWorkshop.object.Toy;

public class CompositeTableService implements CompositeTableServiceInterface {
	
	private CurrentToysService currentToysService = new CurrentToysService();
	private ElvenWorkersService elvenWorkersService = new ElvenWorkersService();
	private ToyHistoryService toyHistoryService = new ToyHistoryService();

	@Override
	public boolean sendToyToHistory(Connection connection, int toyID, int newToyYear,
			boolean newToyDelivered) {
		
			Toy selectToy = currentToysService.selectFromToysByID(connection, toyID);
			PastToy toy = new PastToy(selectToy);
			toy.setYearProduced(newToyYear);
			toy.setDelivered(newToyDelivered);
			
			currentToysService.removeCurrentToy(connection, toyID);
			
			elvenWorkersService.updateElvenWorkerToys(connection, toy.getElvenID());
		
			toyHistoryService.insertIntoToyHistory(connection, toy);
			
			return true;
			
		}
		
	}

