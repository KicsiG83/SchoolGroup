package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private Connection connection;

	public Connection createConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PINCODEADMINUSER";
		String password = "admin";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Could not initialize database connection");
			System.out.println(e.toString());
		}
		return connection;
	}
}
