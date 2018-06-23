package User;

public enum UserStatus {
	ACTIVE("Aktív", "Active"), // User can log in
	BLOCKED("Felfüggesztve", "Blocked"), // Prohibited to check in for a while for some reason
	DELETED("Törölt", "Deleted"); // User works no more for the agency

	String hu, en;

	UserStatus(String hu, String en) {
		this.hu = hu;
		this.en = en;
	}
}
