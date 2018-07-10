package Property;

import java.util.Scanner;

import JDBC.JDBCSearchProperty;

public class SearchProperty {

	public void searchPropertyById(Scanner sc) {
		boolean valid = false;
		do {
			try {
				System.out.println("Kérem adja meg a keresett ingatlan azonosítóját: ");
				int propertyId = sc.nextInt();
				sc.nextLine();
				if(propertyId>0) {
					new JDBCSearchProperty().searchPropertyById(propertyId);
					valid = true;
				}else {
					System.out.println("A megadott érték érvénytelen.");
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("A megadott érték érvénytelen.");
			}
		} while (valid);
	}
	
	public void selectPropertyByParameters(Scanner sc) {
//		boolean valid = false;
//		do {
//			try {
//				System.out.println("Kérem adja meg a keresett ingatlan paramétereit: ");
//				int propertyId = sc.nextInt();
//				sc.nextLine();
//				new JDBCSearchProperty().searchPropertyById(propertyId);
//				valid = true;
//			} catch (Exception e) {
//				sc.nextLine();
//				System.out.println("A megadott érték érvénytelen.");
//			}
//		} while (valid);
	}
}
