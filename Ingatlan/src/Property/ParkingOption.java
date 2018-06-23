package Property;

public enum ParkingOption {
	ON_STREET("Az utcán"),IN_YARD("Az udvaron"),IN_GARAGE("Garázsban");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private ParkingOption(String text) {
		textual = text;
	}
}
