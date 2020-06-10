package santasWorkshop;

import java.util.Scanner;

import com.jamakick.santasWorkshop.object.Child;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Child child = new Child(0, "Jake Kickbush", true);
		
		System.out.println(child.toString());

	}

}
