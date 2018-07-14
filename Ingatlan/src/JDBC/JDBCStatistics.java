package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCStatistics {
	
	public ArrayList<String> runSaleStatistic(String query) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		ArrayList<String> result = new ArrayList<String>();
		try (PreparedStatement statStatement = connection.prepareStatement(query);
				ResultSet rs = statStatement.executeQuery()) {
			String resultRow = "";
			while(rs.next()) {
				resultRow = "A(z) " + rs.getString(1) + " nevű felhasználó " + rs.getInt(2) +
						" ingatlan eladásában/kiadásában segédkezett."
				 ;
				result.add(resultRow);
			}
		} catch(Exception e) {
			
		}
		connection.close();
		return result;
	}

	public ArrayList<String> runViewCounterQuery(String query) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		ArrayList<String> result = new ArrayList<String>();
		try (PreparedStatement statStatement = connection.prepareStatement(query);
				ResultSet rs = statStatement.executeQuery()) {
			String resultRow ="";
			while(rs.next()) {
				resultRow = "A(z) " + rs.getInt(1) + " azonosítójú ingatlanra " + rs.getInt(2) +
						" alkalommal kerestek rá.";
				result.add(resultRow);
			}
		} catch(Exception e) {
			
		}
		connection.close();
		return result;
	}
}
