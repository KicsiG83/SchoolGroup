package Property;

import Address.Address;

public class Property {
	/**
	 * Kötelezően megadandó mezők
	 */
	private int propertyID;
	private Address address;
	private PropertyType propertyType;
	private boolean elevator;
	private String description;
	private boolean balcony;
	private boolean airConditioned;
	private double heigth; // méterben
	private int size; // négyzetméterben
	private int numberOfRooms;

	public Property(int propertyID, Address address, PropertyType propertyType, boolean elevator, String description,
			boolean balcony, boolean airConditioned, double heigth, int size, int numberOfRooms) {
		this.propertyID = propertyID;
		this.address = address;
		this.propertyType = propertyType;
		this.elevator = elevator;
		this.description = description;
		this.balcony = balcony;
		this.airConditioned = airConditioned;
		this.heigth = heigth;
		this.size = size;
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * Nem kötelező megadni
	 */
	private PropertyCondition condition;
	private boolean garden;
	private Perspective view;
	private BuildingSiting siting;
	private HeatingType heating;
	private ParkingOption parking;
	private Conveniences conveniences;
	private Mansard attic;
	private Toilet wc;
	private Material material;

	public int getPropertyID() {
		return propertyID;
	}

	public Address getAddress() {
		return address;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public boolean isElevator() {
		return elevator;
	}

	public String getDescription() {
		return description;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public boolean isAirConditioned() {
		return airConditioned;
	}

	public double getHeigth() {
		return heigth;
	}

	public int getSize() {
		return size;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public PropertyCondition getCondition() {
		return condition;
	}

	public boolean isGarden() {
		return garden;
	}

	public Perspective getView() {
		return view;
	}

	public BuildingSiting getSiting() {
		return siting;
	}

	public HeatingType getHeating() {
		return heating;
	}

	public ParkingOption getParking() {
		return parking;
	}

	public Conveniences getConveniences() {
		return conveniences;
	}

	public Mansard getAttic() {
		return attic;
	}

	public Toilet getWc() {
		return wc;
	}

	public Material getMaterial() {
		return material;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public void setAirConditioned(boolean airConditioned) {
		this.airConditioned = airConditioned;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public void setCondition(PropertyCondition condition) {
		this.condition = condition;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public void setView(Perspective view) {
		this.view = view;
	}

	public void setSiting(BuildingSiting siting) {
		this.siting = siting;
	}

	public void setHeating(HeatingType heating) {
		this.heating = heating;
	}

	public void setParking(ParkingOption parking) {
		this.parking = parking;
	}

	public void setConveniences(Conveniences conveniences) {
		this.conveniences = conveniences;
	}

	public void setAttic(Mansard attic) {
		this.attic = attic;
	}

	public void setWc(Toilet wc) {
		this.wc = wc;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
