package Property;

public enum EnergeticLevel {
	A("A"),B("B"),C("C"),D("D");
	
private String textual;
	
	public String getTextual() {
		return textual;
	}

	private EnergeticLevel(String text) {
		textual = text;
	}
}
