package BusinessLogicLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.JDBCStatistics;

public class Statistic {
	private JDBCStatistics jdbcStatitistics = new JDBCStatistics();
	
	public ArrayList<String> getViewCounter() throws SQLException {
		String query = "SELECT * FROM VIEW_COUNTER_VW";
		ArrayList<String> result = jdbcStatitistics.runViewCounterQuery(query);
		return result;
	}
	
	public ArrayList<String> getSoldStatistic() throws SQLException {
		String query = "SELECT * FROM SALE_VW";
		ArrayList<String> result = jdbcStatitistics.runSaleStatistic(query);
		return result;
	}
}
