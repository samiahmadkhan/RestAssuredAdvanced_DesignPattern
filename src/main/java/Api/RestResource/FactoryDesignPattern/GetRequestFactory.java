package Api.RestResource.FactoryDesignPattern;

//This is Concrete Abstract Factory
public class GetRequestFactory implements NoPayloadRequestFactory {
    @Override
    public RestRequestNoPayload createRequest() {
        return new GetRequest();
    }
}