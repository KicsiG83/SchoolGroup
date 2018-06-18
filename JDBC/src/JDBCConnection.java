import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static Connection connection;

	public static Connection createConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pinCodeAdminUser";
		String password = "admin";
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is made now!");
		} catch (SQLException e) {
			System.err.println("Could not initialize database connection");
		}
		return connection;
	}
}
