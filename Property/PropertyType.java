package Property;

public enum PropertyType {
	HOUSE("Ház"),APARTMENT("Lakás"),OFFICE("Iroda"),PLOT("Telek");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private PropertyType(String text) {
		textual = text;
	}
}
