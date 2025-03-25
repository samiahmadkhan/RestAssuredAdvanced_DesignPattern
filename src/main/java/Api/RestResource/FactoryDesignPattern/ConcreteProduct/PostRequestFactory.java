package Api.RestResource.FactoryDesignPattern.ConcreteProduct;


import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;
import Api.RestResource.FactoryDesignPattern.AbstractFactory.PayloadRequestFactory;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

//This is Concrete Abstract Factory
public class PostRequestFactory <T> implements RestRequestWithPayload<T> {
    public static final String API = "/api";
    public static final String TOKEN = "/token";
    @Override
    public Response execute(String path, T payload,String accessToken) {
        return RestAssured.given(SpecBuilder.getAccountRequestSpecification())
                .formParams((Map<String, ?>) payload).
                auth().oauth2(accessToken).
                when().post(API + TOKEN);
    }
}