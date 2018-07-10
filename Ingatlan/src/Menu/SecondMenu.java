package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLogicLayer.ClientTools;
import Client.*;
import Property.AdvertisingStatus;
import Property.City;
import Property.PropertyType;
import User.User;

public class SecondMenu {

	public void secondMenu(User user, Scanner scanner, int subManuChoice) throws SQLException, MalformedURLException, IOException {
		UserInterface ui = new UserInterface();
		MainMenu mm = new MainMenu();
		Client client = new Client();
		ClientTools clientTools = new ClientTools();
		SecondMenuSubMenus sm = new SecondMenuSubMenus();
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Ügyfél keresés╗");
			System.out.println("   	                  ║");
			System.out.println(" 	                  ╠ {1} Név alapján");
			System.out.println(" 	                  ╚ {2} ID alapján");
			sm.firstSubMeu();
			ArrayList<Client> list = clientTools.getClientListfromDB();
			int n = list.size();
			for(int i=0;i<n;i++) {
				System.out.println(list.get(i).toString());
			}
			System.out.println();
			mm.mainMenu(user, scanner);
			break;
		case 2:
			System.out.println("	[2] Új Ügyfél hozzáadása╗");
			System.out.println("   	                        ║");
			System.out.println(" 	                        ╠ {1} Mentés");
			System.out.println(" 	                        ╚ {2} Elvetés");
			sm.secondSubMeu();
			client.setName(ui.askString("Kérem adja meg az ügyfél nevét: "));
			client.setEmail(ui.getEmailAddress("Kérem adja meg az ügyfél e-mail címét: "));
			client.setPhoneNumber(ui.getPhoneNumber("Kérem adja meg az ügyfél telefonszámát: +36"));
			client.setComment(ui.askString("Kérem adja meg az ügyfél kommentjét: "));
			client.setClientTypeByUser(scanner);
			if(client.getClientType()== ClientType.BUYER) {
				client.setHasPreferences(true);
			}
			clientTools.addClientToDB(client);
			Client checkerClient = clientTools.getLastClient();
			if(checkerClient.getClientType() == ClientType.BUYER) {
				System.out.println("Ügyfélpreferenciák hozzáadása");
				SearchPreferences prefs = new SearchPreferences();
				prefs.setSearchID(0);
				prefs.setClientID(checkerClient.getClientID());
				PropertyType pt = ui.askPropertyType();
				while(pt == null) {
					System.err.println("Kötelező választani.");
					pt = ui.askPropertyType();
				}
				prefs.setPropertyType(pt);
				prefs.setSizeMin(ui.askLimitOfValue("területének","minimumát négyzetméterben"));
				prefs.setSizeMax(ui.askLimitOfValue("területének","maximumát négyzetméterben"));
				prefs.setPriceMin(ui.askLimitOfValue("árának","minimumát forintban"));
				prefs.setPriceMax(ui.askLimitOfValue("árának","maximumát forintban"));
				AdvertisingStatus status = ui.askAdvertisingType();
				while(status == null) {
					System.err.println("Kötelező választani.");
					status = ui.askAdvertisingType();
				}
				prefs.setSearchType(status);
				City city = ui.askCity();
				while(city == null) {
					System.err.println("Kötelező választani.");
					city = ui.askCity();
				}
				prefs.setCity(city);
				prefs.setKeyWord1(ui.askKeyWord());
				prefs.setKeyWord2(ui.askKeyWord());
				prefs.setKeyWord3(ui.askKeyWord());
				clientTools.addSearchPreferencesToDB(prefs);
			}
			mm.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			mm.mainMenu(user, scanner);
			break;
		}
	}

	public void printSecondMenu() {
		System.out.println("				   	 ║");
		System.out.println("				 	 ╠ [1] Ügyfél keresés");
		System.out.println("				 	 ╠ [2] Új Ügyfél hozzáadása");
		System.out.println("	 				 ╚ [3] Vissza a főmenübe");

	}

}
