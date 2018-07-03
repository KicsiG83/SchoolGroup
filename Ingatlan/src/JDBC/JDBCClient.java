package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Client.Client;
import Client.ClientType;

public class JDBCClient {

	public void uploadClient(Client client)
			throws SQLException {
		String[] clientColumns = { client.getName(), client.getEmail(), client.getPhoneNumber(), client.getClientType().toString(), client.getComment(),""+client.isHasPreferences() };
		Connection connection = new JDBCConnection().createConnection();
		String upload = "INSERT INTO CLIENT VALUES (client_seq.nextval, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement clientStatement = connection.prepareStatement(upload)) {
			for (int i = 1; i <= clientColumns.length; i++) {
				clientStatement.setString(i, clientColumns[i - 1]);
			}
			clientStatement.addBatch();
			clientStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to client database!");
			System.out.println(client.toString());
		}
		connection.close();
	}
	
	public Client getLastClient() throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listNewClientData = "SELECT * FROM CLIENT WHERE CLIENT_ID = (SELECT MAX(CLIENT_ID) FROM CLIENT)";
		Client client = new Client();
		try (PreparedStatement getClientStatment = connection.prepareStatement(listNewClientData);
				ResultSet rs = getClientStatment.executeQuery()) {
			while (rs.next()) {
				String type = rs.getString(5);
				ClientType ct;
				if (type.equals("BUYER")) {
					ct = ClientType.BUYER;
				} else {
					ct = ClientType.SELLER;
				}
				boolean hasPrefs = rs.getString(7).equalsIgnoreCase("TRUE") ? true : false;
				client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), ct,
						rs.getString(6),hasPrefs);
				
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return client;
	}

	public ArrayList<Client> getAllClient() throws SQLException {
		ArrayList<Client> clientListFromDB = new ArrayList<Client>();
		Connection connection = new JDBCConnection().createConnection();
		String listNewClientData = "SELECT * FROM CLIENT";
		
		try (PreparedStatement getClientStatment = connection.prepareStatement(listNewClientData);
				ResultSet rs = getClientStatment.executeQuery()) {
			while (rs.next()) {
				String type = rs.getString(5);
				ClientType ct;
				if (type.equals("BUYER")) {
					ct = ClientType.BUYER;
				} else {
					ct = ClientType.SELLER;
				}
				boolean hasPrefs = rs.getString(7).equalsIgnoreCase("TRUE") ? true : false;
				Client client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), ct,
						rs.getString(6),hasPrefs);
				clientListFromDB.add(client);
				
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return clientListFromDB;
	}
}
