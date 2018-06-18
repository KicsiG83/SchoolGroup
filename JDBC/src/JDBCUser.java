import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUser {

	public static void uploadUser(String name, String password, String email, String status) throws SQLException {
		String[] userColumns = {name, password, email, status};
		Connection connection = JDBCConnection.createConnection();
		String upload = "INSERT INTO USER_DATA VALUES (user_seq.nextval, ?, ?, ?, ?)";
		try (PreparedStatement userStatement = connection.prepareStatement(upload)) {
			for(int i = 1; i <= userColumns.length; i++) {
				userStatement.setString(i, userColumns[i-1]);
			}
			userStatement.addBatch();
			userStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Could not upload to database!");
		}
		connection.close();
	}
	
	public static void listAllUserData() throws SQLException {
		Connection connection = JDBCConnection.createConnection();
		String listAll = "SELECT * FROM USER_DATA";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listAll); ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String status = rs.getString(5);
				System.out.println("ID: " + id + ", név: " + name + ", Jelszó: " + password + ", E-mail cím: " + email + ", Státusz: " + status);
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
	}
}
