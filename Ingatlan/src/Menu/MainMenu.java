package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import User.User;
import BusinessLogicLayer.Validator;

public class MainMenu {

	public void menu() throws SQLException, MalformedURLException, IOException {
		new MainMenu().printMenuHeader();
	}

	private void printMenuHeader() throws SQLException, MalformedURLException, IOException {
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

	public void mainMenu(User user, Scanner scanner) throws SQLException, MalformedURLException, IOException {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		int subMenuChoice = 0;
		System.out.print(
				"	1.INGATLAN ADATBÁZIS   2.ÜGYFÉL ADATBÁZIS  3.STATISZTIKÁK   4.FELHASZNÁLÓ KEZELÉS    5.KILÉPÉS"
						+ "	 => a választott főmenü: ");
		String mainMenuChoice = ui.askString("");
		while(!valid.isValidMenuChoice(mainMenuChoice,5)) {
			System.err.println("\n					!!!Nincs ilyen menüpont!!!");
			System.out.print("=> a választott főmenü: ");
			mainMenuChoice = ui.askString("");
		}
		int menuIndex = Integer.parseInt(mainMenuChoice);
		switch (menuIndex) {
		case 1:
			FirstMenu firstMenu = new FirstMenu();
			firstMenu.printFirstMenu();
			String subMenuIndex1 = ui.askString("");
			while(!valid.isValidMenuChoice(subMenuIndex1,3)) {
				System.err.println("\n					!!!Nincs ilyen menüpont!!!");
				System.out.print("=> a választott menü: ");
				subMenuIndex1 = ui.askString("");
			}
			subMenuChoice = Integer.parseInt(subMenuIndex1);			
			firstMenu.firstMenu(user, scanner, subMenuChoice);
			break;
		case 2:
			new SecondMenu().printSecondMenu();
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Ügyfél adatbázis' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuChoice, 3));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			new SecondMenu().secondMenu(user, scanner, subMenuIndex);
			break;
		case 3:
			new ThirdMenu().printThirdMenu();
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Statisztikák' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuChoice, 3));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			new ThirdMenu().thirdMenu(user, scanner, subMenuIndex);
			break;
		case 4:
			FourthMenu.printFourthMenu();
			do {
				subMenuChoice = ui.askString(
						"													 => a választott 'Felhasználó kezelés' almenü: ");
			} while (!valid.isValidMenuChoice(subMenuChoice, 4));
			subMenuIndex = Integer.parseInt(subMenuChoice);
			new FourthMenu().fourthMenu(user, scanner, subMenuIndex);
			break;

		case 5:
			ExitMenu.printExitMenu();
			break;
		}
	}
}
