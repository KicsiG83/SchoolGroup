package Helper;

public class ConfigHelper {

    private static PropertiesHelper propertiesHelper = new PropertiesHelper("configuration.yml");
    public static final String username = propertiesHelper.getPropertyFor("username");
    public static final String password = propertiesHelper.getPropertyFor("password");
    public static final String url = propertiesHelper.getPropertyFor("url");
	
}
