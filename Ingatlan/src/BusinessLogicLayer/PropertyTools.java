package BusinessLogicLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.JDBCProperty;
import Property.Property;

public class PropertyTools {
	private JDBCProperty jdbcProperty = new JDBCProperty();
	
	public void addPropertyToDB(Property property) throws SQLException {
		jdbcProperty.uploadProperty(property);
	}
	public ArrayList<Property> getPropertyListFromDB() throws SQLException {
		ArrayList<Property> propertyListfromDB = new ArrayList<Property>();
		propertyListfromDB = jdbcProperty.getAllProperty();
		return propertyListfromDB;
	}
	public Property getLastProperty() throws SQLException {
		return jdbcProperty.getLastProperty();
	}
	public Property getPropertyWithPropertyID(int propID) throws SQLException {
		String query = "SELECT * FROM PROPERTY WHERE PROPERTY_ID="+propID;
		ArrayList<Property> resultList = jdbcProperty.runGetterQuery(query);
		if(resultList.size() == 0) {
			return null;
		} else  {
			return resultList.get(0);
		}
	}
	public ArrayList<Property> search(String searchClientID, String searchUserID, String searchPropertyType, String searchSizeMin,
			String searchSizeMax, String searchRoomNumberMin, String searchPriceMin, String searchPriceMax,
			String searchCity, String searchMaterial, String searchToilet, String searchLevel, String searchCondition,
			String searchDescription, String searchStatus) throws SQLException {
		String query = "SELECT * FROM PROPERTY WHERE";
		String querySeparator = " AND ";
		if(!searchClientID.equals("")) {
			String queryClientID = " CLIENT_ID = " + searchClientID;
			query = query + queryClientID + querySeparator;
		}
		if(!searchUserID.equals("")) {
			String qeryUserID = " USER_ID = " + searchUserID;
			query = query  + qeryUserID + querySeparator;
		}
		if(!searchPropertyType.equals("")) {
			String queryPropertyType = " PROPERTY_TYPE LIKE '" + searchPropertyType + "'";
			query = query + queryPropertyType + querySeparator ;
		}
		try {
			Integer.parseInt(searchSizeMin);
			Integer.parseInt(searchSizeMax);
			if(!searchSizeMax.equals("0")) {
				String querySize = " (PROPERTY_SIZE > " + searchSizeMin + querySeparator + "PROPERTY_SIZE < " + searchSizeMax + ")";
				query = query + querySize + querySeparator ;
			}
		} catch(Exception e) {}
		try {
			Integer.parseInt(searchRoomNumberMin);
			String queryRooms = " NUMBER_OF_ROOMS > " + searchRoomNumberMin;
			query = query + queryRooms + querySeparator ;
		} catch(Exception e) {}
		try {
			Integer.parseInt(searchPriceMin);
			Integer.parseInt(searchPriceMax);
			if(!searchPriceMax.equals("0")) {
				String queryPrice = " (PRICE > " + searchPriceMin + querySeparator + "PRICE < " + searchPriceMax + ")";
				query = query + queryPrice + querySeparator;
			}
		} catch(Exception e) {}
		if(!searchCity.equals("")) {
			String queryCity = " CITY LIKE '" + searchCity + "'";
			query = query  + queryCity + querySeparator;
		}
		if(!searchMaterial.equals("")) {
			String queryMaterial = " MATERIAL LIKE '" + searchMaterial + "'";
			query = query + queryMaterial + querySeparator;
		}
		if(!searchToilet.equals("")) {
			String queryToilet = " WC LIKE '" + searchToilet + "'";
			query = query + queryToilet + querySeparator;
		}
		if(!searchLevel.equals("")) {
			String queryLevel = " ENERGETIC_LEVEL LIKE '" + searchLevel + "'";
			query = query + queryLevel + querySeparator;
		}
		if(!searchCondition.equals("")) {
			String queryCondition = " PROPERTY_CONDITION LIKE '" + searchCondition + "'";
			query = query + queryCondition + querySeparator;
		}
		if(!searchStatus.equals("")) {
			String queryStatus = " AD_STATUS LIKE '" + searchStatus + "'";
			query = query + queryStatus + querySeparator;
		}
		if(!searchDescription.equals("")) {
			String queryDescription = " DESCRIPTION LIKE '%" +  searchDescription +"%'";
			query = query  + queryDescription + querySeparator;
		}
		int n = query.length();
		String str = "";
		for(int i=0;i<n-5;i++) {
			str = str + query.charAt(i);
		}
		ArrayList<Property> result = jdbcProperty.runGetterQuery(str);
		return result;
	}
	public void increaseViews(int propID) throws SQLException {
		String query = "UPDATE PROPERTY SET COUNT_NUMBER = (SELECT COUNT_NUMBER FROM PROPERTY WHERE PROPERTY_ID =" + propID + ")+ 1 WHERE PROPERTY_ID =" +  propID;
		jdbcProperty.runSetterQuery(query);
		
	}
}
