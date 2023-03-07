package baseURLS;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HomeWork04URL {
    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL() {
        specification = new RequestSpecBuilder().
                setBaseUri("https://swapi.dev/api").build();
    }
}
