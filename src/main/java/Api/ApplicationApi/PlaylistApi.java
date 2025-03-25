package Api.ApplicationApi;

import Api.RestResource.FactoryDesignPattern.GetRequestFactory;
import Api.RestResource.FactoryDesignPattern.NoPayloadRequestFactory;
import Api.RestResource.FactoryDesignPattern.RestRequestNoPayload;
import Api.TokenManager.TokenManager;
import Utility.ConfigLoader;
import io.restassured.response.Response;
import org.testng.Assert;

public class PlaylistApi {
    public static final String PLAYLISTS = "/playlists";
    public static String USER = "/users";
    public static Response getUserPlaylist(){
        String USER_ID= ConfigLoader.initialization().getUserID().replace("\"", "");
        //without factory design pattern
        //return RestResource.get(USER +"/"+ USER_ID + PLAYLISTS);


        //using factory design pattern
        NoPayloadRequestFactory requestFactory=new GetRequestFactory();
        RestRequestNoPayload getRequest =requestFactory.createRequest();
        return getRequest.execute(USER +"/"+ USER_ID + PLAYLISTS, TokenManager.getToken());
    }
    public static Response createUserPlaylist(){
        String USER_ID= ConfigLoader.initialization().getUserID();
        return null;

    }
    public static void verifyResponseStatusCode(Response response, int expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
    }
}
