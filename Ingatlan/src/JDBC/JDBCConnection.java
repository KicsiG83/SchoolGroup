package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Helper.ConfigHelper;

public class JDBCConnection {

	private Connection connection;

	public Connection createConnection() {
		String url = ConfigHelper.url;
		String user = ConfigHelper.username;
		String password = ConfigHelper.password;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Adatbázis kapcsolódási hiba.");
			System.out.println(e.toString());
		}
		return connection;
	}
}
