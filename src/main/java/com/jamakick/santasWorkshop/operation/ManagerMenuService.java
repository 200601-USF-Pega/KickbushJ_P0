package com.jamakick.santasWorkshop.operation;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop.db.CompositeTableService;
import com.jamakick.santasWorkshop.db.ConnectionManager;
import com.jamakick.santasWorkshop.db.CurrentToysService;
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

	@Override
	public boolean addChildToList(Child child) {
		return false;
	}

	@Override
	public boolean changeChildNaughtyStatus(int childID) {
		return false;
	}

	@Override
	public boolean addCurrentToy(Toy toy) {
		return false;
	}

	@Override
	public boolean removeCurrentToy(int toyID) {
		return false;
	}

	@Override
	public ArrayList<Toy> viewToysMadeByWorker(int elvenID) {
		return null;
	}

	@Override
	public Array totalDeliveredToys() {
		
		Array results = toyHistoryService.totalDeliveredToys(connection);
		
		connectionManager.closeConnection();
		
		return results;
	}

	@Override
	public boolean addElvenWorker(Elf elf) {
		return false;
	}

	@Override
	public boolean removeElvenWorker(int elvenID) {
		return false;
	}

}
