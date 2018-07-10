package Menu;

import BusinessLogicLayer.Validator;

public class SecondMenuSubMenus {

	public void firstSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Ügyfél keresés' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 3));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} Név alapján");
			break;
		case 2:
			System.out.println("	{2} ID alapján");
			break;
		}
	}
	
	public void secondSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Új Ügyfél hozzáadása' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 2));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} Mentés");
			break;
		case 2:
			System.out.println("	{2} Elvetés");
			break;
		}
	}
}
