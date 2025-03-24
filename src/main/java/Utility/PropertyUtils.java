package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertyUtils {
    private PropertyUtils() {
        //making util class constructor as private to avoid initialization and creation of multiple objects
    }

    public static Optional<Properties> propertyLoader(String filePath) {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
            return Optional.of(properties);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + filePath + " - " + e.getMessage());
            return Optional.empty();
        }

    }
}
