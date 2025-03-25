package Api.TokenManager;

import Api.RestResource.RestResource;
import Utility.ConfigLoader;
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
        formParameters.put("grant_type", ConfigLoader.initialization().getGrantType());
        formParameters.put("client_id",ConfigLoader.initialization().getClientID());
        formParameters.put("client_secret",ConfigLoader.initialization().getClientSecret());
        formParameters.put("refresh_token",ConfigLoader.initialization().getRefreshToken());

        return RestResource.postWithFormParameter(formParameters);

    }
}
