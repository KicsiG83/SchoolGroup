package Client;

import java.util.Scanner;

public class Client {
	private  String name;
	private String email;
	private  String phoneNumber;
	private String comment;
	private ClientType clientType;


	public Client() {
	}

	public Client(String name, String email, String phoneNumber, String comment, ClientType clientType) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.comment = comment;
		this.clientType = clientType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String clientEmail) {
		this.email = clientEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(Scanner sc) {
		boolean isValid = false;
		int type = 0;
		System.out.println("\nÜgyfél típusok\n1 - Vevő\n2 - Eladó");
		do {
			try {
				System.out.print("Kérem adja meg az ügyfél típusát: ");
				type = sc.nextInt();
				sc.nextLine();
				if (type < 1 || type > 2) {
					System.out.println("A megadott adat érvénytelen.");
				} else {
					isValid = true;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("A megadott adat érvénytelen.");
			}
		} while (!isValid);
		if (type == 1) {
			clientType = ClientType.BUYER;
		} else {
			clientType = ClientType.SELLER;
		}
	}

}