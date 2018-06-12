package Property;

public enum Conveniences {
	FULL("Összkomfortos"),OK("Komfortos"),HALF("Félkomfortos"),
	LESS("Komfort nélküli"),NO("Szükséglakás");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private Conveniences(String text) {
		textual = text;
	}
}
