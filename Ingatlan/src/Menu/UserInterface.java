package Menu;

import java.util.Scanner;

public class UserInterface {
	
	private Scanner sc = new Scanner(System.in);
	
	public String askString(String message) {
		System.out.print(message);
		String userInput = sc.nextLine();
		return userInput;
	}
	
}
