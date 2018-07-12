package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import Client.*;
import Property.Property;

public class TestData {
	
	public Tester tester = new Tester();

	public void generate() throws SQLException {
		JDBCClient jdbcClient = new JDBCClient();
		Client primeOwner = new Client(0, "Prime Owner", "prime.owner@fakemail.bazsi", "201000000", ClientType.SELLER, "", false);
		jdbcClient.uploadClient(primeOwner);
		primeOwner = jdbcClient.getLastClient();
		ArrayList<Client> testClients = tester.generateTestClients();
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
		ArrayList<Property> testProperties = tester.generateTestProperties(primeOwner.getClientID());
		for(Property property : testProperties) {
			new JDBCProperty().uploadProperty(property);
		}
	}
}
