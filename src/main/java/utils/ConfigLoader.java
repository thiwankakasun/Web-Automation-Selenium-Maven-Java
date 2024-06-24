package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties testDataProperties = new Properties();
    private static final Properties objectRepositoryProperties = new Properties();

//    public ConfigLoader() {
//        String propFileName = "TestData.properties";
//
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
//            if (inputStream != null) {
//                properties.load(inputStream);
//            } else {
//                throw new RuntimeException("property file '" + propFileName + "' not found in the classpath");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading '" + propFileName + "' file", e);
//        }
//    }

    public ConfigLoader() {
        loadProperties(objectRepositoryProperties, "ObjectRepository.properties");
        loadProperties(testDataProperties, "TestData.properties");
    }

    public static String getTestDataProperty(String key) {
        return testDataProperties.getProperty(key);
    }

//    public String getConfigProperty(String key) {
//        return configProperties.getProperty(key);
//    }

    private void loadProperties(Properties properties, String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Property file '" + fileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading '" + fileName + "' file", e);
        }
    }

    public String getObjectRepositoryProperty(String key) {
        return objectRepositoryProperties.getProperty(key);
    }

//    public String getProperty(String key) {
//        return properties.getProperty(key);
//    }
}