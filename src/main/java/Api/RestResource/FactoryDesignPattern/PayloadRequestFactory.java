package Api.RestResource.FactoryDesignPattern;

public interface PayloadRequestFactory <T> {
    RestRequestWithPayload<T> createRequest();
}