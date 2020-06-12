package com.jamakick.santasWorkshop.interfaces;

import java.sql.Connection;

import com.jamakick.santasWorkshop.object.Elf;

public interface ElvenWorkersServiceInterface {
	
	public boolean addElvenWorker(Connection connection, Elf elf);
	public boolean removeElvenWorker(Connection connection, int elvenID);

}
