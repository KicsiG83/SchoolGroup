package Address;

public enum StreetType {
	PIT("árok"),ALLEY("átjáró"),ACCOMMODATION_ROAD("dűlőút"),
	AVENUE("fasor"),TURN("forduló"),RAMPART("gát"),BORDER_LINE("határút"),
	GATE("kapu"),CIRCUS("körtér"),CIRCUIT("körút"),	ALLEY_WAY("köz"),
	WARREN("lakótelep"),STAIRWAY("lépcső"),GROVE("liget"),
	PARK("park"),HARBOUR("rakpart"),LINE("sor"),BOULVARD("sugárút"),
	SQUARE("tér"),YARD("udvar"),ROAD("út"),STREET("utca");
	
	private String textual;
	public String getTextual() {
		return textual;
	}
	private StreetType(String text) {
		textual = text;
	}
}
