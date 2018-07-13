package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCStatistics {
	public void runQuery(String query) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		try (PreparedStatement statStatement = connection.prepareStatement(query);
				ResultSet rs = statStatement.executeQuery()) {
			
		} catch(Exception e) {
			
		}
		connection.close();
	}
}
