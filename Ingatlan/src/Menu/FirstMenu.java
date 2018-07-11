package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLogicLayer.PropertyTools;
import BusinessLogicLayer.Validator;
import Property.AdvertisingStatus;
import Property.City;
import Property.EnergeticLevel;
import Property.Material;
import Property.Property;
import Property.PropertyCondition;
import Property.PropertyType;
import Property.Toilet;
import User.User;

public class FirstMenu {

	public void firstMenu(User user, Scanner scanner, int subManuChoice) throws SQLException, MalformedURLException, IOException {
		UserInterface ui = new UserInterface();
		MainMenu mm = new MainMenu();
		PropertyTools propertyTools = new PropertyTools();
		switch (subManuChoice) {
		case 1:
			System.out.println("		[1] Ingatlanok kezelése");
			propertyEditing(ui,propertyTools);
			mm.mainMenu(user, scanner);

			break;
		case 2:
			System.out.println("		[2] Új ingatlan hozzáadása\n");
			Property prop = new Property();
			prop.setClientID(ui.askNumber("Add meg az ügyfél azonosítóját: "));
			prop.setUserID(ui.askNumber("Add meg a saját felhasználói azonosítódat: "));
			PropertyType pt = ui.askPropertyType();
			while(pt == null) {
				System.err.println("Kötelező választani.");
				pt = ui.askPropertyType();
			}
			prop.setPropertyType(pt);
			prop.setSize(ui.askNumber("Add meg az ingatlan területét négyzetméterben: "));
			if(prop.getPropertyType() == PropertyType.HOUSE || prop.getPropertyType() == PropertyType.OFFICE) {
				prop.setGroundSize(ui.askNumber("Add meg az udvar méretét négyzetméterben: "));
			}
			prop.setNumberOfRooms(ui.askNumber("Add meg a szobák számát: "));
			prop.setNumberOfHalfRooms(ui.askNumber("Add meg a félszobák számát: "));
			prop.setPrice(ui.askPrice());
			prop.setStreetAndNumber(ui.askString("Add meg a címet:"));
			City city = ui.askCity();
			while(city == null) {
				System.err.println("Kötelező választani.");
				city = ui.askCity();
			}
			prop.setCity(city);
			Material mat = ui.askMaterial();
			while(mat == null) {
				System.err.println("Kötelező választani.");
				mat = ui.askMaterial();
			}
			prop.setMaterial(mat);
			Toilet wc = ui.askToilet();
			while(wc == null) {
				System.err.println("Kötelező választani.");
				wc = ui.askToilet();
			}
			prop.setWc(wc);
			EnergeticLevel el = ui.askEnergeticLevel();
			while(el == null) {
				System.err.println("Kötelező választani.");
				el = ui.askEnergeticLevel();
			}
			prop.setLevel(el);
			PropertyCondition cond = ui.askCondition();
			while(cond == null) {
				System.err.println("Kötelező választani.");
				cond = ui.askCondition();
			}
			prop.setCondition(cond);
			prop.setDescription(ui.askString("Add meg az ingatlan leírását: "));
			AdvertisingStatus status = ui.askAdvertisingType();
			while(status == null) {
				System.err.println("Kötelező választani.");
				status = ui.askAdvertisingType();
			}
			prop.setStatus(status);
			prop.setCountNUmber(0);
			propertyTools.addPropertyToDB(prop);
			
			mm.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			mm.mainMenu(user, scanner);
			break;
		}
	}

