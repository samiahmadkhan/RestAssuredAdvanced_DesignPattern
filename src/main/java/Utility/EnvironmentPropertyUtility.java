package Utility;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentPropertyUtility {
    private static final Dotenv dotenv = Dotenv.load();
    private EnvironmentPropertyUtility() {
    }
    public static String getEnvironmentProperty(String propertyName){
        return dotenv.get(propertyName); // return dotenv.get("CLIENT_ID");
    }
}
