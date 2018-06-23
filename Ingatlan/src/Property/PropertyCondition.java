package Property;

public enum PropertyCondition {
	NEW("Új"),NEWSY("Újszerű"),RENOVATED("Felújított"),GOOD("Jó"),
	MID("Közepes"),BAD("Felújítandó"),
	UNDER_CONDTRUCTION("Befejezetlen");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private PropertyCondition(String text) {
		textual = text;
	}
}
