package Menu;

import BusinessLogicLayer.Validator;

public class SecondMenuSubMenus {

	public int firstSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Ügyfél kezelés' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 5));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} Keresés ID alapján");
			return 1;
		case 2:
			System.out.println("	{2} Keresés név alapján");
			return 2;
		case 3:
			System.out.println("	{3} Ügyfelek listázása");
			return 3;
		case 4:
			System.out.println("	{4} Adatok módosítása ID alapján");
			return 4;
		case 5:
			System.out.println("	{5} Vissza a főmenübe");
			return 4;
		default:
			return 5;
			
		}
	}
	
	public int secondSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Új Ügyfél hozzáadása' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 2));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} Hozzáadás");
			return 1;
		case 2:
			System.out.println("	{2} Vissza a főmenübe");
			return 2;
		default: return 0; 
		}
	}
}
