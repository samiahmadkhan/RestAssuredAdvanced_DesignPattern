package Api.RestResource.FactoryDesignPattern.ConcreteAbstractFactory;

import Api.RestResource.FactoryDesignPattern.AbstractFactory.PayloadRequestFactory;
import Api.RestResource.FactoryDesignPattern.ConcreteProduct.PostRequest;
import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;

//Concrete Abstract Product

public class PostRequestFactory<T> implements PayloadRequestFactory<T> {

    @Override
    public RestRequestWithPayload<T> createRequest() {
        return new PostRequest<>();

    }
}
