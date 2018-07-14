package Client;

import Property.*;

public class SearchPreferences {
	private int searchID;
	private int clientID;
	private PropertyType propertyType;
	private int sizeMin;
	private int sizeMax;
	private int priceMin;
	private int priceMax;
	private AdvertisingStatus searchType;
	private City city;
	private String keyWord1;
	private String keyWord2;
	private String keyWord3;

	public SearchPreferences() {
		super();
	}

	public int getSearchID() {
		return searchID;
	}

	public void setSearchID(int searchID) {
		this.searchID = searchID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public int getSizeMin() {
		return sizeMin;
	}

	public void setSizeMin(int sizeMin) {
		this.sizeMin = sizeMin;
	}

	public int getSizeMax() {
		return sizeMax;
	}

	public void setSizeMax(int sizeMax) {
		this.sizeMax = sizeMax;
	}

	public int getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}

	public int getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}

	public AdvertisingStatus getSearchType() {
		return searchType;
	}

	public void setSearchType(AdvertisingStatus searchType) {
		this.searchType = searchType;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getKeyWord1() {
		return keyWord1;
	}

	public void setKeyWord1(String keyWord1) {
		this.keyWord1 = keyWord1;
	}

	public String getKeyWord2() {
		return keyWord2;
	}

	public void setKeyWord2(String keyWord2) {
		this.keyWord2 = keyWord2;
	}

	public String getKeyWord3() {
		return keyWord3;
	}

	public void setKeyWord3(String keyWord3) {
		this.keyWord3 = keyWord3;
	}

	@Override
	public String toString() {
		return "	Az ügyfél mentett keresési adatai: Keresés ID: " + searchID + ", Ügyfél ID: " + clientID + ", Ingatlan típusa: "
				+ propertyType.getTextual() + ", Ingatan méret spektruma: " + sizeMin + " - " + sizeMax + ", Ingatlan ára: " + priceMin
				+ " - " + priceMax + ", Keresett ingatlan hirdetés típusa: " + searchType.getTextual() + ", Város: " + city.getTextual()
				+ ", Kulcsszavak: " + keyWord1 + ", " + keyWord2 + ", " + keyWord3;
	}

}
