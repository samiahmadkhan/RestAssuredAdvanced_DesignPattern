package com.spotify;

import Api.ApplicationApi.PlaylistApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TC2_createAndVerifyPlaylist {

    @Test
    public void Story001_Create_Verify_Playlist(){
        Response response=PlaylistApi.getUserPlaylist();
        PlaylistApi.verifyResponseStatusCode(response,200);
    }
}
