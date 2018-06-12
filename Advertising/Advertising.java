package Advertising;

import Price.Price;
import Property.Property;
import User.User;
import Client.Client;

public class Advertising {
	private int advertisingID;
	private int searchCounter;
	private Property property;
	private Client client;
	private User user;
	private AdvertisingStatus actualStatus;
	private Price price;
	private AdType adType;
	public int getAdvertisingID() {
		return advertisingID;
	}
	public int getSearchCounter() {
		return searchCounter;
	}
	public Property getProperty() {
		return property;
	}
	public Client getClient() {
		return client;
	}
	public User getUser() {
		return user;
	}
	public AdvertisingStatus getActualStatus() {
		return actualStatus;
	}
	public Price getPrice() {
		return price;
	}
	public AdType getAdType() {
		return adType;
	}
	public void setAdvertisingID(int advertisingID) {
		this.advertisingID = advertisingID;
	}
	public void setSearchCounter(int searchCounter) {
		this.searchCounter = searchCounter;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setActualStatus(AdvertisingStatus actualStatus) {
		this.actualStatus = actualStatus;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public void setAdType(AdType adType) {
		this.adType = adType;
	}
	public Advertising(int advertisingID, int searchCounter, Property property, Client client, User user, AdvertisingStatus actualStatus, Price price, AdType adType) {
		this.advertisingID = advertisingID;
		this.searchCounter = searchCounter;
		this.property = property;
		this.client = client;
		this.user = user;
		this.actualStatus = actualStatus;
		this.price = price;
		this.adType = adType;
	}
	
}
