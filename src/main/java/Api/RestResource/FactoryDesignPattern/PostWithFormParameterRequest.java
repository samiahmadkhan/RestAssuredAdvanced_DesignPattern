package Api.RestResource.FactoryDesignPattern;

import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class PostWithFormParameterRequest<T> implements RestRequestWithPayload<T>{
    public static final String API = "/api";
    public static final String TOKEN = "/token";
    @Override
    public Response execute(String path, T payload) {
        return RestAssured.given(SpecBuilder.getAccountRequestSpecification())
                .formParams((Map<String, ?>) payload).when().post(API + TOKEN);
    }
}
