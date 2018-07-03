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
			client.setEmail(ui.getEmailAddress("Kérem adja meg az ügyfél e-mail címét: "));
			client.setPhoneNumber(ui.getPhoneNumber("Kérem adja meg az ügyfél telefonszámát: +36"));
			client.setComment(ui.askString("Kérem adja meg az ügyfél kommentjét: "));
			client.setClientTypeByUser(scanner);
			new JDBCClient().uploadClient(client);
<<<<<<< Updated upstream
			new JDBCClient().listNewClient();
=======
//			JDBCClient.listNewClient();
>>>>>>> Stashed changes
			mm.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			mm.mainMenu(user, scanner);
			break;
		}
	}

	public void printSecondMenu() {
		System.out.println("				   	 ║");
		System.out.println("				 	 ╠ [1] Ügyfél keresés");
		System.out.println("				 	 ╠ [2] Új ügyfél hozzáadása");
		System.out.println("	 				 ╚ [3] Vissza a főmenübe");
		System.out.print(
				"	                                                                                              "
						+ "	 => a választott almenü: ");
	}

}
