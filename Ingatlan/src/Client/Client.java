package Client;

import java.util.Scanner;

public class Client {
	private static String name;
	private static String email;
	private static String phoneNumber;
	private String comment;
	private static ClientType clientType;

	public Client(Scanner sc) {
		setName(sc);
		setEmail(sc);
		setPhoneNumber(sc);
		setClientType(sc);
		setComment(sc);
	}

	public String getName() {
		return name;
	}

	public static void setName(Scanner sc) {
		System.out.print("Kérem adja meg az ügyfél nevét: ");
		name = sc.nextLine();
	}

	public String getEmail() {
		return email;
	}

	public static void setEmail(Scanner sc) {
		boolean isValid = false;
		String clientEmail = "";
		do {
			System.out.print("Kérem adja meg az ügyfél e-mail címét: ");
			clientEmail = sc.nextLine();
			isValid = Validation.isValidEmailAddress(clientEmail);
			if (!isValid) {
				System.out.println("A megadott e-mail cím nem helyes!");
			}
		} while (!isValid);
		email = clientEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Scanner sc) {
		System.out.print("Kérem adja meg az ügyfél telefonszámát: +");
		phoneNumber = sc.nextLine();
	}

	public ClientType getClienType() {
		return clientType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(Scanner sc) {
		System.out.print("Kérem adja meg az ügyfél kommentjét: ");
		this.comment = sc.nextLine();
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(Scanner sc) {
		boolean isValid = false;
		String type = "";
		System.out.println("\nÜgyfél típusok\n- Vevő\n- Eladó");
		do {
			System.out.print("Kérem adja meg az ügyfél típusát: ");
			type = sc.nextLine().toUpperCase();
			if (!(type.equals("VEVŐ") || type.equals("ELADÓ"))) {
				System.out.println("A megadott adat érvénytelen (vevő vagy eladó).");
			}else {
				isValid = true;
			}
		} while (!isValid);
		if (type.equals("VEVŐ")) {
			clientType = ClientType.BUYER;
		} else {
			clientType = ClientType.SELLER;
		}
	}

}