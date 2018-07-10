package Menu;

import BusinessLogicLayer.Validator;

public class ThirdMenuSubMenus {   // CSAK ELŐRE MEGÍRTAM, HA NETALÁN SZÜKSÉGÜNK LESZ RÁ, EGYELŐRE NINCS FELHASZNÁLVA
	
	public void firstSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Eladási statisztikák' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 3));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} ????");
			break;
		case 2:
			System.out.println("	{2} ?????");
			break;
		}
	}
	
	public void secondSubMeu() {
		UserInterface ui = new UserInterface();
		Validator valid = new Validator();
		String subMenuChoice ="";
		 do {
			subMenuChoice = ui.askString(
					"													 => a választott 'Keresési statisztikák' almenü: ");
		} while (!valid.isValidMenuChoice(subMenuChoice, 2));
		switch (Integer.parseInt(subMenuChoice)) {
		case 1:
			System.out.println("	{1} ????");
			break;
		case 2:
			System.out.println("	{2} ????");
			break;
		}
	}

}
