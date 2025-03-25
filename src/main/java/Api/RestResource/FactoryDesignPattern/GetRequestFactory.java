package Api.RestResource.FactoryDesignPattern;

public class GetRequestFactory implements NoPayloadRequestFactory {
    @Override
    public RestRequestNoPayload createRequest() {
        return new GetRequest();
    }
}