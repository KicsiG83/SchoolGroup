package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import Client.*;
import Property.Property;

public class TestData {
	public Tester tester = new Tester();
	/**
	 * A használata előtt létre kell, hozni a menüből egy felhasználót.
	 * Ennek ID-jét ki kell lesni a DB-ből.
	 * tester.generateOneProperty() metódus kommenttel jelölt sorában, ezt az ID-t kell megadni,
	 * @throws SQLException
	 */
	public void generate() throws SQLException {
		ArrayList<Client> testClients = tester.generateTestClients();
		JDBCClient jdbcClient = new JDBCClient();
		int searchID = 0;
		for(Client client : testClients) {
			jdbcClient.uploadClient(client);
			Client checkerClient = jdbcClient.getLastClient();
			if(checkerClient.isHasPreferences()) {
				searchID++;
				SearchPreferences prefs = tester.generateOnePreferences(searchID, checkerClient.getClientID());
				new JDBCSearchPreferences().uploadPreferences(prefs);
			}
		}
		
		ArrayList<Property> testProperties = tester.generateTestProperties();
		for(Property property : testProperties) {
			new JDBCProperty().uploadProperty(property);
		}
	}
}
