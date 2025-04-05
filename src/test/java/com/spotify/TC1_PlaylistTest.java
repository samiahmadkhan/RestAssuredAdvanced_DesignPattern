package com.spotify;

import Api.ApplicationApi.PlaylistApi;
import Api.SpectBuilder.SpecBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1_PlaylistTest {
    @Description("Get User Playlist")
    @Story("GET Playlist")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Story001_Verify_get_User_Playlist(){
        Response response=PlaylistApi.getUserPlaylist();
        response.then().log().all();
        PlaylistApi.verifyResponseStatusCode(response,200);
    }
}
