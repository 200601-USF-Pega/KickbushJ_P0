package com.jamakick.santasWorkshop.tools;

import java.util.ArrayList;

import com.jamakick.santasWorkshop.object.Child;

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

}
