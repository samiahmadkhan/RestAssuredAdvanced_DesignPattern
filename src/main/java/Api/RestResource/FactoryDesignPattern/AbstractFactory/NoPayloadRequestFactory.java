package Api.RestResource.FactoryDesignPattern.AbstractFactory;


//This is Abstract Factory

import Api.RestResource.FactoryDesignPattern.Product.RestRequestNoPayload;

public interface NoPayloadRequestFactory {
    RestRequestNoPayload createRequest();

}
