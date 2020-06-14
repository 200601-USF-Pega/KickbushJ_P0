package com.jamakick.santasWorkshop.interfaces.db;

import java.sql.Connection;

import com.jamakick.santasWorkshop.object.Elf;

public interface ElvenWorkersServiceInterface {
	
	public boolean addElvenWorker(Connection connection, Elf elf);
	public boolean removeElvenWorker(Connection connection, int elvenID);
	public boolean updateElvenWorkerToys(Connection connection, int elvenID);

}
