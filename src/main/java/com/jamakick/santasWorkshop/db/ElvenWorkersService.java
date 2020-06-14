package com.jamakick.santasWorkshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jamakick.santasWorkshop.interfaces.db.ElvenWorkersServiceInterface;
import com.jamakick.santasWorkshop.object.Elf;

public class ElvenWorkersService implements ElvenWorkersServiceInterface {

	@Override
	public boolean addElvenWorker(Connection connection, Elf elf) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call addElf(?, ?, ?, ?, ?);");
			
			pst.setString(1, elf.getElvenName());
			pst.setInt(2, elf.getElvenAge());
			pst.setString(3, elf.getPositionName());
			pst.setInt(4, elf.getShiftNumber());
			pst.setInt(5, elf.getNumProducedToys());
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeElvenWorker(Connection connection, int elvenID) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call removeElf(?);");
			
			pst.setInt(1, elvenID);
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateElvenWorkerToys(Connection connection, int elvenID) {

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("UPDATE ElvenWorkers "
					+ "SET numProducedToys = numProducedToys + 1 "
					+ "WHERE elvenID = ?");
			
			pst.setInt(1, elvenID);
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			return false;
		}

	}

}
