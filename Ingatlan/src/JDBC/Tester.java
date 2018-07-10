package JDBC;


import java.util.ArrayList;
import java.util.Random;

import Client.*;
import Property.*;

public class Tester {
	private Random rnd = new Random();
	private String[] streets = {"Arany János utca","Petőfi Sándor utca", "Kossuth Lajos utca",
			"II. Rákóczi Ferenc út", "Fő utca", "Széchenyi tér"};
	private String[] lastNames = {"Tóth","Kovács","Kiss","Nagy","Vámos","Varga","Kádár","Szabó","Molnár"};
	private String[] firstNames = {"József","Béla","Géza","László","István",
			"Zsuzsanna","Mária","Erzsébet","Ágnes","Anna"};
	private String[] keyWords = {"medence","erkély","garázs", "központi fűtés","cirko","gázkonvektor",
			"belső udvar","közlekedés","nap","csendes","vásárlás","orvos","levegő"};
	public ArrayList<Client> generateTestClients() {
		ArrayList<Client> listOfTestClients = new ArrayList<Client>();
		int clientIDCounter = 0;
		for(int i=0;i<65;i++) {
			clientIDCounter++;
			listOfTestClients.add(generateOneClient(clientIDCounter));
		}
		return listOfTestClients;
	}
	public SearchPreferences generateOnePreferences(int searchID, int clientID) {
		SearchPreferences prefs = new SearchPreferences();
		prefs.setSearchID(searchID);
		prefs.setClientID(clientID);
		prefs.setPropertyType(setTestPropertyType());
		prefs.setSizeMin(rnd.nextInt(15)+10);
		prefs.setSizeMax(rnd.nextInt(450)+50);
		prefs.setPriceMin((rnd.nextInt(4)+1)*1000000);
		prefs.setPriceMax((rnd.nextInt(150)+50)*1000000);
		prefs.setSearchType(setTestAdvertisingStatus());
		prefs.setCity(setTestCity());
		prefs.setKeyWord1(setTestKeyWord());
		prefs.setKeyWord2(setTestKeyWord());
		prefs.setKeyWord3(setTestKeyWord());
		return prefs;
		
	}
	private String setTestKeyWord() {
		String keyWord = keyWords[rnd.nextInt(keyWords.length)];
		return keyWord;
	}
	public Client generateOneClient(int clientIDCounter) {
		Client testClient = new Client();
		testClient.setClientID(clientIDCounter);
		String name = generateName();
		testClient.setName(name);
		testClient.setEmail(generateEmail(name,clientIDCounter));
		testClient.setPhoneNumber(generatePhoneNumber());
		testClient.setClientType(setTestClientType(clientIDCounter));
		testClient.setComment("Nincs megjegyzés");
		testClient.setHasPreferences(setTestPreferences(testClient.getClientType()));
		return testClient;
	}

	private boolean setTestPreferences(ClientType clientType) {
		if(clientType.equals(ClientType.BUYER)) {
			return true;
		}
		return false;
	}
	private ClientType setTestClientType(int clientIDCounter) {
		if(clientIDCounter % 3 == 0) {
			return ClientType.BUYER;			
		}
		return ClientType.SELLER;
	}

	private String generatePhoneNumber() {
		String[] preCaller = {"20","30","70"};
		String phoneNumber = preCaller[rnd.nextInt(3)];
		
		int[] numbers = new int[7];
		numbers[0] = rnd.nextInt(9)+1;
		phoneNumber = phoneNumber + Integer.toString(numbers[0]);
		for(int i=1;i<7;i++) {
			numbers[i] = rnd.nextInt(10);
			phoneNumber = phoneNumber + Integer.toString(numbers[i]);
		}
		
		return phoneNumber;
	}

	private String generateEmail(String name, int clientIDCounter) {
		String email;		
		String num = Integer.toString(clientIDCounter);
		String text = makeTextToEmailAddress(name);
		email = text+num+"@fakemail.bazsi";		
		return email;
	}

