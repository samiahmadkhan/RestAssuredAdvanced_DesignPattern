package Api.RestResource.FactoryDesignPattern;

import io.restassured.response.Response;

//This is Abstract Product
public interface RestRequestWithPayload<T> {
    Response execute(String path,T payload);
}
