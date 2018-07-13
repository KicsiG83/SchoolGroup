package Menu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLogicLayer.ClientTools;
import BusinessLogicLayer.Validator;
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
			System.out.println("				[1] Ügyfél kezelés");
			System.out.println("				             ║");
			System.out.println("				             ╠ {1} Keresés ID alapján");
			System.out.println("				             ╠ {2} Keresés név alapján");
			System.out.println("				             ╠ {3} Ügyfelek listázása");
			System.out.println("				             ╠ {4} Adatok módosítása ID alapján");
			System.out.println("				             ╚ {5} Visszalépés");
			int firstMenuChoice = sm.firstSubMeu();
			
			switch(firstMenuChoice) {
				case 1:
					int searchClientID = ui.askNumber("Adja meg az érdekelt ügyfél azonosítóját: ");
					Client result = clientTools.getClientWithClientID(searchClientID);
					if(result == null) {
						System.out.println("Nincs ilyen ügyfél.");
					} else {
						System.out.println("\n Ügyféladatok: ");
						System.out.println(result.toString());
						if(result.isHasPreferences() == true) {
							SearchPreferences clientPrefs = clientTools.getPreferencesWithClientID(result.getClientID());
							System.out.println("	" + clientPrefs.toString());
							System.out.println();
						}
					}
					System.out.println();
					break;
				case 2:
					String searchClientName = ui.askString("Adja meg az érdekelt ügyfél nevét: ");
					ArrayList<Client> resultList = clientTools.getClientWithName(searchClientName);
					if(resultList.size() == 0) {
						System.out.println("Nincs ilyen ügyfél.");
					} else {
						for(Client item : resultList) {
							System.out.println("\n Megfelelő ügyfelek: ");
							System.out.println(item.toString());
						}
						System.out.println();
					}
					break;
				case 3:
					System.out.println("Keresési feltételek megadása: ");
					System.out.println("Ha nem ad meg értéket, akkor azt a feltételt kihagyja.\n");
					String searchEmail = ui.askString("Szerepel az e-mail címében: ");
					String searchPhone = ui.askString("Szerepel a telefonszámában: ");
					System.out.println("Csak a kiválasztott típusúak: ");
					ClientType ct = ui.askCLientType();
					String searchClientType = ct == null ? "" : ct.toString();
					String searchComment = ui.askString("Szerepel a kommentjében: ");
					String searchHasPrefs = ui.askHasPreferencesInString();					
					resultList = clientTools.search(searchEmail,searchPhone,searchClientType,
							searchComment,searchHasPrefs);
					if(resultList.size() == 0) {
						System.out.println("Nincs ilyen ügyfél.");
					} else {
						System.out.println("\nMegfelelő ügyfelek: ");
						for(Client item : resultList) {
							System.out.println(item.toString());
						}
						System.out.println();
					}
					break;
				case 4:
					System.out.println("					    ║");
					System.out.println("					    ╠<1> Ügyfél törlése");
					System.out.println("					    ╠<2> Új preferenciák ügyfélhez rendelése");
					System.out.println("					    ╠<3> Ügyyfél adatainak módosítása");
					System.out.println("					    ╠<4> Ügyyfél preferenciáinak módosítása");
					System.out.println("					    ╚<5> Visszalépés");
					String userChoice = ui.askString("													 => a választott 'Ügyfél kezelés' almenü: ");
					while(!new Validator().isValidMenuChoice(userChoice,5)) {
						System.out.println("Nincs ilyen lehetőség.");
						userChoice = ui.askString("Kérem válasszon újra: ");
					}
					int optionIndex = Integer.parseInt(userChoice);
					switch(optionIndex) {
						case 1:
							int deleteClientID = ui.askNumber("Adja meg a törölni kívánt ügyfél azonosítóját: ");
							Client deleteableClient = clientTools.getClientWithClientID(deleteClientID);
							if(deleteableClient == null) {
								System.out.println("Nincs ilyen ügyfél.");
								break;
							} else {
								System.out.println("Biztos?");
								System.out.println("1 - Igen, 2 - Mégse");
								String answerToSaftyQuestion = ui.askString("Válasz: ");
								if(answerToSaftyQuestion.equals("")) {
									break;
								}
								while(!new Validator().isValidMenuChoice(answerToSaftyQuestion,2)) {
									System.out.println("Nincs ilyen lehetőség.");
									userChoice = ui.askString("Kérem válasszon újra: ");
								}
								if(answerToSaftyQuestion.equals("2")) {
									break;
								} else {
									clientTools.deleteClientWithID(deleteClientID);
									System.out.println("Ügyfél törölve.");
								}
							}
							break;					
						case 2:
							int updateClientID = ui.askNumber("Adja meg a módosítani kívánt ügyfél azonosítóját: ");
							Client ckeckerClient = clientTools.getClientWithClientID(updateClientID);
							if(ckeckerClient == null) {
								System.out.println("Nincs ilyen ügyfél.");
								break;
							} else if(ckeckerClient.isHasPreferences()) {
								System.out.println("Az ügyfélnek már vannak preferenciái.");
								break;
							} else {
								clientTools.hasPreferencesSetTrue(ckeckerClient.getClientID());
								SearchPreferences newPrefs = settingPreferences(ui,ckeckerClient);
								clientTools.addSearchPreferencesToDB(newPrefs);
								System.out.println();
								System.out.println(clientTools.getClientWithClientID(updateClientID).toString());
								SearchPreferences clientPrefs = clientTools.getPreferencesWithClientID(ckeckerClient.getClientID());
								System.out.println("	" + clientPrefs.toString());
								System.out.println();
							}
							break;
						case 3:
							updateClientID = ui.askNumber("Adja meg a módosítani kívánt ügyfél azonosítóját: ");
							ckeckerClient = clientTools.getClientWithClientID(updateClientID);
							if(ckeckerClient == null) {
								System.out.println("Nincs ilyen ügyfél.");
								break;
							} else {
								System.out.println("Adatok bekérése: ");
								System.out.println("Ha nem ad meg értéket, akkor azt a feltételt kihagyja.\n");
								String[] updater = new String[5];
								updater[0] = ui.askString("Új név: ");
								updater[1] = ui.askString("Új e-mail cím: ");
								updater[2] = ui.askString("Új telefonszám: ");
								System.out.println("Ügyféltípus módosítása: ");
								ClientType updateCT = ui.askCLientType();
								updater[3] = updateCT == null ? "" : updateCT.toString();
								updater[4] = ui.askString("Új komment: ");
								clientTools.updateClient(updateClientID,updater);
								System.out.println();
								System.out.println(clientTools.getClientWithClientID(updateClientID).toString());
								System.out.println();
							}
							break;
						case 4:
							updateClientID = ui.askNumber("Adja meg a módosítani kívánt ügyfél azonosítóját: ");
							ckeckerClient = clientTools.getClientWithClientID(updateClientID);
							if(ckeckerClient == null) {
								System.out.println("Nincs ilyen ügyfél.");
								break;
							} else {
								System.out.println("Ügyfélpreferenciák hozzáadása:\n");
								System.out.println("Ha nem ad meg értéket, akkor azt a feltételt kihagyja.\n");
								System.out.println("Új ingatlan típus:");
								String[] helper = new String[10];
								PropertyType pt = ui.askPropertyType();
								helper[0] = pt == null ? "" : pt.getTextual();
								helper[1] = ui.askString("Új terület minimum: ");
								helper[2] = ui.askString("Új terület maximum: ");
								helper[3] = ui.askString("Új ár minimum: ");
								helper[4] = ui.askString("Új ár maximum: ");
								System.out.println("Érdeklődés megváltoztatása: ");
								AdvertisingStatus searchType = ui.askAdvertisingType();
								helper[5] = searchType == null ? "" : searchType.getTextual();
								System.out.println("Új város: ");
								City city = ui.askCity();
								helper[6] = city == null ? "" : city.getTextual();
								helper[7] = ui.askString("Új keresési kulcsszó: ");
								helper[8] = ui.askString("Új keresési kulcsszó: ");
								helper[9] = ui.askString("Új keresési kulcsszó: ");
								clientTools.updatePreferences(updateClientID,helper);
							}
							System.out.println();
							break;
						case 5:
							
							System.out.println();
							break;
					}
					break;
					
				case 5:	
					System.out.println();
					break;
			}
			mm.mainMenu(user, scanner);
			break;
		case 2:
			System.out.println("				[2] Új Ügyfél hozzáadása");
			System.out.println("			   	                 ║");
			System.out.println("       					         ╠ {1} Mentés");
			System.out.println("       					         ╚ {2} Visszalépés");
			int secondMenuChoice = sm.secondSubMeu();
			if(secondMenuChoice == 1) {
				settingClient(scanner, ui, client, clientTools);
				clientTools.addClientToDB(client);
				Client checkerClient = clientTools.getLastClient();
				if(checkerClient.getClientType() == ClientType.BUYER) {
					SearchPreferences prefs = settingPreferences(ui, checkerClient);
					clientTools.addSearchPreferencesToDB(prefs);
				}
			} else if(secondMenuChoice == 2) {
				System.out.println("\n Vissza a főmenübe \n");
			}
			mm.mainMenu(user, scanner);
			break;
		case 3:
			System.out.println();
			mm.mainMenu(user, scanner);
			break;
		}
	}

	private SearchPreferences settingPreferences(UserInterface ui, Client checkerClient) {
		System.out.println("Ügyfélpreferenciák hozzáadása:\n");
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
		String keyWord = ui.askKeyWord();
		/*while(keyWord.equals("")) {
			System.err.println("Kötelező megadni.");
			keyWord = ui.askKeyWord();
		}*/
		prefs.setKeyWord1(keyWord);
		keyWord = ui.askKeyWord();
		/*while(keyWord.equals("")) {
			System.err.println("Kötelező megadni.");
			keyWord = ui.askKeyWord();
		}*/
		prefs.setKeyWord2(keyWord);
		keyWord = ui.askKeyWord();
		/*while(keyWord.equals("")) {
			System.err.println("Kötelező megadni.");
			keyWord = ui.askKeyWord();
		}*/
		prefs.setKeyWord3(keyWord);
		return prefs;
	}

	private void settingClient(Scanner scanner, UserInterface ui, Client client, ClientTools clientTools)
			throws SQLException {
		client.setName(ui.askString("Kérem adja meg az ügyfél nevét: "));
		client.setEmail(ui.getEmailAddress("Kérem adja meg az ügyfél e-mail címét: "));
		client.setPhoneNumber(ui.getPhoneNumber("Kérem adja meg az ügyfél telefonszámát: +36"));
		client.setComment(ui.askString("Kérem adja meg az ügyfél kommentjét: "));
		client.setClientTypeByUser(scanner);
		if(client.getClientType()== ClientType.BUYER) {
			client.setHasPreferences(true);
		}
	}

	public void printSecondMenu() {
		System.out.println("				   	 ║");
		System.out.println("				 	 ╠ [1] Ügyfél kezelés");
		System.out.println("				 	 ╠ [2] Új Ügyfél hozzáadása");
		System.out.println("	 				 ╚ [3] Vissza a főmenübe");

	}

}
