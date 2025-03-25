package Api.RestResource.FactoryDesignPattern.ConcreteProduct;

import Api.RestResource.FactoryDesignPattern.Product.RestRequestNoPayload;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;


//This is Concrete Abstract Product

public class GetRequest implements RestRequestNoPayload {
    @Override
    public Response execute(String path,String accessToken) {
        return RestAssured.given(SpecBuilder.getRequestSpecification())
                .auth().oauth2(accessToken)
                .log().all()
                .when().get(path);
    }
}
