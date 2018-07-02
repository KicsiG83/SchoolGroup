package Property;

public enum AdvertisingStatus {
	FORRENT("Kiadó"),
	FORSALE("Eladó"),
	RENTED("Kiadva"),
	SOLD("Eladva"),
	CLOSED("Lezárva");
	
	private String textual;
	
	public String getTextual() {
		return textual;
	}

	private AdvertisingStatus(String text) {
		textual = text;
	}
}
