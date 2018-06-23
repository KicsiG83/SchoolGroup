package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Client.Validation;
import User.Sha256;

public class JDBCUser {

	public static void uploadUser(String name, String password, String email, String status) throws SQLException {
		String[] userColumns = { name, password, email, status };
		Connection connection = JDBCConnection.createConnection();
		String upload = "INSERT INTO USER_DATA VALUES (user_seq.nextval, ?, ?, ?, ?)";
		try (PreparedStatement userStatement = connection.prepareStatement(upload)) {
			for (int i = 1; i <= userColumns.length; i++) {
				userStatement.setString(i, userColumns[i - 1]);
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
			System.err.println("Could not list data!");
		}
		connection.close();
	}

	public static void listOtherUserData(int userId) throws SQLException {
		Connection connection = JDBCConnection.createConnection();
		String listOtherUsers = "SELECT * FROM USER_DATA WHERE USER_ID != '" + userId + "' ORDER BY USER_ID ASC";
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
			System.err.println("Could not list data!");
		}
		connection.close();
	}

	public static void listUserData(int userId) throws SQLException {
		Connection connection = JDBCConnection.createConnection();
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
			System.err.println("Could not list data!");
		}
		connection.close();
	}

	public static String getPassword(int userId) throws SQLException {
		String userPassword = "";
		Connection connection = JDBCConnection.createConnection();
		String listAll = "SELECT PASSWORD FROM USER_DATA WHERE USER_ID = '" + userId + "'";
		try (PreparedStatement getUserStatment = connection.prepareStatement(listAll);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				String password = rs.getString(1);
				userPassword = password;
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return userPassword;
	}

	public static String getStatus(int userId) throws SQLException {
		String userStatus = "";
		Connection connection = JDBCConnection.createConnection();
		String getUserStatus = "SELECT STATUS FROM USER_DATA WHERE USER_ID = '" + userId + "'";
		try (PreparedStatement getUserStatment = connection.prepareStatement(getUserStatus);
				ResultSet rs = getUserStatment.executeQuery()) {
			while (rs.next()) {
				String status = rs.getString(1);
				userStatus = status;
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return userStatus;
	}

	public static void changeUserData(Scanner sc, int userId, String column) throws SQLException {
		String userInput = getUserInputForChangeUserData(sc, column);
		Connection connection = JDBCConnection.createConnection();
		String updateUserData = "UPDATE USER_DATA SET " + column + " = '" + userInput + "' WHERE USER_ID = '" + userId
				+ "'";
		try (PreparedStatement getUserUpdateStatement = connection.prepareStatement(updateUserData)) {
			getUserUpdateStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Could not upload to database!");
		}
		connection.close();
	}

	private static String getUserInputForChangeUserData(Scanner sc, String column) {
		String userInput = "";
		boolean isValid = false;
		do {
			if (column.equals("STATUS")) {
				System.out.println("\nFelhasználói státuszok:\n- Aktív\n- Blokkolt\n- Törölt\n");
			}
			System.out.print("\nKérem adja meg az új adatot: ");
			String input = sc.nextLine();
			if (column.equals("PASSWORD")) {
				userInput = new Sha256().getSha256(input);
				isValid = true;
			} else if (column.equals("STATUS")) {
				if (input.equals("Aktív")) {
					isValid = true;
					userInput = "ACTIVE";
				} else if (input.equals("Blokkolt")) {
					userInput = "BLOCKED";
					isValid = true;
				} else if (input.equals("Törölt")) {
					userInput = "DELETED";
					isValid = true;
				} else {
					System.out.println(
							"A megadott státsz ismeretlen.\nKérem válasszon az alábbiak közül: \n- Aktív\n- Blokkolt\n- Törölt\n");
				}
			} else if (column.equals("EMAIL")) {
				boolean result = Validation.isValidEmailAddress(input);
				if (result) {
					userInput = input;
					isValid = true;
				} else {
					System.out.println("A megadott e-mail cím érvénytelen.");
				}
			} else {
				userInput = input;
				isValid = true;
			}
		} while (!isValid);
		return userInput;
	}

	public static void listNewUserData() throws SQLException {
		Connection connection = JDBCConnection.createConnection();
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
			System.err.println("Could not list data!");
		}
		connection.close();
	}
}
