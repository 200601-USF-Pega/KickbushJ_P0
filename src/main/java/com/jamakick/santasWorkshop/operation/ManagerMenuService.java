package com.jamakick.santasWorkshop.operation;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.interfaces.ManagerMenuServiceInterface;
import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.Elf;
import com.jamakick.santasWorkshop.object.Toy;

public class ManagerMenuService implements ManagerMenuServiceInterface {

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
	public int[] totalDeliveredToys() {
		return null;
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
