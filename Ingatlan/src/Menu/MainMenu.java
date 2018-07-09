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
			SecondMenu secondMenu = new SecondMenu();
			secondMenu.printSecondMenu();
			String subMenuIndex2 = ui.askString("");
			while(!valid.isValidMenuChoice(subMenuIndex2,3)) {
				System.err.println("\n					!!!Nincs ilyen menüpont!!!");
				System.out.print("=> a választott menü: ");
				subMenuIndex2 = ui.askString("");
			}
			subMenuChoice = Integer.parseInt(subMenuIndex2);
			secondMenu.secondMenu(user, scanner, subMenuChoice);
			break;
		case 3:
			ThirdMenu thirdMenu = new ThirdMenu();
			thirdMenu.printThirdMenu();			
			String subMenuIndex3 = ui.askString("");
			while(!valid.isValidMenuChoice(subMenuIndex3,3)) {
				System.err.println("\n					!!!Nincs ilyen menüpont!!!");
				System.out.print("=> a választott menü: ");
				subMenuIndex3 = ui.askString("");
			}
			subMenuChoice = Integer.parseInt(subMenuIndex3);
			thirdMenu.thirdMenu(user, scanner, subMenuChoice);
			break;
		case 4:
			FourthMenu fourthMenu = new FourthMenu();
			fourthMenu.printFourthMenu();
			String subMenuIndex4 = ui.askString("");
			while(!valid.isValidMenuChoice(subMenuIndex4,4)) {
				System.err.println("\n					!!!Nincs ilyen menüpont!!!");
				System.out.print("=> a választott menü: ");
				subMenuIndex4 = ui.askString("");
			}
			subMenuChoice = Integer.parseInt(subMenuIndex4);			
			fourthMenu.fourthMenu(user, scanner, subMenuChoice);
			break;

		case 5:
			ExitMenu.printExitMenu();
			break;
		}
	}
}
