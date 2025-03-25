package Api.RestResource.FactoryDesignPattern;

//This is Abstract Factory
public interface PayloadRequestFactory <T> {
    RestRequestWithPayload<T> createRequest();
}