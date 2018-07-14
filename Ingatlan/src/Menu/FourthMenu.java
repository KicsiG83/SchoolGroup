package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import JDBC.JDBCUser;
import User.User;

public class FourthMenu {

	public void fourthMenu(User user, Scanner scanner, int subMenuChoice) throws SQLException, MalformedURLException, IOException {
		int currentUserID = user.getUserId();
		switch (subMenuChoice) {
		case 1:
			System.out.println("	[1] Saját jelszó módosítása");
			new JDBCUser().changeUserData(scanner, currentUserID, "PASSWORD");
			subMenuChoice = 0;
			new MainMenu().mainMenu(user, scanner);
			break;
		case 2:
			if(currentUserID != 1) {
				System.err.println("Nincs hozzá jogosultsága!");
				new MainMenu().mainMenu(user, scanner);
				break;
			}
			System.out.println("	[2] Új felhasználó létrehozása (admin)");
			createNewUser(scanner);
			new MainMenu().mainMenu(user, scanner);
			break;
		case 3:
			if(currentUserID != 1) {
				System.err.println("Nincs hozzá jogosultsága!");
				new MainMenu().mainMenu(user, scanner);
				break;
			}
			System.out.println("	[3] Felhasználó adatainak módosítása (admin)");
			int index = 0;
			int function = selectSubMenuFunction(scanner);
			JDBCUser jdbcUser = new JDBCUser();
			if (function == 1) {
				jdbcUser.listUserData(user.getUserId());
				index = chooseUserParameter(scanner);
				jdbcUser.changeUserData(scanner, user.getUserId(), getColumn(index));
			} else {
				jdbcUser.listOtherUserData(user.getUserId());
				User modifiedUser = new User();
				int id = User.getUserById(scanner);
				if(jdbcUser.checkUserById(id)) {
					modifiedUser.setUserId(id);
					index = chooseUserParameter(scanner);
					jdbcUser.changeUserData(scanner, modifiedUser.getUserId(), getColumn(index));
				}
			}
			new MainMenu().mainMenu(user, scanner);
			break;
		case 4:
			System.out.println();
			new MainMenu().mainMenu(user, scanner);
			break;
		}
	}

	public void printFourthMenu() {
		System.out.println("	 							  	 ║");
		System.out.println("								 	 ╠ [1] Saját jelszó módosítása");
		System.out.println("								 	 ╠ [2] Új felhasználó létrehozása");
		System.out
				.println("								 	 ╠ [3] Saját vagy egyéb felhasználó adatainak módosítása");
		System.out.println("	 								 ╚ [4] Vissza a főmenübe");

	}

	private String getColumn(int index) {
		String column = "";
		switch (index) {
		case 1:
			column = "NAME";
			break;
		case 2:
			column = "PASSWORD";
			break;
		case 3:
			column = "EMAIL";
			break;
		case 4:
			column = "STATUS";
			break;
		}
		return column;
	}

	private int selectSubMenuFunction(Scanner scanner) {
		boolean isValid = false;
		int index = 0;
		System.out.println(
				"	Kérem válasszon az alábbi menüből.\n	1 - Saját adatok módosítása\n	2 - Másik felhasználó adatainak módosítása");
		do {
			try {
				System.out.print("	Kérem adja meg a menü sorszámát: ");
				index = scanner.nextInt();
				scanner.nextLine();
				if (index == 1 || index == 2) {
					isValid = true;
				} else {
					System.out.println("	Nincs ilyen menüpont.");
				}
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("	A megadott adat érvénytelen.");
			}
		} while (!isValid);
		return index;
	}

	private void createNewUser(Scanner scanner) throws SQLException {
User newUser = new User(scanner);
		new JDBCUser().uploadUser(newUser.getName(), newUser.getPassword(), newUser.getEmail(),
				newUser.getStatus().toString());
		System.out.print("\n	Az új felhasználó adatai: ");
		new JDBCUser().listNewUserData();
		System.out.println();
	}

	private int chooseUserParameter(Scanner scanner) {
		boolean isValid = false;
		int index = 0;
		System.out.println("\n	Kérem válasszon\n	1 - Felhasználó név\n	2 - Jelszó\n	3 - E-mail cím\n	4 - Státusz\n");
		do {
			try {
				System.out.print("	Kérem válasszon a fenti felsorolásból: ");
				index = scanner.nextInt();
				scanner.nextLine();
				if (index >= 1 && index <= 4) {
					isValid = true;
				} else {
					System.out.println("	Nincs ilyen menüpont.");
				}
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("	A megadott input érvénytelen.");
			}
		} while (!isValid);
		return index;
	}
}
