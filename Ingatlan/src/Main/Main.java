package Main;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import Menu.MainMenu;


public class Main {

	public static void main(String[] args) throws SQLException, MalformedURLException, IOException {
		new Main().run();
	}
	public void run() throws SQLException, MalformedURLException, IOException {
		new MainMenu().menu();
	}
}
