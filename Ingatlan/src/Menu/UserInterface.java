package Menu;

import java.util.Scanner;

import BusinessLogicLayer.Validator;
import Property.AdvertisingStatus;
import Property.City;
import Property.PropertyType;

public class UserInterface {

	private Scanner sc = new Scanner(System.in);

	public String askString(String message) {
		System.out.print(message);
		String userInput = sc.nextLine();
		return userInput;
	}
	
	public int askInteger(String message) {
		System.out.print(message);
		int userInput = sc.nextInt();
		sc.nextLine();
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

	public PropertyType askPropertyType() {
		System.out.println("Kérlek, válassz egyet ingatlan típust.");
		for(PropertyType item : PropertyType.values()) {
			System.out.println((item.ordinal() + 1) + " - " + item.getTextual());
		}
		System.out.print("Választott ingatlan típus: ");
		String userChoice  = sc.nextLine();
		while(!new Validator().isValidMenuChoice(userChoice, PropertyType.values().length)) {
			System.out.println("Add meg újra!");
			System.out.print("Választott ingatlan típus: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return PropertyType.values()[0];
			case 2: return PropertyType.values()[1];
			case 3: return PropertyType.values()[2];
			case 4: return PropertyType.values()[3];
			default: return null;
		}
	}

	public int askLimitOfValue(String s1, String s2) {
		System.out.println("Kérem, adja meg a preferált ingatlan " + s1 + " " + s2 + "!");
		System.out.print("Érték: ");
		String value = sc.nextLine();
		while(!new Validator().isValidLimitValue(value)) {
			System.out.println("Nem megfelelő érték, adja meg újra!");
			System.out.print("Érték: ");
			value = sc.nextLine();
		}
		return Integer.parseInt(value);
	}

	public AdvertisingStatus askAdvertisingType() {
		System.out.println("Kérlek, válassz egyet hirdetési típust!");
		for(AdvertisingStatus item : AdvertisingStatus.values()) {
			System.out.println((item.ordinal() + 1) + " - " + item.getTextual());
		}
		System.out.print("Választott hirdetés típus: ");
		String userChoice  = sc.nextLine();
		while(!new Validator().isValidMenuChoice(userChoice, AdvertisingStatus.values().length)) {
			System.out.println("Add meg újra!");
			System.out.print("Választott hirdetés típus: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return AdvertisingStatus.values()[0];
			case 2: return AdvertisingStatus.values()[1];
			case 3: return AdvertisingStatus.values()[2];
			case 4: return AdvertisingStatus.values()[3];
			case 5: return AdvertisingStatus.values()[4];
			default: return null;
		}
	}

	public City askCity() {
		System.out.println("Kérlek, válassz települést!");
		for(int i=0; i<City.values().length - 1;i++) {
			System.out.println((i+1)+" - " + City.values()[i].getTextual());
		}
		System.out.print("Választott település: ");
		String userChoice  = sc.nextLine();
		while(!new Validator().isValidMenuChoice(userChoice, AdvertisingStatus.values().length)) {
			System.out.println("Add meg újra!");
			System.out.print("Választott menü: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return City.values()[0];
			case 2: return City.values()[1];
			case 3: return City.values()[2];
			case 4: return City.values()[3];
			case 5: return City.values()[4];
			
			default: return null;
		}

	}

	public String askKeyWord() {
		System.out.println("Kérem adjon meg egy keresési kulcsszót!");
		System.out.print("Kulcsszó: ");
		String s = sc.nextLine();
		return s;
	}
	
}
