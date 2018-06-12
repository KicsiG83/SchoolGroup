package User;

public class User { //a jelszót titkosítja, majd az így kapott karakterláncot tárolja el
	private int userId;
	private String name;
	private String email;
	private String password;
	UserStatus status;
	
	public User(int userId, String name, String email, String password) {
	    this.userId = userId; //DB-ből kell lekérdezni a legnagyobb userId értéket, ettől eggyel magasabb számot kell adni az új usernek
		this.name = name;
		this.email = email;
		this.password = new Sha256().getSha256(password);
		this.status = UserStatus.ACTIVE;
	}

	public int getUserId() { //nincs setter, az új user felvételekor kaphat csak a felhasználó ID-t
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) { //nincs getter, a jelszót nem kérdezheti le senki
		this.password = new Sha256().getSha256(password);
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}	
	
	public String toString() {
		return userId + ", " + name + ", " + email + ", " + password + ", " + status.en;
	}
	
}
