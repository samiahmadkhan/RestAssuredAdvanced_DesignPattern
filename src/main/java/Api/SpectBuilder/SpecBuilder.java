package Api.SpectBuilder;

import Utility.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class SpecBuilder {
    public static RequestSpecification getRequestSpecification(){
        return RestAssured.given().
                baseUri(ConfigLoader.initialization().getBaseUriAPI())
                .basePath("/v1")
                .contentType("application/json");
    }

    public static RequestSpecification getAccountRequestSpecification(){
        return RestAssured.given().
                baseUri(ConfigLoader.initialization().getBaseAccountUriAPI())
                .contentType("application/x-www-form-urlencoded");
    }
}

