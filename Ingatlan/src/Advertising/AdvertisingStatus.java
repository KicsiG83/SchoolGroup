package Advertising;

public enum AdvertisingStatus {
	OPEN("Elérhető"),
	FREEZED("Foglalózott"),
	CLOSED("Lezárt");
	
	private String textual;
	
	public String getTextual() {
		return textual;
	}

	private AdvertisingStatus(String text) {
		textual = text;
	}
}
