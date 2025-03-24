package Api.TokenManager;

import Api.RestResource.RestResource;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

public class TokenManager {
    private static String ACCESS_TOKEN;
    private static Instant EXPIRES_IN;

    public static synchronized String getToken() {
        if (ACCESS_TOKEN == null || Instant.now().isAfter(EXPIRES_IN)) {
            Response res = generateToken();
            ACCESS_TOKEN = res.jsonPath().get("access_token");
            int expiryTime = res.jsonPath().get("expires_in");
            EXPIRES_IN = Instant.now().plusSeconds(expiryTime + 100);
        } else {
            System.out.println("Token is not Expired, reusing the token");
        }
        return ACCESS_TOKEN;
    }

    private static Response generateToken() {
        HashMap<String, String> formParameters = new HashMap<>();
        return RestResource.postAccount(formParameters);


    }
}
