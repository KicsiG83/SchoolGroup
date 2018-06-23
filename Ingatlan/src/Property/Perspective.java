package Property;

public enum Perspective {
	TO_STREET("Utcára néző"),TO_GARDEN("Kertre néző"),
	TO_COURTYARD("Udvarra néző"),PANORAMA("Panorámás");
	public String getTextual() {
		return textual;
	}
	private String textual;
	private Perspective(String text) {
		textual = text;
	}
}
