package Address;

public enum Street {
	PETOFI("Petőfi Sándor"),KOSSUTH("Kossuth Lajos"),JOZSEFA("József Attila"),
	FO("Fő"),ARANYJ("Arany János"),RAKOCZI("II. Rákoczi Ferenc");
	
	private String textual;
	public String getTextual() {
		return textual;
	}
	private Street(String text) {
		textual = text;
	}
}
