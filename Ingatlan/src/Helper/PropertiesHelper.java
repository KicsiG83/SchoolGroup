package Helper;

import java.util.Properties;

public class PropertiesHelper {

	private Properties properties = new Properties();

	public PropertiesHelper(String propertyFileName) {
		try {
			this.properties.load(this.getClass().getClassLoader().getResource(propertyFileName).openStream());
		} catch (Exception var3) {
			System.out.println(var3.getLocalizedMessage());
			var3.printStackTrace();
		}
	}

	public Boolean getPropertyAsBooleanFor(String key) {
		return Boolean.valueOf(this.getPropertyFor(key));
	}

	public int getPropertyAsIntFor(String key) {
		return Integer.parseInt(this.getPropertyFor(key).trim());
	}

	public String getPropertyFor(String key) {
		return this.properties.getProperty(key);
	}

}
