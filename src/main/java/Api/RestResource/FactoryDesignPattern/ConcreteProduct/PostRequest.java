package Api.RestResource.FactoryDesignPattern.ConcreteProduct;

import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//This is Concrete Abstract Product
public class PostRequest<T> implements RestRequestWithPayload<T> {
    @Override
    public Response execute(String path, T payload,String accessToken) {
        return RestAssured.given(SpecBuilder.getRequestSpecification())
                .body(payload)
                .auth().oauth2(accessToken)
                .log().all()
                .when().post(path);
    }
}
