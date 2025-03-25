package Api.RestResource.FactoryDesignPattern;

import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//This is Concrete Abstract Product
public class PostRequest<T> implements RestRequestWithPayload<T>{
    @Override
    public Response execute(String path, T payload) {
        return RestAssured.given(SpecBuilder.getRequestSpecification())
                .basePath(path)
                .body(payload.toString())
                .when().post();
    }
}
