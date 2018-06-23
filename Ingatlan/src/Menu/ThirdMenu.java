package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import User.User;

public class ThirdMenu {

	public static void thirdMenu(User user, Scanner scanner, int subManuChoice) throws SQLException {
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Eladási statisztikák");
			MainMenu.mainMenu(user, scanner);
			break;
		case 2:
			System.out.println("	[2] Keresési statisztikák");
			MainMenu.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			MainMenu.mainMenu(user, scanner);
			break;
		}
	}

	public static void printThirdMenu() {
		System.out.println("	 					  	 ║");
		System.out.println("	 						 ╠ [1] Eladási statisztikák");
		System.out.println("	 						 ╠ [2] Keresési statisztikák");
		System.out.println("	 						 ╚ [3] Vissza a főmenübe");
		System.out.print(
				"	                                                                                              "
						+ "	 => a választott almenü: ");
	}

}
