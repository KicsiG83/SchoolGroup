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
		int subMenuChoice = 0;
		System.out.print(
				"	1.INGATLAN ADATBÁZIS   2.ÜGYFÉL ADATBÁZIS  3.STATISZTIKÁK   4.FELHASZNÁLÓ KEZELÉS    5.KILÉPÉS"
						+ "	 => a választott főmenü: ");
		String mainMenuChoice = ui.askString("");
		while(!valid.isValidMenuChoice(mainMenuChoice)) {
			mainMenuChoice = ui.askString("");
		}
		int menuIndex = Integer.parseInt(mainMenuChoice);
		switch (menuIndex) {
		case 1:
			FirstMenu.printFirstMenu();
			subMenuChoice = scanner.nextInt();
			scanner.nextLine();
			FirstMenu.firstMenu(user, scanner, subMenuChoice);
			break;
		case 2:
			SecondMenu.printSecondMenu();
			subMenuChoice = scanner.nextInt();
			scanner.nextLine();
			new SecondMenu().secondMenu(user, scanner, subMenuChoice);
			break;
		case 3:
			ThirdMenu.printThirdMenu();
			subMenuChoice = scanner.nextInt();
			scanner.nextLine();
			ThirdMenu.thirdMenu(user, scanner, subMenuChoice);
			break;
		case 4:
			FourthMenu.printFourthMenu();
			subMenuChoice = scanner.nextInt();
			scanner.nextLine();
			FourthMenu.fourthMenu(user, scanner, subMenuChoice);
			break;

		case 5:
			ExitMenu.printExitMenu();
			break;
		default:
			System.err.println("\n					!!!Nincs ilyen menüpont!!!");
			break;
		}
	}
}
