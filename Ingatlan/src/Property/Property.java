package Property;

import java.io.IOException;

import Price.CurrencyDownload;

public class Property {
	private int propertyID;
	private int clientID;
	private int userID;
	private PropertyType propertyType;
	private int size; // négyzetméterben
	private int groundSize = 0; // csak ház és irodánál nem nulla
	private int numberOfRooms;
	private int numberOfHalfRooms;
	private int price; // a DB-ben forintban tároljuk, ha vki eur-ban adja meg, átszámáljuk.
	private String streetAndNumber;
	private City city;
	private Material material; // anyag
	private Toilet wc;
	private EnergeticLevel level;
	private PropertyCondition condition;
	private String description;
	private AdvertisingStatus status;
	private int countNUmber; // megtekintések száma, a DB-ben így hívják
	/*
	 * private String pic1; private String pic2; private String pic3;
	 */

	public Property() {
	}

	public Property(int propertyID, int clientID, int userID, PropertyType propertyType, int size, int groundSize,
			int numberOfRooms, int numberOfHalfRooms, int price, String streetAndNumber, City city, Material material,
			Toilet wc, EnergeticLevel level, PropertyCondition condition, String description, AdvertisingStatus status,
			int countNUmber) {
		super();
		this.propertyID = propertyID;
		this.clientID = clientID;
		this.userID = userID;
		this.propertyType = propertyType;
		this.size = size;
		this.groundSize = groundSize;
		this.numberOfRooms = numberOfRooms;
		this.numberOfHalfRooms = numberOfHalfRooms;
		this.price = price;
		this.streetAndNumber = streetAndNumber;
		this.city = city;
		this.material = material;
		this.wc = wc;
		this.level = level;
		this.condition = condition;
		this.description = description;
		this.status = status;
		this.countNUmber = countNUmber;
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getGroundSize() {
		return groundSize;
	}

	public void setGroundSize(int groundSize) {
		this.groundSize = groundSize;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfHalfRooms() {
		return numberOfHalfRooms;
	}

	public void setNumberOfHalfRooms(int numberOfHalfRooms) {
		this.numberOfHalfRooms = numberOfHalfRooms;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Toilet getWc() {
		return wc;
	}

	public void setWc(Toilet wc) {
		this.wc = wc;
	}

	public EnergeticLevel getLevel() {
		return level;
	}

	public void setLevel(EnergeticLevel level) {
		this.level = level;
	}

	public PropertyCondition getCondition() {
		return condition;
	}

	public void setCondition(PropertyCondition condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AdvertisingStatus getStatus() {
		return status;
	}

	public void setStatus(AdvertisingStatus status) {
		this.status = status;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCountNUmber() {
		return countNUmber;
	}

	public void setCountNUmber(int countNUmber) {
		this.countNUmber = countNUmber;
	}

	@Override
	public String toString() {
		double oneEuro = 1;
		try {
			oneEuro = new CurrencyDownload().valueOfOneEURinHUF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Property [propertyID=" + propertyID + ", clientID=" + clientID + ", userID=" + userID
				+ ", propertyType=" + propertyType.getTextual() + ", size=" + size + ", groundSize=" + groundSize
				+ ", numberOfRooms=" + numberOfRooms + ", numberOfHalfRooms=" + numberOfHalfRooms + ", " + "price(HUF)="
				+ price + ", price(EUR)=" + (int) (price / oneEuro) + ", streetAndNumber=" + streetAndNumber + ", city="
				+ city.getTextual() + ", material=" + material.getTextual() + ", wc=" + wc.getTextual() + ", level="
				+ level.getTextual() + ", condition=" + condition.getTextual() + ", description=" + description
				+ ", status=" + status.getTextual() + ", countNUmber=" + countNUmber + "]";
	}

}
