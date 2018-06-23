package Property;

public enum BuildingSiting {
	N("Északi"),NE("Észak-Keleti"),E("Keleti"),SE("Dél-Keleti"),
	D("Déli"),DW("Dél-Nyugati"),W("Nyugati"),NW("Észak-Nyugati");
	
	public String getTextual() {
		return textual;
	}
	private String textual;
	private BuildingSiting(String text) {
		textual = text;
	}
}
