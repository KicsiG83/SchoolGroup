import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import com.itextpdf.text.Document;

import Document.CreateDocument;
import Document.DocumentTemplate;
import Email.Email;
import Menu.MainMenu;
import Menu.UserInterface;
import Property.PropertyType;
import JDBC.*;

public class Main {

	public static void main(String[] args) throws SQLException, MalformedURLException, IOException {
		new Main().run();
	}
	public void run() throws SQLException {
		new MainMenu().menu();

	}
}
