package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUser extends User.User {

	public void uploadUser(String name, String password, String email, String status) throws SQLException {
		String[] userColumns = { name, password, email, status };
		Connection connection = new JDBCConnection().createConnection();
		String upload = "INSERT INTO USER_DATA VALUES (user_seq.nextval, ?, ?, ?, ?)";
		try (PreparedStatement userStatement = connection.prepareStatement(upload)) {
			for (int i = 1; i <= userColumns.length; i++) {
				userStatement.setString(i, userColumns[i - 1]);
			}
			userStatement.addBatch();
			userStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Sikerrtelen feltöltés");
		}
		connection.close();
	}

	public void listAllUserData() throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listAll = "SELECT * FROM USER_DATA ORDER BY USER_ID ASC";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listAll);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(4);
				String status = rs.getString(5);
				System.out.println("ID: " + id + ", név: " + name + ", E-mail cím: " + email + ", Státusz: " + status);
			}
		} catch (SQLException e) {
			System.err.println("A felhasználó adatai nem hozzáférhetőek.");
		}
		connection.close();
	}

	public void listOtherUserData(int userId) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listOtherUsers = "SELECT * FROM USER_DATA WHERE USER_ID != '" + userId
				+ "' AND STATUS != 'DELETED' ORDER BY USER_ID ASC";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listOtherUsers);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(4);
				String status = rs.getString(5);
				System.out.println("ID: " + id + ", név: " + name + ", E-mail cím: " + email + ", Státusz: " + status);
			}
		} catch (SQLException e) {
			System.err.println("Adatok megjelenítése sikertelen");
		}
		connection.close();
	}

	public void listUserData(int userId) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listUserData = "SELECT * FROM USER_DATA WHERE USER_ID = '" + userId + "'";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listUserData);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(4);
				String status = rs.getString(5);
				System.out.println("ID: " + id + ", név: " + name + ", E-mail cím: " + email + ", Státusz: " + status);
			}
		} catch (SQLException e) {
			System.err.println("Adatok megjelenítése sikertelen");
		}
		connection.close();
	}

	public String getPassword(int userId) throws SQLException {
		String userPassword = "";
		Connection connection = new JDBCConnection().createConnection();
		String listAll = "SELECT PASSWORD FROM USER_DATA WHERE USER_ID = '" + userId + "'";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listAll);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				String password = rs.getString(1);
				userPassword = password;
			}
		} catch (SQLException e) {
			System.err.println("Adatok megjelenítése sikertelen");
		}
		connection.close();
		return userPassword;
	}

	public String getStatus(int userId) throws SQLException {
		String userStatus = "";
		Connection connection = new JDBCConnection().createConnection();
		String getUserStatus = "SELECT STATUS FROM USER_DATA WHERE USER_ID = '" + userId + "'";
		try (PreparedStatement getUserStatment = connection.prepareStatement(getUserStatus);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				String status = rs.getString(1);
				userStatus = status;
			}
		} catch (SQLException e) {
			System.err.println("Adatok megjelenítése sikertelen");
		}
		connection.close();
		return userStatus;
	}

	public void changeUserData(Scanner sc, int userId, String column) throws SQLException {
		String userInput = getUserInputForChangeUserData(sc, column);
		Connection connection = new JDBCConnection().createConnection();
		String updateUserData = "UPDATE USER_DATA SET " + column + " = '" + userInput + "' WHERE USER_ID = '" + userId
				+ "'";
		try (PreparedStatement getUserUpdateStatement = connection.prepareStatement(updateUserData)) {
			getUserUpdateStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Adatok módosítása sikertelen.");
		}
		connection.close();
	}

	private String getUserInputForChangeUserData(Scanner sc, String column) {
		String userInput = "";
		boolean isValid = false;
		do {
			if (column.equals("PASSWORD")) {
				setPassword(sc);
				userInput = getPassword();
				isValid = true;
			} else if (column.equals("STATUS")) {
				userInput = setStatus(sc);
				isValid = true;
			} else if (column.equals("EMAIL")) {
				setEmail(sc);
				userInput = getEmail();
				isValid = true;
			} else {
				setName(sc);
				userInput = getName();
				isValid = true;
			}
		} while (!isValid);
		return userInput;
	}

	public void listNewUserData() throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listNewUserData = "SELECT * FROM USER_DATA WHERE USER_ID = (SELECT MAX(USER_ID) FROM USER_DATA)";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listNewUserData);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(4);
				String status = rs.getString(5);
				System.out.println("ID: " + id + ", név: " + name + ", E-mail cím: " + email + ", Státusz: " + status);
			}
		} catch (SQLException e) {
			System.err.println("Adatok megjelenítése sikertelen");
		}
		connection.close();
	}

	public boolean checkUserById(int userId) throws SQLException {
		boolean validUser = false;
		Connection connection = new JDBCConnection().createConnection();
		String listNewUserData = "SELECT * FROM USER_DATA WHERE USER_ID = '" + userId + "' AND STATUS != 'DELETED'";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listNewUserData);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(4);
				String status = rs.getString(5);
				System.out.println("ID: " + id + ", név: " + name + ", E-mail cím: " + email + ", Státusz: " + status);
				validUser = true;
			}
			if (!validUser) {
				System.out.println("Nincs ilyen azonosítójú felhasználó!");
			}
		} catch (SQLException e) {
			System.err.println("Adatok megjelenítése sikertelen");
		}
		connection.close();
		return validUser;
	}
}
