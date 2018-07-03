package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Client.SearchPreferences;

public class JDBCSearchPreferences {
	public void uploadPreferences(SearchPreferences prefs) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String upload = "INSERT INTO SEARCH_PROPERTY VALUES (SEARCH_PROPERTY_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement propertyStatement = connection.prepareStatement(upload)) {
			propertyStatement.setInt(1, prefs.getClientID());
			propertyStatement.setString(2, prefs.getPropertyType().getTextual());
			propertyStatement.setString(3, Integer.toString(prefs.getSizeMin()));
			propertyStatement.setString(4, Integer.toString(prefs.getSizeMax()));
			propertyStatement.setString(5, Integer.toString(prefs.getPriceMin()));
			propertyStatement.setString(6, Integer.toString(prefs.getPriceMax()));
			propertyStatement.setString(7, prefs.getSearchType().getTextual());
			propertyStatement.setString(8, prefs.getCity().getTextual());
			propertyStatement.setString(9, prefs.getKeyWord1());
			propertyStatement.setString(10, prefs.getKeyWord2());
			propertyStatement.setString(11, prefs.getKeyWord3());
			
			propertyStatement.addBatch();
			propertyStatement.executeBatch();
			
		}catch (SQLException e) {
			System.err.println("Could not upload to search property database!");
			System.out.println(prefs.toString());
		}
		connection.close();
	}
}
