package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import User.User;

public class ThirdMenu {

	public void thirdMenu(User user, Scanner scanner, int subManuChoice) throws SQLException, MalformedURLException, IOException {
		MainMenu call = new MainMenu();
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Eladási statisztikák");
			call.mainMenu(user, scanner);
			break;
		case 2:
			System.out.println("	[2] Keresési statisztikák");
			call.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			call.mainMenu(user, scanner);
			break;
		}
	}

	public void printThirdMenu() {
		System.out.println("	 					  	 ║");
		System.out.println("	 						 ╠ [1] Eladási statisztikák");
		System.out.println("	 						 ╠ [2] Keresési statisztikák");
		System.out.println("	 						 ╚ [3] Vissza a főmenübe");

	}

}
