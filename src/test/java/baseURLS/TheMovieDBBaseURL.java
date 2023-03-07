package baseURLS;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TheMovieDBBaseURL {
    // https://api.themoviedb.org/3      ===,> BASE URL

    protected RequestSpecification specification;

    @Before
    public void setBaseURL(){

        specification = new RequestSpecBuilder().
                setBaseUri("https://api.themoviedb.org/3").
                build();
        //https://developers.themoviedb.org/3/authentication/create-request-token   app key alabileceğim yer
        // APİ_KEY =32a372dd7b4f87b14f54baaaeb466484
}}
