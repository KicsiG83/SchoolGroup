package Menu;

import java.sql.SQLException;
import java.util.Scanner;
import Client.Client;
import JDBC.JDBCClient;
import User.User;

public class SecondMenu {

	public void secondMenu(User user, Scanner scanner, int subManuChoice) throws SQLException {
		UserInterface ui = new UserInterface();
		MainMenu mm = new MainMenu();
		Client client = new Client();
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Ügyfél keresés");
			mm.mainMenu(user, scanner);
			break;
		case 2:
			System.out.println("	[2] Új ügyfél hozzáadása");
			client.setName(ui.askString("Kérem adja meg az ügyfél nevét: "));
			client.setEmail(scanner);
			client.setPhoneNumber(ui.askString("Kérem adja meg az ügyfél telefonszámát: +"));
			client.setComment(ui.askString("Kérem adja meg az ügyfél kommentjét: "));
			client.setClientType(scanner);
			new JDBCClient().uploadClient(client);
			JDBCClient.listNewClient();
			mm.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			mm.mainMenu(user, scanner);
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
