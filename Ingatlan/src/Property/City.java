package Property;

public enum City {
	BP("Budapest"),SZEGED("Szeged"),PECS("Pécs"),SIOFOK("Siófok"),GYOR("Győr"),OTHER("Egyéb");
	
private String textual;
	
	public String getTextual() {
		return textual;
	}

	private City(String text) {
		textual = text;
	}
}
