package Address;

public class Address {
	{
		country = Country.HUN;
	}
	
	public int getPostcode() {
		return postcode;
	}

	public Country getCountry() {
		return country;
	}

	public City getCity() {
		return city;
	}

	public Street getNameOfStreet() {
		return nameOfStreet;
	}

	public StreetType getTypeOfStreet() {
		return typeOfStreet;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getBlock() {
		return block;
	}

	public String getFloor() {
		return floor;
	}

	public String getDoor() {
		return door;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setNameOfStreet(Street nameOfStreet) {
		this.nameOfStreet = nameOfStreet;
	}

	public void setTypeOfStreet(StreetType typeOfStreet) {
		this.typeOfStreet = typeOfStreet;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setDoor(String door) {
		this.door = door;
	}
	/**
	 * Kötelezően meganadndó mezők
	 */
	private Country country;
	private City city;
	private int postcode;
	private Street nameOfStreet;
	private StreetType typeOfStreet;
	private String streetNumber;
	
	public Address(Country country, City city, int postcode, Street nameOfStreet, StreetType typeOfStreet, String streetNumber) {
		this(city);
		this.country = country;
		this.postcode = postcode;
		this.nameOfStreet = nameOfStreet;
		this.typeOfStreet = typeOfStreet;
		this.streetNumber = streetNumber;
	}
	/**
	 * nem kötelező
	 */
	private String block;
	private String floor;
	private String door;
	
	public Address(City city) {
		this.city = city;
		this.postcode = city.getPostCode();
	}
}
