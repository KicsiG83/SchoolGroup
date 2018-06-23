package Address;

public enum Country {
	HUN("Magyarország");
	
	private String textual;
		
	public String getTextual() {
		return textual;
	}

	private Country(String text) {
		textual = text;
	}
}
