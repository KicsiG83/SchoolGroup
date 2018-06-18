import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"	**********************************************************************************************");
		System.out.println(
				"	******                    Üdvözlöm a pinCode ingatlaniroda felületén!                   ******");
		System.out.println(
				"	**********************************************************************************************");
		System.out.println("");
		System.out.println("					B E J E L E N T K E Z É S");
		System.out.println();
		login(scanner);

	}

	public static void login(Scanner scanner) {
		String userID = "";
		String password = "";
		do {
			System.out.print("	 	    		    	   ╔ Azonosító : ");
			userID = scanner.nextLine();
			System.out.print("	    		  	    	   ╚ Jelszó    : ");
			password = scanner.nextLine();
			if (userID.equals("admin") && password.equals("admin")) {
				System.out.println();
				System.out.println("				 	 Sikeresen bejelentkezett!");
				System.out.println();
				mainMenu(scanner);
			} else {
				System.out.println();
				System.err.println("					Rossz felhasználónév vagy jelszó!");
				System.out.println();
			}

		} while (!userID.equals("admin") || !password.equals("admin"));
	}

	public static void mainMenu(Scanner scanner) {
		int mmainMenuChoice = 0;
		int subManuChoice = 0;
		System.out.print(
				"	1.INGATLAN ADATBÁZIS   2.ÜGYFÉL ADATBÁZIS  3.STATISZTIKÁK   4.FELHASZNÁLÓ KEZELÉS    5.KILÉPÉS"
						+ "	 => a választott főmenü: ");
		mmainMenuChoice = scanner.nextInt();
		scanner.nextLine();
		switch (mmainMenuChoice) {
		case 1:
			System.out.println("	   	 ║");
			System.out.println("	 	 ╠ [1] Ingatlan keresés");
			System.out.println("	 	 ╠ [2] Új ingatlan hozzáadása");
			System.out.println("	 	 ╚ [3] Vissza a főmenübe");
			System.out.print(
					"	                                                                                              "
							+ "	 => a választott almenü: ");
			subManuChoice = scanner.nextInt();
			scanner.nextLine();
			firstMenu(scanner, subManuChoice);
			break;
		case 2:
			System.out.println("				   	 ║");
			System.out.println("				 	 ╠ [1] Ügyfél keresés");
			System.out.println("				 	 ╠ [2] Új ügyfél hozzáadása");
			System.out.println("	 				 ╚ [3] Vissza a főmenübe");
			System.out.print(
					"	                                                                                              "
							+ "	 => a választott almenü: ");
			subManuChoice = scanner.nextInt();
			scanner.nextLine();
			secondMenu(scanner, subManuChoice);
			break;
		case 3:
			System.out.println("	 					  	 ║");
			System.out.println("	 						 ╠ [1] Eladási statisztikák");
			System.out.println("	 						 ╠ [2] Keresési statisztikák");
			System.out.println("	 						 ╚ [3] Vissza a főmenübe");
			System.out.print(
					"	                                                                                              "
							+ "	 => a választott almenü: ");
			subManuChoice = scanner.nextInt();
			scanner.nextLine();
			thirdMenu(scanner, subManuChoice);
			break;
		case 4:
			System.out.println("	 							  	 ║");
			System.out.println("								 	 ╠ [1] Saját jelszó módosítása");
			System.out.println("								 	 ╠ [2] Új felhasználó létrehozása");
			System.out.println(
					"								 	 ╠ [3] Saját vagy egyéb felhasználó adatainak módosítása");
			System.out.println("	 								 ╚ [4] Vissza a főmenübe");
			System.out.print(
					"	                                                                                              "
							+ "	 => a választott almenü: ");
			subManuChoice = scanner.nextInt();
			scanner.nextLine();
			fourthMenu(scanner, subManuChoice);
			break;

		case 5:
			System.out.println("	  									 		  ║");
			System.out.println("	  									 		  ║");
			System.out.println("										A program kilép.  ╝");
			System.out.println(" 									  További jó munkát kívánunk!");
			break;
		default:
			System.err.println("\n					!!!Nincs ilyen menüpont!!!");
			break;
		}
	}

	public static void firstMenu(Scanner scanner, int subManuChoice) {
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Ingatlan keresés");
			break;
		case 2:
			System.out.println("	[2] Új ingatlan hozzáadása");
			break;
		case 3:
			// System.out.println(" - Visszalépés a FŐ menübe -");
			System.out.println();
			mainMenu(scanner);
			break;
		}
	}

	public static void secondMenu(Scanner scanner, int subManuChoice) {
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Ügyfél keresés");
			break;
		case 2:
			System.out.println("	[2] Új ügyfél hozzáadása");
			break;
		case 3:
			// System.out.println(" - Visszalépés a FŐ menübe -");
			System.out.println();
			mainMenu(scanner);
			break;
		}
	}

	public static void thirdMenu(Scanner scanner, int subManuChoice) {
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Eladási statisztikák");
			break;
		case 2:
			System.out.println("	[2] Keresési statisztikák");
			break;
		case 3:
			// System.out.println(" - Visszalépés a FŐ menübe -");
			System.out.println();
			mainMenu(scanner);
			break;
		}
	}

	public static void fourthMenu(Scanner scanner, int subManuChoice) {
		switch (subManuChoice) {
		case 1:
			System.out.println("	[1] Saját jelszó módosítása");
			break;
		case 2:
			System.out.println("	[2] Új felhasználó létrehozása");
			break;
		case 3:
			System.out.println("	[3] Saját vagy egyéb felhasználó adatainak módosítása");
			break;
		case 4:
			// System.out.println(" - Visszalépés a FŐ menübe -");
			System.out.println();
			mainMenu(scanner);
			break;
		}
	}

}
