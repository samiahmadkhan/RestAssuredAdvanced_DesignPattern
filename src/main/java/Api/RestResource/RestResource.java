package Api.RestResource;

import Api.Pojo.CreateUserPlaylistPayload;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class RestResource {

    public static final String API = "/api";

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
    public static Response postAccount(HashMap<String,String> formParameters){
        return RestAssured.given(SpecBuilder.getAccountRequestSpecification())
                .formParams(formParameters).when().post(API + "/token");

    }

}
