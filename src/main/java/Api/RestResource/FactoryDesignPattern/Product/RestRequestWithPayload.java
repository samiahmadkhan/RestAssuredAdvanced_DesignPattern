package Api.RestResource.FactoryDesignPattern.Product;

import io.restassured.response.Response;

//This is Abstract Product
public interface RestRequestWithPayload<T> {
    Response execute(String path,T payload,String accessToken);
}