	private String makeTextToEmailAddress(String name) {
		String text = name;
		text = text.toLowerCase();
		text = text.replace('á', 'a');
		text = text.replace('é', 'e');
		text = text.replace('í', 'i');
		text = text.replace('ö', 'o');
		text = text.replace('ő', 'o');
		text = text.replace('ó', 'o');
		text = text.replace('ú', 'u');
		text = text.replace('ü', 'u');
		text = text.replace('ű', 'u');
		text = text.replace(' ', '.');
		
		return text;
	}

	private String generateName() {
		String name;
		String lastName = lastNames[rnd.nextInt(lastNames.length)];
		String firstName = firstNames[rnd.nextInt(firstNames.length)];
		name = lastName + " " + firstName;
		return name;
	}

	public ArrayList<Property> generateTestProperties() {
		ArrayList<Property> listOftestProperties = new ArrayList<Property>();
		int propIDCounter = 0;
		int userID = 1;
		
		for(int i=0;i<300;i++) {
			propIDCounter++;
			listOftestProperties.add(generateOneProperty(propIDCounter,userID));
		}
		return listOftestProperties;
	}
	
	public Property generateOneProperty(int propIDCounter,int userID) {
		Property testProp = new Property();
		testProp.setPropertyID(propIDCounter);
		testProp.setClientID(1);//ezt kell állítani.
		testProp.setUserID(userID);
		PropertyType testPropType = setTestPropertyType();
		testProp.setPropertyType(testPropType);
		testProp.setSize(rnd.nextInt(300)+20);
		testProp.setGroundSize(setTestGroundSize(testPropType));
		testProp.setNumberOfRooms(rnd.nextInt(5)+1);
		testProp.setNumberOfHalfRooms(rnd.nextInt(3)+0);
		testProp.setPrice((rnd.nextInt(90)+8)*1000000);
		testProp.setStreetAndNumber(setTestAddress());
		testProp.setCity(setTestCity());
		testProp.setMaterial(setTestMaterial());
		testProp.setWc(setTestToilet());
		testProp.setLevel(setTestEnergeticLevel());
		testProp.setCondition(setTestCondition());
		testProp.setDescription("Nincs leírás");
		testProp.setStatus(setTestAdvertisingStatus());
		testProp.setCountNUmber(0);
		return testProp;
	}

	private AdvertisingStatus setTestAdvertisingStatus() {
		AdvertisingStatus status = AdvertisingStatus.values()[rnd.nextInt(2)];
		return status;
	}

	private PropertyCondition setTestCondition() {
		PropertyCondition cond = PropertyCondition.values()[rnd.nextInt(PropertyCondition.values().length)];
		return cond;
	}

	private EnergeticLevel setTestEnergeticLevel() {
		EnergeticLevel level = EnergeticLevel.values()[rnd.nextInt(EnergeticLevel.values().length)];
		return level;
	}

	private Material setTestMaterial() {
		Material mat = Material.values()[rnd.nextInt(Material.values().length)];
		return mat;
	}

	private String setTestAddress() {
		String street = streets[rnd.nextInt(streets.length)];
		String num = Integer.toString(rnd.nextInt(99)+1);
		return street + " " + num;
	}

	private int setTestGroundSize(PropertyType testPropType) {
		if(testPropType == PropertyType.HOUSE) {
			return rnd.nextInt(250) +50;
		} else if(testPropType == PropertyType.OFFICE) {
			return rnd.nextInt(1400) +100;
		}
		return 0;
	}

	private PropertyType setTestPropertyType() {
		PropertyType type = PropertyType.values()[rnd.nextInt(PropertyType.values().length)];
		return type;
	}
	private City setTestCity() {
		City city = City.values()[rnd.nextInt(City.values().length-1)];
		return city;
	}
	private Toilet setTestToilet() {
		Toilet wc = Toilet.values()[rnd.nextInt(Toilet.values().length)];
		return wc;
	}

}
