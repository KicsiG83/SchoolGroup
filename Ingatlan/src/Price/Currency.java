package Price;

public enum Currency {
	HUF("Forint"),EU("Euro");
private String textual;
	
	public String getTextual() {
		return textual;
	}

	private Currency(String text) {
		textual = text;
	}
}
