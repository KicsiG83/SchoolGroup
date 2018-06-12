package Property;

public enum HeatingType {
	CENTRAL("Központi fűtés"),OIL_HEATER("Olajradiátoros"),
	GAS_CONVECTOR("Gáz konvektoros"),WATER_CIRCULATING("Cirkó"),
	FLOOR_HEATING("Padlófűtés"),FIREPLACE("Kandallós");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private HeatingType(String text) {
		textual = text;
	}
}
