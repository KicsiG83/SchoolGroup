package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Property.Property;

public class JDBCProperty {

	public void uploadProperty(Property property
			/*int clientId, int userId, String adType, String addressType, String price,
			String city, String district, String street, String streetNumber, String floor, String doorNumber,
			String elevator, String status, String addressSize, String roomNumber, String balcony,
			String airConditioner, String garden, String panelProgram, String height, String propertyCondition,
			String description, int counter*/
			) throws SQLException {
		/*String[] propertyColumns = { adType, addressType, price, city, district, street, streetNumber, floor,
				doorNumber, elevator, status, addressSize, roomNumber, balcony, airConditioner, garden, panelProgram,
				height, propertyCondition, description };*/
		Connection connection = new JDBCConnection().createConnection();
		String upload = "INSERT INTO PROPERTY VALUES (PROPERTY_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement propertyStatement = connection.prepareStatement(upload)) {
			propertyStatement.setInt(1, property.getClientID());
			propertyStatement.setInt(2, property.getUserID());
			propertyStatement.setString(3, property.getPropertyType().getTextual());
			propertyStatement.setInt(4, property.getSize());
			propertyStatement.setInt(5, property.getGroundSize());
			propertyStatement.setInt(6, property.getNumberOfRooms());
			propertyStatement.setInt(7, property.getNumberOfHalfRooms());
			propertyStatement.setInt(8, property.getPrice());
			propertyStatement.setString(9, property.getStreetAndNumber());
			propertyStatement.setString(10, property.getCity().getTextual());
			propertyStatement.setString(11, property.getMaterial().getTextual());
			propertyStatement.setString(12, property.getWc().getTextual());
			propertyStatement.setString(13, property.getLevel().getTextual());
			propertyStatement.setString(14, property.getCondition().getTextual());
			propertyStatement.setString(15, property.getDescription());
			propertyStatement.setString(16, property.getStatus().getTextual());
			propertyStatement.setInt(17, property.getCountNUmber());
			/*
			for (int i = 0; i < propertyColumns.length; i++) {
				int index = i + 3;
				System.out.println(index + " - " + propertyColumns[i]);
				propertyStatement.setString(index, propertyColumns[i]);
			}
			propertyStatement.setInt(23, counter);
			*/
			propertyStatement.addBatch();
			propertyStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to property database!");
			System.out.println(property.toString());
		}
		connection.close();
	}

}
