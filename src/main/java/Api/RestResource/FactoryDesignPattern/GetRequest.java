package Api.RestResource.FactoryDesignPattern;

import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

import java.io.PrintStream;
import java.io.StringWriter;


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
