import java.sql.SQLException;

import Menu.MainMenu;

public class Main {

	public static void main(String[] args) throws SQLException {
		new Main().run();
	}
	public void run() throws SQLException {
		new MainMenu().menu();
	
	}
}
