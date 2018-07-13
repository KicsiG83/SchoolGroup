package User;

import java.util.Scanner;
import BusinessLogicLayer.Validator;
public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	UserStatus status;

	public User() {
	}

	public User(Scanner sc) {
		setName(sc);
		setPassword(sc);
		setEmail(sc);
		setStatus(sc);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(Scanner sc) {
		System.out.print("Kérem adja meg a felhasználó nevét: ");
		this.name = sc.nextLine();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(Scanner sc) {
		boolean isValid = false;
		String userEmail = "";
		do {
			System.out.print("Kérem adja meg a felhasználó e-mail címét: ");
			userEmail = sc.nextLine();
			isValid = new Validator().isValidEmailAddress(userEmail);
			if (!isValid) {
				System.out.println("A megadott e-mail cím nem helyes.");
			}
		} while (!isValid);
		this.email = userEmail;
	}

	public void setPassword(Scanner sc) {
		boolean isValid = false;
		do {
			System.out.print("Kérem adja meg a felhasználó jelszavát: ");
			String userPassword = sc.nextLine();
			boolean isValidPassword = new Validator().checkPasswordStrength(userPassword);
			if (isValidPassword) {
				this.password = new Sha256().getSha256(userPassword);
				isValid = true;
			} else {
				System.out.println(
						"A megadott jelszó nem elég erős.\n(A jelszó legyen legalább 8 karakter hosszú, tartalmazzon legalább 1 kis és nagybetűt valamint legalább 1 számot.)");
			}
		} while (!isValid);
	}

	public String getPassword() {
		return password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(Scanner sc) {
		boolean isValid = false;
		String userInput = "";
		do {
			System.out.print("Kérem adja meg a felhasználó státuszát (Aktív, Blokkolt, Törölt): ");
			userInput = sc.nextLine();
			if (!userInput.equals("Aktív") && !userInput.equals("Blokkolt") && !userInput.equals("Törölt")) {
				System.out.println("A megadott adat érvénytelen.\nA választható státuszok:\n- Aktív\n- Blokkolt\n- Törölt");
				isValid = false;
			} else {
				isValid = true;
			}
		} while (!isValid);
		if (userInput.equals("Aktív")) {
			this.status = UserStatus.ACTIVE;
		} else if (userInput.equals("Blokkolt")) {
			this.status = UserStatus.BLOCKED;
		} else {
			this.status = UserStatus.DELETED;
		}
	}

	@Override
	public String toString() {
		return userId + ", " + name + ", " + password + ", " + email + ", " + status.en;
	}

	public static int getUserById(Scanner sc) {
		int id = 0;
		boolean isValid = false;
		do {
			try {
				System.out.print("Kérem adja meg a módisítandó felhasználó azonosítóját: ");
				id = sc.nextInt();
				sc.nextLine();
				isValid = true;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("A megadott input érvénytelen.");
			}
		} while (!isValid);
		return id;
	}

}
