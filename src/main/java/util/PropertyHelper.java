package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import static util.ConfigConstants.*;

public class PropertyHelper {
    private static Properties properties = new Properties();
    private static Properties configuration = new Properties();

    public synchronized static String getProperty(String name, String defaultValue) {
        if (properties.isEmpty()) {
            loadAppProperties();
        }
        return properties.getProperty(name, defaultValue);
    }

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            loadAppProperties();
        }
        return properties.getProperty(name);
    }

    public synchronized static String getConfig(String name, String defaultValue) {
        if (configuration.isEmpty()) {
            loadConfig();
        }
        return configuration.getProperty(name, defaultValue);
    }

    public synchronized static String getConfig(String name) {
        if (configuration.isEmpty()) {
            loadConfig();
        }
        return configuration.getProperty(name);
    }

    public synchronized static void updateConfig(String key, String value) {
        try (OutputStream fos = new FileOutputStream(CONFIG_PATH + CONFIG_FILE_NAME)) {
            configuration.setProperty(key, value);
            configuration.store(fos, null);

        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("can't set config to file - %s - %s",
                            e.getClass().getSimpleName(),
                            e.getMessage()), e);
        }
    }

    private static void loadProperties(String fileName, Properties map) {
        try (InputStream is = PropertyHelper.class.getClassLoader()
                .getResourceAsStream(fileName)) {

            map.load(is);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void loadAppProperties() {
        loadProperties(PROPERTIES_FILE_NAME, properties);
    }

    private static void loadConfig() {
        loadProperties(CONFIG_FILE_NAME, configuration);
    }

    public static void reload() {
        loadConfig();
        loadAppProperties();
    }
}
