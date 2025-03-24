package Api.ApplicationApi;

import Api.RestResource.RestResource;
import Utility.ConfigLoader;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;

public class PlaylistApi {
    public static final String PLAYLISTS = "/playlists";
    public static String USER = "/users";
    public static Response getUserPlaylist(){
        String USER_ID= ConfigLoader.initialization().getUserID();
        return RestResource.get(USER +"/"+ USER_ID + PLAYLISTS);
    }
    public static Response createUserPlaylist(){
        String USER_ID= ConfigLoader.initialization().getUserID();


        return null;

    }
    public static void verifyResponseStatusCode(Response response, int expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
    }
}
