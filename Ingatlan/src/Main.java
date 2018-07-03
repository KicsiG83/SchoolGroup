import java.sql.SQLException;

import JDBC.TestData;
import Menu.MainMenu;

public class Main {

	public static void main(String[] args) throws SQLException {
		new Main().run();
	}
	public void run() throws SQLException {
//		new TestData().generate();
		new MainMenu().menu();
	}
}
