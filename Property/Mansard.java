package Property;

public enum Mansard {
	EGZIST("Beépíthető"),NONE("Nincs"),BUILDED("Beépített");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private Mansard(String text) {
		textual = text;
	}
}
