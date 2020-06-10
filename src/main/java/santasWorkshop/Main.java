package santasWorkshop;

import java.util.Scanner;

import com.jamakick.santasWorkshop.menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		MainMenu mainMenu = new MainMenu();
		mainMenu.start(input);
		

	}

}
