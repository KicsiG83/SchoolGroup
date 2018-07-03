package BusinessLogicLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import Client.*;
import JDBC.JDBCClient;
import JDBC.JDBCSearchPreferences;

public class ClientTools {
	private JDBCClient jdbcClient = new JDBCClient();
	
	public void addClientToDB(Client client) throws SQLException {
		jdbcClient.uploadClient(client);
	}
	public void addSearchPreferencesToDB(SearchPreferences prefs) throws SQLException {
		new JDBCSearchPreferences().uploadPreferences(prefs);
		
	}
	public ArrayList<Client> getClientListfromDB() throws SQLException {
		ArrayList<Client> clientListFromDB = new ArrayList<Client>();
		clientListFromDB = jdbcClient.getAllClient();
		return clientListFromDB;	
	}
	public Client getLastClient() throws SQLException {
		return jdbcClient.getLastClient();
	}
	public int getClientID(Client client) {
		return client.getClientID();
	}

}
