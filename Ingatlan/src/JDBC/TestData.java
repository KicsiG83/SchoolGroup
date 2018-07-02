package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import Client.Client;
import Property.Property;

public class TestData {
	public Tester tester = new Tester();
	/**
	 * A használata előtt létre kell, hozni a menüből egy felhasználót.
	 * Ennek ID-jét ki kell lesni a DB-ből.
	 * tester.generateOneProperty() metódus kommentől jelölt sorában, ezt az ID-t kell megadni,
	 * @throws SQLException
	 */
	public void generate() throws SQLException {
		ArrayList<Client> testClients = tester.generateTestClients();
		for(Client client : testClients) {
			new JDBCClient().uploadClient(client);
		}
		
		ArrayList<Property> testProperties = tester.generateTestProperties();
		for(Property property : testProperties) {
			new JDBCProperty().uploadProperty(property);
		}
	}
}
