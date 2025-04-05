package Utility;

import io.github.cdimascio.dotenv.Dotenv;

//SINGLETON DESIGN PATTERN

public class EnvironmentPropertyUtility {
    private static Dotenv dotenv ;
    private String ENV="env";
    private static EnvironmentPropertyUtility environmentPropertyUtility;
    //added above systemProperty so that if .env does not have that property it reads from System property
    private EnvironmentPropertyUtility() {
        ENV=System.getProperty(ENV,"STAGE");
        dotenv = Dotenv.configure()
                .filename(".env." + ENV)
                .ignoreIfMissing()             // skip error if no `.env` file
                .systemProperties()           // enables reading from env variables
                .load();
    }
    public static EnvironmentPropertyUtility getInstance(){
        if(environmentPropertyUtility==null){
            synchronized (EnvironmentPropertyUtility.class){
                if(environmentPropertyUtility==null)
                    environmentPropertyUtility=new EnvironmentPropertyUtility();
            }
        }
        return environmentPropertyUtility;
    }
    public String getEnvironmentProperty(String propertyName){
        return dotenv.get(propertyName); // return dotenv.get("CLIENT_ID");
    }
}
