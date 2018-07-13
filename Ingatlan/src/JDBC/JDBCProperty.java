package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Property.*;

public class JDBCProperty {

	public void uploadProperty(Property property) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String upload = "INSERT INTO PROPERTY VALUES (PROPERTY_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement propertyStatement = connection.prepareStatement(upload)) {
			propertyStatement.setInt(1, property.getClientID());
			propertyStatement.setInt(2, property.getUserID());
			propertyStatement.setString(3, property.getPropertyType().getTextual());
			propertyStatement.setInt(4, property.getSize());
			propertyStatement.setInt(5, property.getGroundSize());
			propertyStatement.setInt(6, property.getNumberOfRooms());
			propertyStatement.setInt(7, property.getNumberOfHalfRooms());
			propertyStatement.setInt(8, property.getPrice());
			propertyStatement.setString(9, property.getStreetAndNumber());
			propertyStatement.setString(10, property.getCity().getTextual());
			propertyStatement.setString(11, property.getMaterial().getTextual());
			propertyStatement.setString(12, property.getWc().getTextual());
			propertyStatement.setString(13, property.getLevel().getTextual());
			propertyStatement.setString(14, property.getCondition().getTextual());
			propertyStatement.setString(15, property.getDescription());
			propertyStatement.setString(16, property.getStatus().getTextual());
			propertyStatement.setInt(17, property.getCountNUmber());
			propertyStatement.addBatch();
			propertyStatement.executeBatch();
		} catch (SQLException e) {
			System.err.println("Sikertelen feltöltés");
		}
		
		connection.close();
	}

	public ArrayList<Property> getAllProperty() throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		ArrayList<Property> propertyList = new ArrayList<Property>();
		
		String listNewPropertyData = "SELECT * FROM PROPERTY";
		try (PreparedStatement getPropertyStatment = connection.prepareStatement(listNewPropertyData);
				ResultSet rs = getPropertyStatment.executeQuery()) {
			while (rs.next()) {
				Property prop = new Property();
				prop.setPropertyID(rs.getInt(1));
				prop.setClientID(rs.getInt(2));
				prop.setUserID(rs.getInt(3));
				PropertyType type = getPropertyType(rs.getString(4));
				prop.setPropertyType(type);
				prop.setSize(rs.getInt(5));
				if(type == PropertyType.HOUSE || type == PropertyType.OFFICE) {
					prop.setGroundSize(rs.getInt(6));
				}
				prop.setNumberOfRooms(rs.getInt(7));
				prop.setNumberOfHalfRooms(rs.getInt(8));
				prop.setPrice(rs.getInt(9));
				prop.setStreetAndNumber(rs.getString(10));
				City city = getCity(rs.getString(11));
				prop.setCity(city);
				prop.setMaterial(getMaterial(rs.getString(12)));
				Toilet wc = rs.getString(13).equals("Külön helységben") ? Toilet.ALONE : Toilet.IN_BATHROOM;
				prop.setWc(wc);
				EnergeticLevel level = getLevel(rs.getString(14));
				prop.setLevel(level);
				PropertyCondition condition = getCondition(rs.getString(15));
				prop.setCondition(condition);
				prop.setDescription(rs.getString(16));
				AdvertisingStatus status = getStatus(rs.getString(17));
				prop.setStatus(status);
				prop.setCountNUmber(rs.getInt(18));
				propertyList.add(prop);
			}
		} catch (SQLException e) {
			System.err.println("Az ingatlanok adatai nem hozzáférhetők");
		}
		connection.close();		
		return propertyList;
	}

	public Property getLastProperty() throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listNewPropertyData = "SELECT * FROM PROPERTY WHERE PROPERTY_ID = (SELECT MAX(PROPERTY_ID) FROM PROPERTY)";
		Property prop = new Property();
		try (PreparedStatement getPropertyStatment = connection.prepareStatement(listNewPropertyData);
				ResultSet rs = getPropertyStatment.executeQuery()) {
			while (rs.next()) {
				prop.setPropertyID(rs.getInt(1));
				prop.setClientID(rs.getInt(2));
				prop.setUserID(rs.getInt(3));
				PropertyType type = getPropertyType(rs.getString(4));
				prop.setPropertyType(type);
				prop.setSize(rs.getInt(5));
				if(type == PropertyType.HOUSE || type == PropertyType.OFFICE) {
					prop.setGroundSize(rs.getInt(6));
				}
				prop.setNumberOfRooms(rs.getInt(7));
				prop.setNumberOfHalfRooms(rs.getInt(8));
				prop.setPrice(rs.getInt(9));
				prop.setStreetAndNumber(rs.getString(10));
				City city = getCity(rs.getString(11));
				prop.setCity(city);
				prop.setMaterial(getMaterial(rs.getString(12)));
				Toilet wc = rs.getString(13).equals("Külön helységben") ? Toilet.ALONE : Toilet.IN_BATHROOM;
				prop.setWc(wc);
				EnergeticLevel level = getLevel(rs.getString(14));
				prop.setLevel(level);
				PropertyCondition condition = getCondition(rs.getString(15));
				prop.setCondition(condition);
				prop.setDescription(rs.getString(16));
				AdvertisingStatus status = getStatus(rs.getString(17));
				prop.setStatus(status);
				prop.setCountNUmber(rs.getInt(18));
			}
		} catch (SQLException e) {
			System.err.println("Az ingatlan adatai nem hozzáférhetők");
		}
		connection.close();
		return prop;
	}

	public AdvertisingStatus getStatus(String string) {
		switch(string) {
		case "Eladó":
			return AdvertisingStatus.FORSALE;
		case "Eladva":
			return AdvertisingStatus.SOLD;
		case "Kiadva":
			return AdvertisingStatus.RENTED;
		case "Kiadó":
			return AdvertisingStatus.FORRENT;
		case "Lezárva":
			return AdvertisingStatus.CLOSED;
		default:
			return null;
		}
	}

	private PropertyCondition getCondition(String string) {
		switch(string) {
		case "Új":
			return PropertyCondition.NEW;
		case "Újszerű":
			return PropertyCondition.NEWSY;
		case "Felújított":
			return PropertyCondition.RENOVATED;
		case "Jó":
			return PropertyCondition.GOOD;
		case "Közepes":
			return PropertyCondition.MID;
		case "Felújítandó":
			return PropertyCondition.BAD;
		case "Befejezetlen":
			return PropertyCondition.UNDER_CONDTRUCTION;		
		default:
			return null;
		}
	}

	private EnergeticLevel getLevel(String string) {
		switch(string) {
		case "A":
			return EnergeticLevel.A;
		case "B":
			return EnergeticLevel.B;
		case "C":
			return EnergeticLevel.C;
		case "D":
			return EnergeticLevel.D;
		default:
			return null;
		}
	}

	private Material getMaterial(String string) {
		switch(string) {
		case "Tégla":
			return Material.BRICK;
		case "Panel":
			return Material.PANEL;
		case "Kő":
			return Material.STONE;
		case "Vályog":
			return Material.ADOBE;
		case "Csusztatott zsalus":
			return Material.SHRIVELED_SHUTTER;
		default:
			return null;
		}
	}

	public City getCity(String string) {
		switch(string) {
		case "Budapest":
			return City.BP;
		case "Szeged":
			return City.SZEGED;
		case "Pécs":
			return City.PECS;
		case "Siófok":
			return City.SIOFOK;
		case "Győr":
			return City.GYOR;
		default:
			return City.OTHER;
		}
		
	}

	public PropertyType getPropertyType(String string) {
		switch(string) {
		case "Ház":
			return PropertyType.HOUSE;
		case "Lakás":
			return PropertyType.APARTMENT;
		case "Iroda":
			return PropertyType.OFFICE;
		case "Telek":
			return PropertyType.PLOT;
		default:
			return null;
		}
			
	}
	public void runSetterQuery(String query) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		try (PreparedStatement getPropertyStatment = connection.prepareStatement(query);
				/*ResultSet rs = getPropertyStatment.executeQuery()*/) {
			getPropertyStatment.addBatch();
			getPropertyStatment.executeBatch();
		}
		catch (SQLException e) {
			System.err.println("A módisítás sikertelen.");
		}
		connection.close();
		return;
	}
	public ArrayList<Property> runGetterQuery(String query) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		ArrayList<Property> propertyList = new ArrayList<Property>();
		try (PreparedStatement getPropertyStatment = connection.prepareStatement(query);
				ResultSet rs = getPropertyStatment.executeQuery()) {
			while (rs.next()) {
				Property prop = new Property();
				prop.setPropertyID(rs.getInt(1));
				prop.setClientID(rs.getInt(2));
				prop.setUserID(rs.getInt(3));
				PropertyType type = getPropertyType(rs.getString(4));
				prop.setPropertyType(type);
				prop.setSize(rs.getInt(5));
				if(type == PropertyType.HOUSE || type == PropertyType.OFFICE) {
					prop.setGroundSize(rs.getInt(6));
				}
				prop.setNumberOfRooms(rs.getInt(7));
				prop.setNumberOfHalfRooms(rs.getInt(8));
				prop.setPrice(rs.getInt(9));
				prop.setStreetAndNumber(rs.getString(10));
				City city = getCity(rs.getString(11));
				prop.setCity(city);
				prop.setMaterial(getMaterial(rs.getString(12)));
				Toilet wc = rs.getString(13).equals("Külön helységben") ? Toilet.ALONE : Toilet.IN_BATHROOM;
				prop.setWc(wc);
				EnergeticLevel level = getLevel(rs.getString(14));
				prop.setLevel(level);
				PropertyCondition condition = getCondition(rs.getString(15));
				prop.setCondition(condition);
				prop.setDescription(rs.getString(16));
				AdvertisingStatus status = getStatus(rs.getString(17));
				prop.setStatus(status);
				prop.setCountNUmber(rs.getInt(18));
				propertyList.add(prop);
			}
		} catch (SQLException e) {
			System.err.println("Ingatlan(ok) adatai nem hozzáférhetők.");
		}
		connection.close();		
		return propertyList;
	}
	
	public int getUserIdByPropertyId(int propertyId) throws SQLException {
		int userId = 0;
		Connection connection = new JDBCConnection().createConnection();
		String listNewPropertyData = "SELECT USER_ID FROM PROPERTY WHERE PROPERTY_ID = '" + propertyId + "'";
		try (PreparedStatement getPropertyStatment = connection.prepareStatement(listNewPropertyData);
				ResultSet rs = getPropertyStatment.executeQuery()) {
			while (rs.next()) {
				userId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return userId;
	}

	public Property getPropertyById(int propertyId) throws SQLException {
		Connection connection = new JDBCConnection().createConnection();
		String listNewPropertyData = "SELECT * FROM PROPERTY WHERE PROPERTY_ID = '" + propertyId +"'";
		Property prop = new Property();
		try (PreparedStatement getPropertyStatment = connection.prepareStatement(listNewPropertyData);
				ResultSet rs = getPropertyStatment.executeQuery()) {
			while (rs.next()) {
				prop.setPropertyID(rs.getInt(1));
				prop.setClientID(rs.getInt(2));
				prop.setUserID(rs.getInt(3));
				PropertyType type = getPropertyType(rs.getString(4));
				prop.setPropertyType(type);
				prop.setSize(rs.getInt(5));
				if(type == PropertyType.HOUSE || type == PropertyType.OFFICE) {
					prop.setGroundSize(rs.getInt(6));
				}
				prop.setNumberOfRooms(rs.getInt(7));
				prop.setNumberOfHalfRooms(rs.getInt(8));
				prop.setPrice(rs.getInt(9));
				prop.setStreetAndNumber(rs.getString(10));
				City city = getCity(rs.getString(11));
				prop.setCity(city);
				prop.setMaterial(getMaterial(rs.getString(12)));
				Toilet wc = rs.getString(13).equals("Külön helységben") ? Toilet.ALONE : Toilet.IN_BATHROOM;
				prop.setWc(wc);
				EnergeticLevel level = getLevel(rs.getString(14));
				prop.setLevel(level);
				PropertyCondition condition = getCondition(rs.getString(15));
				prop.setCondition(condition);
				prop.setDescription(rs.getString(16));
				AdvertisingStatus status = getStatus(rs.getString(17));
				prop.setStatus(status);
				prop.setCountNUmber(rs.getInt(18));
			}
		} catch (SQLException e) {
			System.err.println("Could not list data!");
		}
		connection.close();
		return prop;
	}
	
}
