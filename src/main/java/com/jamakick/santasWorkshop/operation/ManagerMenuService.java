package com.jamakick.santasWorkshop.operation;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.db.CompositeTableService;
import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.CurrentToysService;
import com.jamakick.santasWorkshop.db.ElvenWorkersService;
import com.jamakick.santasWorkshop.db.NaughtyNiceService;
import com.jamakick.santasWorkshop.db.ToyHistoryService;
import com.jamakick.santasWorkshop.interfaces.ManagerMenuServiceInterface;
import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.Elf;
import com.jamakick.santasWorkshop.object.Toy;

public class ManagerMenuService implements ManagerMenuServiceInterface {
	
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connection = connectionManager.getConnection();
	private ToyHistoryService toyHistoryService = new ToyHistoryService();
	private CurrentToysService currentToysService = new CurrentToysService();
	private NaughtyNiceService naughtyNiceService = new NaughtyNiceService();
	private CompositeTableService compositeTableService = new CompositeTableService();
	private ElvenWorkersService elvenWorkersService = new ElvenWorkersService();

	@Override
	public boolean addChildToList(Child child) {
		
		boolean result = naughtyNiceService.addChildToList(connection, child);
				
		return result;
	}

	@Override
	public boolean changeChildNaughtyStatus(int childID, boolean naughty) {
		
		boolean result = naughtyNiceService.changeChildNaughtyStatus(connection, childID, naughty);
		
		return result;
	}

	@Override
	public boolean addCurrentToy(Toy toy) {
		
		boolean result = currentToysService.addCurrentToy(connection, toy);
		
		return result;
	}

	@Override
	public boolean removeCurrentToy(int toyID) {
		
		boolean result = currentToysService.removeCurrentToy(connection, toyID);
		
		return result;
	}

	@Override
	public ArrayList<Toy> viewToysMadeByWorker(int elvenID) {
		
		ArrayList<Toy> toys = toyHistoryService.viewToysMadeByWorker(connection, elvenID);
		
		
		return toys;
	}

	@Override
	public Array totalDeliveredToys() {
		
		Array results = toyHistoryService.totalDeliveredToys(connection);
		
		
		return results;
	}

	@Override
	public boolean addElvenWorker(Elf elf) {
		
		boolean result = elvenWorkersService.addElvenWorker(connection, elf);
		
		return result;
	}

	@Override
	public boolean removeElvenWorker(int elvenID) {
		
		boolean result = elvenWorkersService.removeElvenWorker(connection, elvenID);
		
		return result;
	}

}
