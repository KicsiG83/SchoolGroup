package BusinessLogicLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import Client.*;
import JDBC.JDBCClient;
import JDBC.JDBCSearchPreferences;

public class ClientTools {
	private JDBCClient jdbcClient = new JDBCClient();
	private JDBCSearchPreferences jdbcPreferences = new JDBCSearchPreferences();
	
	public void addClientToDB(Client client) throws SQLException {
		jdbcClient.uploadClient(client);
	}
	public void addSearchPreferencesToDB(SearchPreferences prefs) throws SQLException {
		jdbcPreferences.uploadPreferences(prefs);
		
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
	public Client getClientWithClientID(int searchClientID) throws SQLException {
		String query = "SELECT * FROM CLIENT WHERE CLIENT_ID =" + searchClientID;
		ArrayList<Client> resultList = jdbcClient.runGetterQuery(query);
		if(resultList.size() == 0) {
			return null;
		} else  {
			return resultList.get(0);
		}
		
	}
	public ArrayList<Client> getClientWithName(String searchClientName) throws SQLException {
		String query = "SELECT * FROM CLIENT WHERE CLIENT_NAME LIKE '%" + searchClientName +"%'";
		ArrayList<Client> resultList = jdbcClient.runGetterQuery(query);
		return resultList;
	}
	public SearchPreferences getPreferencesWithClientID(int clientID) throws SQLException {
		String query = "SELECT * FROM SEARCH_PROPERTY WHERE CLIENT_ID =" + clientID;
		SearchPreferences result = jdbcPreferences.runGetterQuery(query);
		return result;
	}
	public ArrayList<Client> search(String searchEmail, String searchPhone, String searchClientType,
			String searchComment, String searchHasPrefs) throws SQLException {
		String query = "SELECT * FROM CLIENT";
		String[] helper = new String[5];
		int index =0;
		if(!searchEmail.equals("")) {
			helper[index] = "CLIENT_EMAIL LIKE '%" + searchEmail + "%'";
			index++;		
		}
		if(!searchPhone.equals("")) {
			helper[index] = "PHONE_NUMBER LIKE '%" + searchPhone + "%'";
			index++;		
		}
		if(!searchClientType.equals("")) {
			helper[index] = "CLIENT_TYPE LIKE '%" + searchClientType + "%'";
			index++;		
		}
		if(!searchComment.equals("")) {
			helper[index] = "CLIENT_COMMENT LIKE '%" + searchComment + "%'";
			index++;		
		}
		if(!searchHasPrefs.equals("")) {
			helper[index] = "HAS_PREFERENCES LIKE '%" + searchHasPrefs + "%'";
			index++;		
		}
		String sep = " WHERE ";
		for(int i=0;i<index;i++) {
			query = query + sep + helper[i];
			sep = " AND ";
		}
		ArrayList<Client> result = jdbcClient.runGetterQuery(query);
		return result;
	}
	public void deleteClientWithID(int deleteClientID) throws SQLException {
		String query = "DELETE FROM CLIENT WHERE CLIENT_ID =" + deleteClientID;
		jdbcClient.runSetterQuery(query);
		
	}
	public void hasPreferencesSetTrue(int clientID) throws SQLException {
		String query = "UPDATE CLIENT SET HAS_PREFERENCES = 'true' WHERE CLIENT_ID =" + clientID;
		jdbcClient.runSetterQuery(query);
		
	}
	public void updateClient(int updateClientID, String[] updater) throws SQLException {
		String query = "UPDATE CLIENT SET ";
		String sep = "";
		if(!updater[0].equals("")) {
			String updateName = "CLIENT_NAME = '" + updater[0] + "'";
			query = query + sep + updateName;
			sep = ",";
		}
		if(!updater[1].equals("")) {
			String updateEmail = "CLIENT_EMAIL = '" + updater[1] + "'";
			query = query + sep + updateEmail;
			sep = ",";
		}
		if(!updater[2].equals("")) {
			String updatePhone = "PHONE_NUMBER = '" + updater[2] + "'";
			query = query + sep + updatePhone;
			sep = ",";
		}
		if(!updater[3].equals("")) {
			String updateType = "CLIENT_TYPE = '" + updater[3] + "'";
			query = query + sep + updateType;
			sep = ",";
		}
		if(!updater[4].equals("")) {
			String updateComment = "CLIENT_COMMENT = '" + updater[4] + "'";
			query = query + sep + updateComment;
			sep = ",";
		}
		query = query + " WHERE CLIENT_ID = " + updateClientID;
		jdbcClient.runSetterQuery(query);
	}
	public void updatePreferences(int updateClientID, String[] helper) throws SQLException {
		String query = "UPDATE SEARCH_PROPERTY SET ";
		String sep = "";
		if(!helper[0].equals("")) {
			String propType = "PROPERTY_TYPE = '" + helper[0] + "'";
			query = query + sep + propType;
			sep = ",";
		}
		if(!helper[1].equals("")) {
			String sizeMin = "SIZE_MIN = '" + helper[1]+ "'";
			query = query + sep + sizeMin;
			sep = ",";
		}
		if(!helper[2].equals("")) {
			String sizeMax = "SIZE_MAX = '" + helper[2]+ "'";
			query = query + sep + sizeMax;
			sep = ",";
		}
		if(!helper[3].equals("")) {
			String priceMin = "PRICE_MIN = '" + helper[3] + "'";
			query = query + sep + priceMin;
			sep = ",";
		}
		if(!helper[4].equals("")) {
			String priceMax = "PRICE_MAX = '" + helper[4]+ "'";
			query = query + sep + priceMax;
			sep = ",";
		}
		if(!helper[5].equals("")) {
			String searchType = "SEARCH_TYPE = '" + helper[5]+ "'";
			query = query + sep + searchType;
			sep = ",";
		}
		if(!helper[6].equals("")) {
			String city = "CITY = '" + helper[6]+ "'";
			query = query + sep + city;
			sep = ",";
		}
		if(!helper[7].equals("")) {
			String keyword1 = "KEYWORD_ONE = '" + helper[7]+ "'";
			query = query + sep + keyword1;
			sep = ",";
		}
		if(!helper[8].equals("")) {
			String keyword2 = "KEYWORD_TWO = '" + helper[8]+ "'";
			query = query + sep + keyword2;
			sep = ",";
		}
		if(!helper[9].equals("")) {
			String keyword3 = "KEYWORD_THREE = '" + helper[9]+ "'";
			query = query + sep + keyword3;
			sep = ",";
		}
		query = query + " WHERE CLIENT_ID =" + updateClientID;
		jdbcPreferences.runSetterQuery(query);
		
	}

}
