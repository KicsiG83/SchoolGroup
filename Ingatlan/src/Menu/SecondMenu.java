package Menu;

import java.sql.SQLException;
import java.util.Scanner;
import Client.Client;
import JDBC.JDBCClient;
import User.User;

public class SecondMenu {

	public static void secondMenu(User user, Scanner scanner, int subManuChoice) throws SQLException {
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Ügyfél keresés");
			MainMenu.mainMenu(user, scanner);
			break;
		case 2:
			System.out.println("	[2] Új ügyfél hozzáadása");
			Client client = new Client(scanner);
			JDBCClient.uploadClient(client.getName(), client.getEmail(), client.getPhoneNumber(),
					client.getClientType().toString(), client.getComment());
			JDBCClient.listNewClient();
			MainMenu.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			MainMenu.mainMenu(user, scanner);
			break;
		}
	}

	public static void printSecondMenu() {
		System.out.println("				   	 ║");
		System.out.println("				 	 ╠ [1] Ügyfél keresés");
		System.out.println("				 	 ╠ [2] Új ügyfél hozzáadása");
		System.out.println("	 				 ╚ [3] Vissza a főmenübe");
		System.out.print(
				"	                                                                                              "
						+ "	 => a választott almenü: ");
	}

}
