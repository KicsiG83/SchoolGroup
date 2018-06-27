package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Client.Client;

public class JDBCClient {

	public void uploadClient(Client client)
			throws SQLException {
		String[] clientColumns = { client.getName(), client.getEmail(), client.getPhoneNumber(), client.getClientType().toString(), client.getComment() };
		Connection connection = JDBCConnection.createConnection();
		String upload = "INSERT INTO CLIENT VALUES (client_seq.nextval, ?, ?, ?, ?, ?)";
		try (PreparedStatement clientStatement = connection.prepareStatement(upload)) {
			for (int i = 1; i <= clientColumns.length; i++) {
				clientStatement.setString(i, clientColumns[i - 1]);
			}
			clientStatement.addBatch();
			clientStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to client database!");
		}
		connection.close();
	}
	
	public static void listNewClient() throws SQLException {
		Connection connection = JDBCConnection.createConnection();
		String listNewClientData = "SELECT * FROM CLIENT WHERE CLIENT_ID = (SELECT MAX(CLIENT_ID) FROM CLIENT)";
		try (PreparedStatement getClientStatment = connection.prepareStatement(listNewClientData);
				ResultSet rs = getClientStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String type = rs.getString(5);
				if(type.equals("BUYER")) {
					type = "Vevő";
				}else {
					type = "Eladó";
				}
				String comment = rs.getString(6);
				if(comment == null) {
					comment = "- Nincs megjegyzés -";
				}
				System.out.println("\nÜgyfél azonosító: " + id + ", név: " + name + ", E-mail cím: " + email + ", Telefonszám: " + phone + ", Ügyfél típus: " + type + ", Ügyfél megjegyzés: " + comment + "\n");
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
	}
}
