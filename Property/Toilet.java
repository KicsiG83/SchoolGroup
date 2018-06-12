package Property;

public enum Toilet {
	ALONE("Külön helységben"),IN_BATHROOM("A fürdőben");
	public String getTextual() {
		return textual;
	}
	private String textual;
	private Toilet(String text) {
		textual = text;
	}
}
