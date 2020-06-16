package com.jamakick.santasWorkshop.tools;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.Elf;
import com.jamakick.santasWorkshop.object.FullProductionObject;
import com.jamakick.santasWorkshop.object.PastToy;
import com.jamakick.santasWorkshop.object.Toy;

public class Beautify {
	
	
	public static void printChildTable(ArrayList<Child> children) {
		String bar = "--------------------------------------------------------------------";
		System.out.println(bar);
		System.out.println(String.format("| %-10s | %-25s | %-10s | %-10s |", "childID", "childName", "childAge", "naughty"));
		System.out.println(bar);
		for(Child child: children) {
			System.out.println(String.format("| %-10s | %-25s | %-10s | %-10s |",
					child.getChildID(), child.getChildName(), child.getChildAge(), child.getNaughty()));
		}
		
		System.out.println(bar);
		
	}
	
	public static void printFullProductionTable(ArrayList<FullProductionObject> fullProd) {
		String bar = "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
		System.out.println(bar);
		System.out.println(String.format("| %-5s | %-20s | %-10s | %-10s | %-20s | %-10s | %-20s | %-20s | %-13s | %-15s |"
				, "toyID", "toyName", "toyColor", "workTime", "childName", "naughty",
				"elvenName", "positionName", "shiftNumber", "numProducedToys"));
		System.out.println(bar);
		for(FullProductionObject obj: fullProd) {
			System.out.println(String.format("| %-5s | %-20s | %-10s | %-10s | %-20s | %-10s | %-20s | %-20s | %-13s | %-15s |",
					obj.getToyID(), obj.getToyName(), obj.getToyColor(), obj.getWorkTime(), obj.getChildName(), obj.isNaughty(),
					obj.getElvenName(), obj.getPositionName(), obj.getShiftNumber(), obj.getNumProducedToys()));
		}
		
		System.out.println(bar);
		
	}
	
	public static void printToyTable(ArrayList<Toy> toys) {
		String bar = "---------------------------------------------------------------------------------------------------------";
		System.out.println(bar);
		System.out.println(String.format("| %-10s | %-25s | %-25s | %-10s | %-10s | %-10s |", "toyID", "toyName", "toyColor", "workTime", "childID", "elvenID"));
		System.out.println(bar);
		for(Toy toy: toys) {
			System.out.println(String.format("| %-10s | %-25s | %-25s | %-10s | %-10s | %-10s |",
					toy.getToyID(), toy.getToyName(), toy.getToyColor(), toy.getWorkTime(), toy.getChildID(), toy.getElvenID()));
		}
		
		System.out.println(bar);
		
	}
	
	public static void printToyHistoryTable(ArrayList<PastToy> toys) {
		String bar = "--------------------------------------------------------------------------------------------------------------------------------------------";
		System.out.println(bar);
		System.out.println(String.format("| %-10s | %-25s | %-25s | %-10s | %-10s | %-10s | %-15s | %-10s |", "toyID", "toyName", "toyColor", "workTime", "childID", "elvenID", "yearProduced", "delivered"));
		System.out.println(bar);
		for(PastToy toy: toys) {
			System.out.println(String.format("| %-10s | %-25s | %-25s | %-10s | %-10s | %-10s | %-15s | %-10s |",
					toy.getToyID(), toy.getToyName(), toy.getToyColor(), toy.getWorkTime(), toy.getChildID(), toy.getElvenID(), toy.getYearProduced(), toy.isDelivered()));
		}
		
		System.out.println(bar);
		
	}
	
	public static void printElvenWorkersTable(ArrayList<Elf> elves) {
		String bar = "----------------------------------------------------------------------------------------------------------------------------------";
		System.out.println(bar);
		System.out.println(String.format("| %-10s | %-25s | %-15s | %-25s | %-15s | %-20s |", "elvenID", "elvenName", "elvenAge", "positionName", "shiftNumber", "numProducedToys"));
		System.out.println(bar);
		for(Elf elf: elves) {
			System.out.println(String.format("| %-10s | %-25s | %-15s | %-25s | %-15s | %-20s |",
					elf.getElvenID(), elf.getElvenName(), elf.getElvenAge(), elf.getPositionName(), elf.getShiftNumber(), elf.getNumProducedToys()));
		}
		
		System.out.println(bar);
		
	}

}
