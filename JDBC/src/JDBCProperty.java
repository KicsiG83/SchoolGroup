import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCProperty {

	public static void uploadProperty(int clientId, int userId, String adType, String addressType, String price,
			String city, String district, String street, String streetNumber, String floor, String doorNumber,
			String elevator, String status, String addressSize, String roomNumber, String balcony,
			String airConditioner, String garden, String panelProgram, String height, String propertyCondition,
			String description) throws SQLException {
		
		Connection connection = JDBCConnection.createConnection();
		String upload = "INSERT INTO PROPERTY VALUES (PROPERTY_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement clientStatement = connection.prepareStatement(upload)) {
			clientStatement.setInt(1, clientId);
			clientStatement.setInt(2, userId);
			clientStatement.setString(3, adType);
			clientStatement.setString(4, addressType);
			clientStatement.setString(5, price);
			clientStatement.setString(6, city);
			clientStatement.setString(7, district);
			clientStatement.setString(8, street);
			clientStatement.setString(9, streetNumber);
			clientStatement.setString(10, floor);
			clientStatement.setString(11, doorNumber);
			clientStatement.setString(12, elevator);
			clientStatement.setString(13, status);
			clientStatement.setString(14, addressSize);
			clientStatement.setString(15, roomNumber);
			clientStatement.setString(16, balcony);
			clientStatement.setString(17, airConditioner);
			clientStatement.setString(18, garden);
			clientStatement.setString(19, panelProgram);
			clientStatement.setString(20, height);
			clientStatement.setString(21, propertyCondition);
			clientStatement.setString(22, description);
			clientStatement.addBatch();
			clientStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to client database!");
		}
		connection.close();
	}

}
