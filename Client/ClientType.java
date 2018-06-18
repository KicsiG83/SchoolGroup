package Client;

public enum ClientType {
	BUYER("Vásárló"),SELLER("Eladó");
	private String textual;
	private ClientType(String text) {
		textual = text;
	}
	public String getTextual() {
		return textual;
	}
}
