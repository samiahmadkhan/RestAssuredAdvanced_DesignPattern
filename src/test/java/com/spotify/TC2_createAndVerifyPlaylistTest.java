package com.spotify;

import Api.ApplicationApi.PlaylistApi;
import Api.Pojo.CreateUserPlaylistPayload;
import io.restassured.response.Response;
import org.testng.annotations.Test;

//@Listeners(ChainTestListener.class)
public class TC2_createAndVerifyPlaylistTest {


    @Test
    public void Story002_Create_Verify_Playlist(){
        CreateUserPlaylistPayload payload=PlaylistApi.generateFakeUserPlaylistPayload();
        Response response=PlaylistApi.createUserPlaylist(payload);
        response.then().log().all();
        PlaylistApi.verifyResponseStatusCode(response,201);
        PlaylistApi.verifyPlaylistCreated(response,payload);
    }
}
