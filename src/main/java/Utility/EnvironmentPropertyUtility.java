package Utility;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentPropertyUtility {
    private static Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()             // skip error if no `.env` file
            .systemProperties()           // enables reading from env variables
            .load();
    //added above systemProperty so that if .env does not have that property it reads from System property
    private EnvironmentPropertyUtility() {
    }
    public static String getEnvironmentProperty(String propertyName){
        return dotenv.get(propertyName); // return dotenv.get("CLIENT_ID");
    }
}
