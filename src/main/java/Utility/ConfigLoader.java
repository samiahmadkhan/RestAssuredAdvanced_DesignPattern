package Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class ConfigLoader {
    //here will be using Singleton Design Pattern
    private Properties properties;
    private String ENV="env";
    private static final String CONFIG_PROPERTIES = "_config.properties";

    /* Default config file is stg_config.properties */
    private static final String STG_CONFIG_PROPERTIES = "stg" + CONFIG_PROPERTIES;
    private static final String PROD_CONFIG_PROPERTIES = "prod" + CONFIG_PROPERTIES;
    private static final String SIT_CONFIG_PROPERTIES = "sit" + CONFIG_PROPERTIES;
    private static final String BASE_URI_API = "base_uri_api";
    private static final String BASE_ACCOUNT_URI_API = "base_uri_accounts";

    private static final String USER_ID = "user_id";
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";


    private static ConfigLoader configLoader;
    private static final Map<String, String> ENV_CONFIG_MAP = new HashMap<>();

    static {
        ENV_CONFIG_MAP.put("STAGE",STG_CONFIG_PROPERTIES);
        ENV_CONFIG_MAP.put("PROD",PROD_CONFIG_PROPERTIES);
        ENV_CONFIG_MAP.put("SIT",SIT_CONFIG_PROPERTIES);
    }

    private ConfigLoader() {
        //set the Env
        //if Env is not set then setting default STAGE Env
        ENV=System.getProperty(ENV,"STAGE");

        //here instead of Swuitch i am using HashMap and using optional
        properties=Optional.ofNullable(RESOURCES_PATH+ENV_CONFIG_MAP.get(ENV))
                .map(PropertyUtils::propertyLoader)
                .orElseThrow(() -> new IllegalStateException("Invalid EnvType: " + ENV)).get();

    }
    public static ConfigLoader initialization(){
        if(configLoader==null){
            synchronized (ConfigLoader.class){
                if(configLoader==null){
                    configLoader=new ConfigLoader();
                }
            }
        }
        return configLoader;
    }
    public String getBaseUriAPI() {
        return getPropertyValue(BASE_URI_API);
    }
    public String getBaseAccountUriAPI() {
        return getPropertyValue(BASE_ACCOUNT_URI_API);
    }
    public String getUserID() {
        return getPropertyValue(USER_ID);
    }
    private String getPropertyValue(String propertyName){
        return properties.getProperty(propertyName);


    }
}
