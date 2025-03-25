package Api.RestResource.FactoryDesignPattern.ConcreteAbstractFactory;

import Api.RestResource.FactoryDesignPattern.AbstractFactory.PayloadRequestFactory;
import Api.RestResource.FactoryDesignPattern.ConcreteProduct.PostRequest;
import Api.RestResource.FactoryDesignPattern.ConcreteProduct.PostRequestFactory;
import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;
import Api.SpectBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

//Concrete Abstract Product

public class PostWithFormParameterRequest<T> implements PayloadRequestFactory<T> {

    @Override
    public RestRequestWithPayload<T> createRequest() {
        return new PostRequestFactory();
    }
}
