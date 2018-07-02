package Property;

public enum Material {
	BRICK("Tégla"),PANEL("Panel"),STONE("Kő"),ADOBE("Vályog"),SHRIVELED_SHUTTER("Csusztatott zsalus");
	public String getTextual() {
		return textual;
	}
	private String textual;
	private Material(String text) {
		textual = text;
	}
}
