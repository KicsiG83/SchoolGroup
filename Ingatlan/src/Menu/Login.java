package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import JDBC.JDBCUser;
import User.Sha256;
import User.User;
import User.UserStatus;

public class Login {

	public static void login(Scanner scanner) throws SQLException {
		User user = new User();
		boolean isValid = false;
		int userID = 0;
		String userPassword = "";
		String userStatus;
		do {
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
			System.out.print("	    		  	    	   ╚ Jelszó    : ");
			String password = scanner.nextLine();
			userPassword = new Sha256().getSha256(password);
			userStatus = JDBCUser.getStatus(userID);
			if (userPassword.equals(JDBCUser.getPassword(userID)) && UserStatus.ACTIVE.toString().equals(userStatus)) {
				user.setUserId(userID);
				System.out.println();
				System.out.println("				 	 Sikeresen bejelentkezett!");
				System.out.println();
				MainMenu.mainMenu(user, scanner);
			} else if (!UserStatus.ACTIVE.toString().equals(userStatus)) {
				isValid = false;
				System.out.println();
				System.err.println("                  A felhasználó belépése elutasítva!");
				System.out.println();
			} else {
				isValid = false;
				System.out.println();
				System.err.println("					Rossz felhasználónév vagy jelszó!");
				System.out.println();
			}

		} while (!userPassword.equals(JDBCUser.getPassword(userID)));
	}
}
