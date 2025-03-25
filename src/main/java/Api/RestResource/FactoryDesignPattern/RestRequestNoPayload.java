package Api.RestResource.FactoryDesignPattern;

import io.restassured.response.Response;

public interface RestRequestNoPayload {
    Response execute(String path);
}
