package com.spotify;

import Api.ApplicationApi.PlaylistApi;
import Api.Pojo.CreateUserPlaylistPayload;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TC2_createAndVerifyPlaylist {

    @Test
    public void Story002_Create_Verify_Playlist(){
        CreateUserPlaylistPayload payload=PlaylistApi.generateFakeUserPlaylistPayload();
        Response response=PlaylistApi.createUserPlaylist(payload);
        response.then().log().all();
        PlaylistApi.verifyResponseStatusCode(response,201);
        PlaylistApi.verifyPlaylistCreated(response,payload);
    }
}
