package Api.RestResource;

import Api.Pojo.CreateUserPlaylistPayload;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class RestResource {

    //this is without Factory design pattern

    public static final String API = "/api";
    public static final String TOKEN = "/token";

    public static Response get(String path){
        return RestAssured.given(SpecBuilder.getRequestSpecification())
                .basePath(path)
                .when().get();

    }
    public static Response post(String path, CreateUserPlaylistPayload playlistPayload){
        return RestAssured.given(SpecBuilder.getRequestSpecification())
                .basePath(path)
                .body(playlistPayload.toString())
                .when().post();
    }
    public static Response postWithFormParameter(HashMap<String,String> formParameters){
        return RestAssured.given(SpecBuilder.getAccountRequestSpecification())
                .formParams(formParameters).when().post(API + TOKEN);

    }

}
