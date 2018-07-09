package Menu;

import java.sql.SQLException;
import java.util.Scanner;
import User.User;

public class FirstMenu {

	public static void firstMenu(User user, Scanner scanner, int subManuChoice) throws SQLException {
		MainMenu mm = new MainMenu();
		FirstMenuSubMenus fs = new FirstMenuSubMenus();
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Ingatlan keresés╗");
			System.out.println("   	                    ║");
			System.out.println(" 	                    ╠ {1} Ingatlan keresés ID alapján");
			System.out.println(" 	                    ╚ {2} Ingatlan keresés paraméter alapján");
			fs.firstSubMeu();
			break;
		case 2:
			System.out.println("	[2] Új ingatlan hozzáadása╗");
			System.out.println("                                  ║");
			System.out.println("                                  ╠ {1} Mentés");
			System.out.println("                                  ╚ {2} Elvetés");
			fs.secondSubMeu();
			break;
		case 3:
			System.out.println();
			mm.mainMenu(user, scanner);
			break;
		}
	}

	public static void printFirstMenu() {
		System.out.println("	   	 ║");
		System.out.println("	 	 ╠ [1] Ingatlan keresés");
		System.out.println("	 	 ╠ [2] Új ingatlan hozzáadása");
		System.out.println("	 	 ╚ [3] Vissza a főmenübe");

	}

}
