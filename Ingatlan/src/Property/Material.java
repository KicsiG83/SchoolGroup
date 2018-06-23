package Property;

public enum Material {
	BRICK("Tégla"),PANEL("Panel"),STONE("Kő"),ADOBE("Vályog");
	public String getTextual() {
		return textual;
	}
	private String textual;
	private Material(String text) {
		textual = text;
	}
}
