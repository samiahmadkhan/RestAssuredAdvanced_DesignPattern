package Api.RestResource.FactoryDesignPattern;

import io.restassured.response.Response;


//This is Abstract Product
public interface RestRequestNoPayload {
    Response execute(String path,String accessToken);
}
