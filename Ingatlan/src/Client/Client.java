package Client;

import java.util.Scanner;

public class Client {
	private int clientID;
	private String name;
	private String email;
	private String phoneNumber;
	private ClientType clientType;
	private String comment;
	private boolean hasPreferences;


	public Client() {
		super();
	}

	public Client(int id, String name, String email, String phoneNumber, ClientType clientType, String comment, boolean hasPreferences) {
		this.clientID = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.clientType = clientType;
		this.comment = comment;
		this.hasPreferences = hasPreferences;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
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
	
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
	
	public boolean isHasPreferences() {
		return hasPreferences;
	}

	public void setHasPreferences(boolean hasPreferences) {
		this.hasPreferences = hasPreferences;
	}

	public void setClientTypeByUser(Scanner sc) {
		
		//innentől
		boolean isValid = false;
		int type = 0;
		System.out.println("\nÜgyfél típusok\n1 - Vevő\n2 - Eladó");
		do {
			try {
				System.out.print("Kérem adja meg az ügyfél típusát: ");
				type = sc.nextInt();
				sc.nextLine();
				/*
				 * isValidClientType metódus legyen a validator classban.
				 * bemenete int, kimenete boolean.
				 */
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
		//eddig
		/*
		 * A userinterface-ben legyen int kimenetelű metódus
		 * legyen askClientType (mondjuk)
		 */
		if (type == 1) {
			clientType = ClientType.BUYER;
		} else {
			clientType = ClientType.SELLER;
		}
	}

	@Override
	public String toString() {
		String prefs = isHasPreferences() == true ? "Vannak" : "Nincsenek";
		return "Ügyfél ID=" + clientID + ", Név=" + name + ", email=" + email + ", telefon=" + phoneNumber
				+ ", típusa=" + clientType.getTextual() + ", megjegyzés=[" + comment + "], Preferenciák: "
				+ prefs;
	}

}