package com.jamakick.santasWorkshop.db;

import java.sql.Connection;

import com.jamakick.santasWorkshop.interfaces.ElvenWorkersServiceInterface;
import com.jamakick.santasWorkshop.object.Elf;

public class ElvenWorkersService implements ElvenWorkersServiceInterface {

	@Override
	public boolean addElvenWorker(Connection connection, Elf elf) {
		return false;
	}

	@Override
	public boolean removeElvenWorker(Connection connection, int elvenID) {
		return false;
	}

}
