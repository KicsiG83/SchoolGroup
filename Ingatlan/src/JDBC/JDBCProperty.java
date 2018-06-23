package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCProperty {

	public static void uploadProperty(int clientId, int userId, String adType, String addressType, String price,
			String city, String district, String street, String streetNumber, String floor, String doorNumber,
			String elevator, String status, String addressSize, String roomNumber, String balcony,
			String airConditioner, String garden, String panelProgram, String height, String propertyCondition,
			String description, int counter) throws SQLException {
		String[] propertyColumns = { adType, addressType, price, city, district, street, streetNumber, floor,
				doorNumber, elevator, status, addressSize, roomNumber, balcony, airConditioner, garden, panelProgram,
				height, propertyCondition, description };
		Connection connection = JDBCConnection.createConnection();
		String upload = "INSERT INTO PROPERTY VALUES (PROPERTY_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement propertyStatement = connection.prepareStatement(upload)) {
			propertyStatement.setInt(1, clientId);
			propertyStatement.setInt(2, userId);
			for (int i = 0; i < propertyColumns.length; i++) {
				int index = i + 3;
				System.out.println(index + " - " + propertyColumns[i]);
				propertyStatement.setString(index, propertyColumns[i]);
			}
			propertyStatement.setInt(23, counter);
			propertyStatement.addBatch();
			propertyStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to property database!");
		}
		connection.close();
	}

}
