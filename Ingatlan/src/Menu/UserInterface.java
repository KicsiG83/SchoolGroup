package Menu;

import java.util.Scanner;

import BusinessLogicLayer.Validator;

public class UserInterface {

	private Scanner sc = new Scanner(System.in);

	public String askString(String message) {
		System.out.print(message);
		String userInput = sc.nextLine();
		return userInput;
	}

	public String getEmailAddress(String message) {
		boolean isValid = false;
		String userInput;
		do {
			System.out.print(message);
			userInput = sc.nextLine();
			boolean isValidPassword = new Validator().isValidEmailAddress(userInput);
			if (isValidPassword) {
				isValid = true;
			} else {
				System.out.println("A megadott adat érvénytelen.");
			}
		} while (!isValid);
		return userInput;
	}

	public String getPhoneNumber (String message) {
		boolean isValid = false;
		String userInput;
		do {
			System.out.print(message);
			userInput = sc.nextLine();
			boolean isValidPhoneNumber = new Validator().checkPhoneNumber(userInput);
			if (isValidPhoneNumber) {
				isValid = true;
			} else {
				System.out.println("A megadott adat érvénytelen.");
			}
		} while (!isValid);
		return userInput;
	}
	
}
