package Api.RestResource.FactoryDesignPattern.ConcreteProduct;

import Api.RestResource.FactoryDesignPattern.Product.RestRequestWithPayload;
import Api.SpectBuilder.SpecBuilder;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.PrintStream;
import java.io.StringWriter;

//This is Concrete Abstract Product
public class PostRequest<T> implements RestRequestWithPayload<T> {
    @Override
    public Response execute(String path, T payload,String accessToken) {
        StringWriter writerRequest;
        PrintStream captor;
        writerRequest = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response= RestAssured.given(SpecBuilder.getRequestSpecification())
                .body(payload)
                .auth().oauth2(accessToken)
                .log().all()
                .filter(new RequestLoggingFilter(captor))
                .when().
                post(path);
        printDetailsInExtentReport(writerRequest, response);

        return response;
    }
    private static void printDetailsInExtentReport(StringWriter writer, Response response) {
        Allure.step("");
        Allure.step("Request details:" + writer.toString() + "\n");
        Allure.step("Response details: "+ response.asString() +  "\n");

    }
}
