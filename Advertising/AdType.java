package Advertising;

public enum AdType {
	FOR_SALE("Eladó"),
	FOR_RENT("Kiadó");
	
	private String textual;
	
	public String getTextual() {
		return textual;
	}

	private AdType(String text) {
		textual = text;
	}
}
