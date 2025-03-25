package Api.RestResource.FactoryDesignPattern.AbstractFactory;

import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;

//This is Abstract Factory
public interface PayloadRequestFactory <T> {
    RestRequestWithPayload<T> createRequest();
}