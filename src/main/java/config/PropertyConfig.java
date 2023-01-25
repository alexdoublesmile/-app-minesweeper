package config;

import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {
    private static final String PROPERTIES_FILE_NAME = "application.properties";
    private static Properties properties = new Properties();

    public synchronized static String getProperty(String name, String defaultValue) {
        if (properties.isEmpty()) {
            loadProperties();
        }
        return properties.getProperty(name, defaultValue);
    }

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            loadProperties();
        }
        return properties.getProperty(name);
    }

    private static void loadProperties() {
        try (InputStream is = PropertyConfig.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE_NAME)) {

            properties.load(is);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
