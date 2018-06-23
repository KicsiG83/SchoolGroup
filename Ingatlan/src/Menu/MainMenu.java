package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import User.User;

public class MainMenu {

	public static void menu() throws SQLException {
		printMenuHeader();
	}

	private static void printMenuHeader() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"	**********************************************************************************************");
		System.out.println(
				"	******                    Üdvözlöm a pinCode ingatlaniroda felületén!                   ******");
		System.out.println(
				"	**********************************************************************************************");
		System.out.println("");
		System.out.println("					B E J E L E N T K E Z É S");
		System.out.println();
		Login.login(scanner);
	}

	public static void mainMenu(User user, Scanner scanner) throws SQLException {
		int mmainMenuChoice = 0;
		int subMenuChoice = 0;
		System.out.print(
				"	1.INGATLAN ADATBÁZIS   2.ÜGYFÉL ADATBÁZIS  3.STATISZTIKÁK   4.FELHASZNÁLÓ KEZELÉS    5.KILÉPÉS"
						+ "	 => a választott főmenü: ");
		mmainMenuChoice = scanner.nextInt();
		scanner.nextLine();
		switch (mmainMenuChoice) {
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
			SecondMenu.secondMenu(user, scanner, subMenuChoice);
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
