package com.jamakick.santasWorkshop.interfaces;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.Elf;
import com.jamakick.santasWorkshop.object.Toy;

public interface ManagerMenuServiceInterface {
	
	public boolean addChildToList(Child child);
	public boolean changeChildNaughtyStatus(int childID);
	public boolean addCurrentToy(Toy toy);
	public boolean removeCurrentToy(int toyID);
	public ArrayList<Toy> viewToysMadeByWorker(int elvenID);
	public int[] totalDeliveredToys();
	public boolean addElvenWorker(Elf elf);
	public boolean removeElvenWorker(int elvenID);

}
