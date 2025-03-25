package Api.RestResource.FactoryDesignPattern.ConcreteAbstractFactory;

import Api.RestResource.FactoryDesignPattern.AbstractFactory.NoPayloadRequestFactory;
import Api.RestResource.FactoryDesignPattern.Product.RestRequestNoPayload;
import Api.RestResource.FactoryDesignPattern.ConcreteProduct.GetRequest;

//This is Concrete Abstract Factory
public class GetRequestFactory implements NoPayloadRequestFactory {
    @Override
    public RestRequestNoPayload createRequest() {
        return new GetRequest();
    }
}