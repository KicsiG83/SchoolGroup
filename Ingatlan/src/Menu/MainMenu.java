package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import User.User;
import BusinessLogicLayer.Validator;

public class MainMenu {

	public void menu() throws SQLException {
		new MainMenu().printMenuHeader();
	}

	private void printMenuHeader() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"	**********************************************************************************************");
		System.out.println(
				"	******                     Üdvözlöm az A&K ingatlaniroda felületén!                     ******");
		System.out.println(
				"	**********************************************************************************************");
		System.out.println("");
		System.out.println("					B E J E L E N T K E Z É S");
		System.out.println();
		new Login().login(scanner);
	}

	public void mainMenu(User user, Scanner scanner) throws SQLException {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice="";
		System.out.print(
				"	1.INGATLAN ADATBÁZIS   2.ÜGYFÉL ADATBÁZIS  3.STATISZTIKÁK   4.FELHASZNÁLÓ KEZELÉS    5.KILÉPÉS"
						+ "	 => a választott főmenü: ");
		String mainMenuChoice = ui.askString("");
		while (!valid.isValidMenuChoice(mainMenuChoice, 5)) {
			mainMenuChoice = ui.askString(
					"	1.INGATLAN ADATBÁZIS   2.ÜGYFÉL ADATBÁZIS  3.STATISZTIKÁK   4.FELHASZNÁLÓ KEZELÉS    5.KILÉPÉS"
							+ "	 => a választott főmenü: ");
		}
		int menuIndex = Integer.parseInt(mainMenuChoice);
		int subMenuIndex=0;
		switch (menuIndex) {
		case 1:
			FirstMenu.printFirstMenu();			
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Ingatlan adatbázis' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuChoice, 3));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			FirstMenu.firstMenu(user, scanner, subMenuIndex);
			break;
		case 2:
			new SecondMenu().printSecondMenu();
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Ügyfél adatbázis' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuIndex, 3));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			new SecondMenu().secondMenu(user, scanner, subMenuIndex);
			break;
		case 3:
			new ThirdMenu().printThirdMenu();
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Statisztikák' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuIndex, 3));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			new ThirdMenu().thirdMenu(user, scanner, subMenuIndex);
			break;
		case 4:
			FourthMenu.printFourthMenu();
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Felhasználó kezelés' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuIndex, 4));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			new FourthMenu().fourthMenu(user, scanner, subMenuIndex);
			break;

		case 5:
			ExitMenu.printExitMenu();
			break;
		}
	}
}
