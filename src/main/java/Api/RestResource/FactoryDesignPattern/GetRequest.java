package Api.RestResource.FactoryDesignPattern;

import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest implements RestRequestNoPayload {
    @Override
    public Response execute(String path) {
        return RestAssured.given(SpecBuilder.getRequestSpecification())
                .basePath(path)
                .when().get();
    }
}
