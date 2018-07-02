package JDBC;

import java.sql.SQLException;

import User.Sha256;
import User.UserStatus;

public class CreateAdmin {

	public static void createUser() throws SQLException {
		String name = "admin";
		String password = new Sha256().getSha256("admin");
		String email = "admin@ingatlan.hu";
		new JDBCUser().uploadUser(name, password, email, UserStatus.ACTIVE.toString());
	}
	
}
