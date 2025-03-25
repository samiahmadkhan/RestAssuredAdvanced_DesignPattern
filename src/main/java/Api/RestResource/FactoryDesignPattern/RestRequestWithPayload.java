package Api.RestResource.FactoryDesignPattern;

import io.restassured.response.Response;

public interface RestRequestWithPayload<T> {
    Response execute(String path,T payload);
}
