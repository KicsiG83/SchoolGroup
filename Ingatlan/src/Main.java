import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import JDBC.TestData;
import Menu.MainMenu;
import Menu.UserInterface;
import Property.PropertyType;

public class Main {

	public static void main(String[] args) throws SQLException, MalformedURLException, IOException {
		new Main().run();
	}
	public void run() throws SQLException, MalformedURLException, IOException {
//		new TestData().generate();
		new MainMenu().menu();
		}
}
