package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public SearchPreferences runGetterQuery(String query) throws SQLException {
		JDBCProperty helper = new JDBCProperty();
		Connection connection = new JDBCConnection().createConnection();
		SearchPreferences clientPrefs = new SearchPreferences();
		try (PreparedStatement propertyStatment = connection.prepareStatement(query);
				ResultSet rs = propertyStatment.executeQuery()) {
			while(rs.next()) {
				clientPrefs.setSearchID(rs.getInt(1));
				clientPrefs.setClientID(rs.getInt(2));
				clientPrefs.setPropertyType(helper.getPropertyType(rs.getString(3)));
				clientPrefs.setSizeMin(Integer.parseInt(rs.getString(4)));
				clientPrefs.setSizeMax(Integer.parseInt(rs.getString(5)));
				clientPrefs.setPriceMin(Integer.parseInt(rs.getString(6)));
				clientPrefs.setPriceMax(Integer.parseInt(rs.getString(7)));
				clientPrefs.setSearchType(helper.getStatus(rs.getString(8)));
				clientPrefs.setCity(helper.getCity(rs.getString(9)));
				clientPrefs.setKeyWord1(rs.getString(10));
				clientPrefs.setKeyWord2(rs.getString(11));
				clientPrefs.setKeyWord3(rs.getString(12));
			}
		}catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return clientPrefs;
	}

	public void runSetterQuery(String query) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		try (PreparedStatement propertyStatment = connection.prepareStatement(query);
				ResultSet rs = propertyStatment.executeQuery()) {
			propertyStatment.addBatch();
			propertyStatment.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could upload data!");
		}
		connection.close();
		
	}
}
