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
			String queryRooms = " NUMBER_OF_ROOMS >= " + searchRoomNumberMin;
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
		String query = "UPDATE PROPERTY SET COUNT_NUMBER = COUNT_NUMBER + 1 WHERE PROPERTY_ID =" +  propID;
		jdbcProperty.runSetterQuery(query);
		
	}
	public void update(int updatePropID, String updateClientID, String updateUserID, String updatePropertyType,
			String updateSize, String updateGroundSize, String updateRoomNumber, String updateHalfRoomNumber, String updatePrice,
			String updateStreetAndNumber, String updateCity, String updateMaterial, String updateToilet,
			String updateLevel, String updateCondition, String updateDescription, String updateStatus) throws SQLException {
		String[] analisator = new String[17];
		int index = 0;
		String query = "";
		String update = "UPDATE PROPERTY SET ";
		String where = " WHERE PROPERTY_ID =" + updatePropID;
		if(!updateClientID.equals("")) {
			analisator[index] = "CLIENT_ID =" + updateClientID;
			index++;
		}
		if(!updateUserID.equals("")) {
			analisator[index] = "USER_ID =" + updateUserID;
			index++;
		}
		if(!updatePropertyType.equals("")) {
			analisator[index] = "PROPERTY_TYPE = '" + updatePropertyType + "'";
			index++;
		}
		if(!updateSize.equals("")) {
			analisator[index] = "PROPERTY_SIZE =" + updateSize;
			index++;
		}
		if(!updateGroundSize.equals("")) {
			analisator[index] = "GROUND_SIZE =" + updateGroundSize;
			index++;
		}
		if(!updateRoomNumber.equals("")) {
			analisator[index] = "NUMBER_OF_ROOMS =" + updateRoomNumber;
			index++;
		}
		if(!updateHalfRoomNumber.equals("")) {
			analisator[index] = "NUMBER_OF_HALFROOM =" + updateHalfRoomNumber;
			index++;
		}
		if(!updatePrice.equals("")) {
			analisator[index] = "PRICE =" + updatePrice;
			index++;
		}
		if(!updateStreetAndNumber.equals("")) {
			analisator[index] = "STREET_AND_NUMBER = '" + updateStreetAndNumber + "'";
			index++;
		}
		if(!updateCity.equals("")) {
			analisator[index] = "CITY = '" + updateCity + "'";
			index++;
		}
		if(!updateMaterial.equals("")) {
			analisator[index] = "MATERIALS = '" + updateMaterial + "'";
			index++;
		}
		if(!updateToilet.equals("")) {
			analisator[index] = "WC = '" + updateToilet + "'";
			index++;
		}
		if(!updateLevel.equals("")) {
			analisator[index] = "ENERGETIC_LEVEL =" + updateLevel;
			index++;
		}
		if(!updateCondition.equals("")) {
			analisator[index] = "PROPERTY_CONDITION = '" + updateCondition + "'";
			index++;
		}
		if(!updateDescription.equals("")) {
			analisator[index] = "DESCRIPTION = '" + updateDescription + "'";
			index++;
		}
		if(!updateStatus.equals("")) {
			analisator[index] = "AD_STATUS = '" + updateStatus + "'";
			index++;
		}
		String sep = "";
		for(int i=0;i<index;i++) {
			query = query + sep + analisator[i];
			sep = ",";
		}
		query = update + query + where;
		jdbcProperty.runSetterQuery(query);
	}
}
