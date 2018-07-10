package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import BusinessLogicLayer.Validator;
import Property.AdvertisingStatus;
import Property.City;
import Property.EnergeticLevel;
import Property.Material;
import Property.PropertyCondition;
import Property.PropertyType;
import Property.Toilet;
import Price.*;

public class UserInterface {

	private Scanner sc = new Scanner(System.in);

	public String askString(String message) {
		System.out.print(message);
		String userInput = sc.nextLine();
		return userInput;
	}
	public int askNumber(String message) {
		System.out.print(message);
		String userInput = sc.nextLine();
		boolean isValid = false;
		int result = 0;
		while(!isValid) {
			try {
				result = Integer.parseInt(userInput);
				isValid = true;
			}catch(Exception e) {
				System.out.println("Nem megfelelő adat!");
				System.out.print("Adja meg újra: ");
				userInput = sc.nextLine();
			}
		}
		return result;
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
				System.out.println("\nÉrvénytelen adat.\nÉrvényes körzetszámok: 20/30/31/70 ezután 7 számjegy.\n");
			}
		} while (!isValid);
		return userInput;
	}

	public PropertyType askPropertyType() {
		System.out.println("Kérem, válasszon egy ingatlan típust.");
		for(PropertyType item : PropertyType.values()) {
			System.out.println((item.ordinal() + 1) + " - " + item.getTextual());
		}
		System.out.print("Választott ingatlan típus: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, PropertyType.values().length)) {
			System.out.println("Adja meg újra!");
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
		if(value.equals("")) {
			return 0;
		}
		while(!new Validator().isValidLimitValue(value)) {
			System.out.println("Nem megfelelő érték, adja meg újra!");
			System.out.print("Érték: ");
			value = sc.nextLine();
		}
		return Integer.parseInt(value);
	}

	public AdvertisingStatus askAdvertisingType() {
		System.out.println("Kérem, válasszon egy hirdetés-típust!");
		for(AdvertisingStatus item : AdvertisingStatus.values()) {
			System.out.println((item.ordinal() + 1) + " - " + item.getTextual());
		}
		System.out.print("Választott hirdetés-típus: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, AdvertisingStatus.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott hirdetés-típus: ");
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
		System.out.println("Kérem, válasszon települést!");
		for(int i=0; i<City.values().length;i++) {
			System.out.println((i+1)+" - " + City.values()[i].getTextual());
		}
		System.out.print("Választott település: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, City.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott település: ");
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
	public int askPrice() throws MalformedURLException, IOException {
		System.out.println("Kérem, válasszon pénznemet!");
		for(int i=0; i<Currency.values().length;i++) {
			System.out.println((i+1)+" - " + Currency.values()[i].getTextual());
		}
		System.out.print("Választott pénznem: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return 0;
		}
		while(!new Validator().isValidMenuChoice(userChoice, Currency.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott pénznem: ");
			userChoice  = sc.nextLine();
		}
		Currency cur = null;
		switch(userChoice) {
		case "1":
			cur = Currency.HUF;
		case "2":
			cur = Currency.EU;
		}
		int value = askNumber("Adja meg az ingatlan értékét " + cur.getTextual()+ "-ban : ");
		if(cur == Currency.EU) {
			double oneEur = new CurrencyDownload().valueOfOneEURinHUF();
			return (int) (value * oneEur);
		} else {
			return value;
		}
	}
	public Material askMaterial() {
		System.out.println("Kérem, válassza ki az ingatlan építési anyagát!");
		for(int i=0; i<Material.values().length;i++) {
			System.out.println((i+1)+" - " + Material.values()[i].getTextual());
		}
		System.out.print("Választott anyag: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, Material.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott anyag: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return Material.values()[0];
			case 2: return Material.values()[1];
			case 3: return Material.values()[2];
			case 4: return Material.values()[3];
			case 5: return Material.values()[4];
			
			default: return null;
		}
	}
	public Toilet askToilet() {
		System.out.println("Kérem, adja meg a wc elhelyezkedésének típusát!");
		for(int i=0; i<Toilet.values().length;i++) {
			System.out.println((i+1)+" - " + Toilet.values()[i].getTextual());
		}
		System.out.print("Választott típus: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, Toilet.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott típus: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return Toilet.values()[0];
			case 2: return Toilet.values()[1];

			default: return null;
		}
	}
	public EnergeticLevel askEnergeticLevel() {
		System.out.println("Kérem, válassza ki az ingatlan energetikai besorolását!");
		for(int i=0; i<EnergeticLevel.values().length;i++) {
			System.out.println((i+1)+" - " + EnergeticLevel.values()[i].getTextual());
		}
		System.out.print("Választott szint: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, EnergeticLevel.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott szint: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return EnergeticLevel.values()[0];
			case 2: return EnergeticLevel.values()[1];
			case 3: return EnergeticLevel.values()[2];
			case 4: return EnergeticLevel.values()[3];
			
			default: return null;
		}
	}
	public PropertyCondition askCondition() {
		System.out.println("Kérem, adja meg az ingatlan állapotát!");
		for(int i=0; i<PropertyCondition.values().length;i++) {
			System.out.println((i+1)+" - " + PropertyCondition.values()[i].getTextual());
		}
		System.out.print("Választott állapot: ");
		String userChoice  = sc.nextLine();
		if(userChoice.equals("")) {
			return null;
		}
		while(!new Validator().isValidMenuChoice(userChoice, PropertyCondition.values().length)) {
			System.out.println("Adja meg újra!");
			System.out.print("Választott állapot: ");
			userChoice  = sc.nextLine();
		}
		int optionNumber = Integer.parseInt(userChoice);
		switch(optionNumber) {
			case 1: return PropertyCondition.values()[0];
			case 2: return PropertyCondition.values()[1];
			case 3: return PropertyCondition.values()[2];
			case 4: return PropertyCondition.values()[3];
			case 5: return PropertyCondition.values()[4];
			case 6: return PropertyCondition.values()[5];
			case 7: return PropertyCondition.values()[6];

			default: return null;
		}
	}
	
}
