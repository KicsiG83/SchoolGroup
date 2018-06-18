import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCClient {

	public static void uploadClient(String name, String email, String phoneNumber, String type, String comment) throws SQLException {
		String[] userColumns = {name, email, phoneNumber, type, comment};
		Connection connection = JDBCConnection.createConnection();
		String upload = "INSERT INTO CLIENT (CLIENT_ID, CLIENT_NAME,  CLIENT_EMAIL,  PHONE_NUMBER, CLIENT_TYPE, CLIENT_COMMENT) VALUES (client_seq.nextval, ?, ?, ?, ?, ?)";
		try (PreparedStatement clientStatement = connection.prepareStatement(upload)) {
			for(int i = 1; i <= userColumns.length; i++) {
				clientStatement.setString(i, userColumns[i-1]);
			}
			clientStatement.addBatch();
			clientStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to client database!");
		}
		connection.close();
	}
}
