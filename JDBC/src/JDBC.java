import java.sql.SQLException;

public class JDBC {
	
	private String name = "Kitty";
	private String password = "Teszt1234";
	private String email = "tesztEmail@Teszt.hu";
	private String status = "ACTIVE";
	private String clientName = "Micimackó";
	private String clientEmail = "micimacko@szazholdaspagony.hu";
	private String phoneNumber = "36701234567";
	private String type = "Eladó";
	private String comment = "na";
	
	public static void main(String[] args) throws SQLException {
		new JDBC().run();
	}
	
	private void run() throws SQLException {
		JDBCUser.uploadUser(name, password, email, status);
		JDBCClient.uploadClient(clientName, clientEmail, phoneNumber, type, comment);
		JDBCProperty.uploadProperty(1, 1, "Eladó", "Lakás", "1000000", "Budapest", "XI. kerület", "Tétényi út", "1", "FSZ", "1", "Van", "Eladás alatt", "50 nm", "2", "Nincs", "Nincs", "Nincs", "Igen", "2,5", "Felújított", "Blablabla");
		JDBCUser.listAllUserData();
	}
}