	private void propertyEditing(UserInterface ui, PropertyTools propertyTools) throws SQLException, MalformedURLException, IOException {
		System.out.println("	   	 	   	 ║");
		System.out.println("	   	 	   	 ╠ {1} Ingatlanok listázása keresési feltételekkel");
		System.out.println("	   	 	   	 ╠ {2} Ingatlan keresés azonosító alapján");
		System.out.println("	   	 	   	 ╠ {3} Ingatlan adatainak megváltoztatása");
		System.out.println("	   	 	   	 ╚ {4} Visszalépés");
		System.out.print(
				"	                                                                                              "
						+ "	 => a választott almenü: ");
		
		String choice = ui.askString("");
		while(!new Validator().isValidMenuChoice(choice,4)) {
			System.err.println("\n					!!!Nincs ilyen menüpont!!!");
			System.out.print("=> a választott menü: ");
			 choice =  ui.askString("");
		}
		int menuChoice = Integer.parseInt(choice);
		switch(menuChoice) {
		case 1:
			System.out.println("Keresési feltételek megadása: ");
			System.out.println("Ha nem ad meg értéket, akkor azt a feltételt kihagyja.\n");
			String searchClientID = ui.askString("Adjon meg egy ügyfél azonosítót: ");
			String searchUserID = ui.askString("Adjon meg egy felhasználó azonosítót: ");
			PropertyType pt = ui.askPropertyType();
			String searchPropertyType = pt == null ? "" : pt.getTextual();
			String searchSizeMin = Integer.toString(ui.askLimitOfValue("területének", "minimumát négyzetméterben"));
			String searchSizeMax = Integer.toString(ui.askLimitOfValue("területének", "maximumát négyzetméterben"));
			String searchRoomNumberMin = Integer.toString(ui.askLimitOfValue("legalább", "hány szobával rendelkezzen"));
			String searchPriceMin = Integer.toString(ui.askLimitOfValue("árának","minimumát forintban"));
			String searchPriceMax = Integer.toString(ui.askLimitOfValue("árának","maximumát forintban"));
			City city = ui.askCity();
			String searchCity = city == null ? "" : city.getTextual();
			Material mat = ui.askMaterial();
			String searchMaterial = mat == null ? "" : mat.getTextual();
			Toilet wc = ui.askToilet();
			String searchToilet = wc == null ? "" : wc.getTextual();
			EnergeticLevel el = ui.askEnergeticLevel();
			String searchLevel = el == null ? "" : el.getTextual();
			PropertyCondition cond = ui.askCondition();
			String searchCondition = cond == null ? "" : cond.getTextual();
			String searchDescription = ui.askString("Milyen szöveg szerepeljen az ingatlan leírásában: ");
			AdvertisingStatus status = ui.askAdvertisingType();
			String searchStatus = status == null ? "" : status.getTextual();
			ArrayList<Property> searchResult = propertyTools.search(searchClientID,searchUserID,searchPropertyType,searchSizeMin,
					searchSizeMax,searchRoomNumberMin,searchPriceMin,searchPriceMax,searchCity,
					searchMaterial,searchToilet,searchLevel,searchCondition,searchDescription,searchStatus);
			int n = searchResult.size();
			if(n == 0) {
				System.out.println("Nincs megjeleníthető ingatlan");
			} else {
				for(int i=0;i<n;i++) {
					System.out.println(searchResult.get(i).toString());
				}
				System.out.println();
			}
			break;
		case 2:
			int propID = ui.askNumber("Adja meg az érdekelt ingatlan azonosítóját: ");
			Property result = propertyTools.getPropertyWithPropertyID(propID);
			if(result.equals(null)) {
				System.out.println("Nincs ilyen ingatlan.");
			} else {
				propertyTools.increaseViews(propID);
				System.out.println(result.toString());
			}
			break;
		case 3:
			int updatePropID = ui.askNumber("Adja meg a frissíteni kívánt ingatlan azonosítóját: ");
			Property updateResult = propertyTools.getPropertyWithPropertyID(updatePropID);
			if(updateResult.equals(null)) {
				System.out.println("Nincs ilyen ingatlan.");
				break;
			} else {
				System.out.println("Adatok cserélése: ");
				System.out.println("Ha nem ad meg értéket, az adat nem frissül.\n");
				
				String updateClientID = ui.askString("Új ügyfél azonosítót: ");
				String updateUserID = ui.askString("Új felhasználó azonosítót: ");
				System.out.println("Új ingatlan típus: ");
				pt = ui.askPropertyType();
				String updatePropertyType = pt == null ? "" : pt.getTextual();
				String updateSize = ui.askString("Új terület: ");
				String updateGroundSize = ui.askString("Új udvar terület: ");
				String updateRoomNumber = ui.askString("Új 'szobaszám': ");
				String updateHalfRoomNumber = ui.askString("Új 'félszobaszám': ");
				System.out.println("Új ár:");
				int price = ui.askPrice();
				String updatePrice = price == 0 ? "" : Integer.toString(price);
				String updateStreetAndNumber = ui.askString("Új cím: ");
				System.out.println("Új település:");
				city = ui.askCity();
				String updateCity = city == null ? "" : city.getTextual();
				System.out.println("Új építési anyag: ");
				mat = ui.askMaterial();
				String updateMaterial = mat == null ? "" : mat.getTextual();
				System.out.println("Új 'WC elhelyezkedés': ");
				wc = ui.askToilet();
				String updateToilet = wc == null ? "" : wc.getTextual();
				System.out.println("Új energetikai besorolás: ");
				el = ui.askEnergeticLevel();
				String updateLevel = el == null ? "" : el.getTextual();
				System.out.println("Új 'ingatlan állapot': ");
				cond = ui.askCondition();
				String updateCondition = cond == null ? "" : cond.getTextual();
				String updateDescription = ui.askString("Új leírás: ");
				System.out.println("Új hirdetési állapot: ");
				status = ui.askAdvertisingType();
				String updateStatus = status == null ? "" : status.getTextual();
				propertyTools.update(updatePropID,updateClientID,updateUserID,
						updatePropertyType,updateSize,updateGroundSize,updateRoomNumber,updateHalfRoomNumber,
						updatePrice,updateStreetAndNumber,updateCity,updateMaterial,
						updateToilet,updateLevel,updateCondition,updateDescription,updateStatus);
				updateResult = propertyTools.getPropertyWithPropertyID(updatePropID);
				System.out.println("A módosított ingatlan: ");
				System.out.println(updateResult.toString());
				break;
			}
		case 4:
			System.out.println();
			break;
		}
		
	}

	public void printFirstMenu() {
		System.out.println("	   	 ║");
		System.out.println("	 	 ╠ [1] Ingatlan kezelés");
		System.out.println("	 	 ╠ [2] Új ingatlan hozzáadása");
		System.out.println("	 	 ╚ [3] Vissza a főmenübe");

	}

}
