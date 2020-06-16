package com.jamakick.santasWorkshop.tools;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;
import com.jamakick.santasWorkshop.object.FullProductionObject;

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
		String bar = "----------------------------------------------------------------------------------------------------------------------------------";
		System.out.println(bar);
		System.out.println(String.format("| %-5s | %-15s | %-10s | %-5s | %-20s | %-5s | %-20s | %-20s | %-5s | %-5s |"
				, "toyID", "toyName", "toyColor", "workTime", "childName", "naughty",
				"elvenName", "positionName", "shiftNumber", "numProducedToys"));
		System.out.println(bar);
		for(FullProductionObject obj: fullProd) {
			System.out.println(String.format("| %-5s | %-15s | %-10s | %-5s | %-20s | %-5s | %-20s | %-20s | %-5s | %-5s |",
					obj.getToyID(), obj.getToyName(), obj.getToyColor(), obj.getWorkTime(), obj.getChildName(), obj.isNaughty(),
					obj.getElvenName(), obj.getPositionName(), obj.getShiftNumber(), obj.getNumProducedToys()));
		}
		
		System.out.println(bar);
		
	}

}
