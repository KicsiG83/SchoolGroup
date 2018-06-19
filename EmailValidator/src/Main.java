import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		new Main().emailValidation();

	}

	public void emailValidation() {
		boolean isValid = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Kérem adja meg az email címét: ");
			String email = sc.nextLine();
			isValid = Validation.isValidEmailAddress(email);
			if (!isValid) {
				System.out.println("A megadott e-mail cím nem valid.");
			}
		} while (!isValid);
		System.out.println("A megadott e-mail cím valid.");
		sc.close();
	}

}