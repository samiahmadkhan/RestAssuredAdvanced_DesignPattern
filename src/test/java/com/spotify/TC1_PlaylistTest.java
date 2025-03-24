package com.spotify;

import Api.ApplicationApi.PlaylistApi;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1_PlaylistTest {

    @Test
    public void Story001_Verify_get_User_Playlist(){
        Response response=PlaylistApi.getUserPlaylist();
        PlaylistApi.verifyResponseStatusCode(response,200);
    }
}
