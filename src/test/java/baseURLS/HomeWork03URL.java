package baseURLS;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HomeWork03URL {
    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL() {
        specification = new RequestSpecBuilder().
                setBaseUri("https://dummy.restapiexample.com/api/v1").build();
    }
}
