package Api.ApplicationApi;

import Api.Pojo.CreateUserPlaylistPayload;
import Api.Pojo.createPlayListResponse.CreatePlayListResponse;
import Api.RestResource.FactoryDesignPattern.AbstractFactory.PayloadRequestFactory;
import Api.RestResource.FactoryDesignPattern.ConcreteAbstractFactory.GetRequestFactory;
import Api.RestResource.FactoryDesignPattern.AbstractFactory.NoPayloadRequestFactory;
import Api.RestResource.FactoryDesignPattern.ConcreteAbstractFactory.PostRequestFactory;
import Api.RestResource.FactoryDesignPattern.Product.RestRequestNoPayload;
import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;
import Api.TokenManager.TokenManager;
import Utility.ConfigLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.Assert;

import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;

public class PlaylistApi {
    public static final String PLAYLISTS = "/playlists";
    public static String USER = "/users";

    //@Step("GET User Playlist")
    public static Response getUserPlaylist() {
        Allure.step("GET User Playlist");
        String USER_ID = ConfigLoader.initialization().getUserID().replace("\"", "");
        //without factory design pattern
        //return RestResource.get(USER +"/"+ USER_ID + PLAYLISTS);

        //using factory design pattern
        NoPayloadRequestFactory requestFactory = new GetRequestFactory();
        RestRequestNoPayload getRequest = requestFactory.createRequest();


        return getRequest.execute(USER + "/" + USER_ID + PLAYLISTS, TokenManager.getToken());
    }


    public static Response createUserPlaylist(CreateUserPlaylistPayload payload) {
        Allure.step("Create User Playlist");

        String USER_ID = ConfigLoader.initialization().getUserID().replace("\"", "");
        PayloadRequestFactory payloadRequestFactory = new PostRequestFactory();
        RestRequestWithPayload restRequestWithPayload = payloadRequestFactory.createRequest();
        Response response = restRequestWithPayload.execute(USER + "/" + USER_ID + PLAYLISTS, payload, TokenManager.getToken());;
        return response;


    }

    //@Step("Generate Fake User Data user Faker")
    public static CreateUserPlaylistPayload generateFakeUserPlaylistPayload() {
        Allure.step("Generate Fake User Data user Faker");
        CreateUserPlaylistPayload payload = new CreateUserPlaylistPayload();
        Faker faker = new Faker();
        payload.setName(faker.name().firstName());
        payload.setDescription(faker.lorem().sentence());
        payload.setPublic(faker.bool().bool());
        return payload;

    }

    //@Step("Verify the Response Status Code")
    public static void verifyResponseStatusCode(Response response, int expectedStatusCode) {
        Allure.step("Verify the Response Status Code");
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    //@Step("Verify User Playlist is Created Successfully")
    public static void verifyPlaylistCreated(Response response, CreateUserPlaylistPayload expectedData) {
        Allure.step("Verify User Playlist is Created Successfully");
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePlayListResponse output;
        try {
            output = objectMapper.readValue(response.body().asString(), CreatePlayListResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(output.getDescription(), expectedData.getDescription());
        Assert.assertEquals(output.getName(), expectedData.getName());

    }

}
