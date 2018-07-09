package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import JDBC.JDBCUser;
import User.Sha256;
import User.User;
import User.UserStatus;

public class Login {
	/**
	 * 
	 * @param scanner
	 * @throws SQLException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public void login(Scanner scanner) throws SQLException, MalformedURLException, IOException {
		User user = new User();
		boolean valid = false;
		int userID = 0;
		String userPassword = "";
		String userStatus;
		JDBCUser jdbcUser = new JDBCUser();
		do {
			userID = idValidator(scanner, valid, userID);
			System.out.print("	    		  	    	   ╚ Jelszó    : ");
			String password = scanner.nextLine();
			userPassword = new Sha256().getSha256(password);
			userStatus = jdbcUser.getStatus(userID);
			if (userPassword.equals(jdbcUser.getPassword(userID)) && UserStatus.ACTIVE.toString().equals(userStatus)) {
				user.setUserId(userID);
				System.out.println();
				System.out.println("				 	 Sikeresen bejelentkezett!");
				System.out.println();
				new MainMenu().mainMenu(user, scanner);
			} else if (!UserStatus.ACTIVE.toString().equals(userStatus)) {
				valid = false;
				System.out.println();
				System.err.println("                  A felhasználó belépése elutasítva!");
				System.out.println();
			} else {
				valid = false;
				System.out.println();
				System.err.println("					Rossz felhasználónév vagy jelszó!");
				System.out.println();
			}

		} while (!userPassword.equals(jdbcUser.getPassword(userID)));
	}

	private int idValidator(Scanner scanner, boolean isValid, int userID) {
		do {
			try {
				System.out.print("	 	    		    	   ╔ Azonosító : ");
				userID = scanner.nextInt();
				scanner.nextLine();
				isValid = true;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("A megadott azonosító hibás.");
			}
		} while (!isValid);
		return userID;
	}
}
