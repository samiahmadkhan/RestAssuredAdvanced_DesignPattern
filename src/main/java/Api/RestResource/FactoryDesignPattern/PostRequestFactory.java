package Api.RestResource.FactoryDesignPattern;

public class PostRequestFactory <T> implements PayloadRequestFactory<T> {
    @Override
    public RestRequestWithPayload<T> createRequest() {
        return new PostRequest<>();
    }
}