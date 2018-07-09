package Menu;

import BusinessLogicLayer.Validator;

public class FirstMenuSubMenus {

	public void firstSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Ingatlan keresés' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 2));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} Ingatlan keresés ID alapján");
			break;
		case 2:
			System.out.println("	{2} Ingatlan keresés paraméter alapján");
			break;
		}
	}
	
	public void secondSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Új ingatlan hozzáadása' almenü: ");
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
