import java.sql.SQLException;

import com.itextpdf.text.Document;

import Document.CreateDocument;
import Document.DocumentTemplate;
import Email.Email;
import Menu.MainMenu;
import JDBC.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		new Main().run();
//		Email.sendMail();
		
	}
	public void run() throws SQLException {
//		new MainMenu().menu();
//		new CreateDocument().createPDF(DocumentTemplate.SALE);
	new TestData().generate();
	}
}
