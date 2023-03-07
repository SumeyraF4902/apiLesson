package getRequest;

import baseURLS.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseURL {
    /*
        Given
            https://jsonplaceholder.typicode.com/users
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    Data uzunluğunun 10 olduğunu assert ediniz.

     */

    @Test
    public void get03() {
        //    Step 1  set URL   " https://jsonplaceholder.typicode.com/todos/2"
        specification.pathParam("usersPath", "users" );

        // Step 2 Expected data (igoored)

        //  Step 3 : Send Request

        Response response=given().
                spec(specification).
                when().
                get("/{usersPath}");

        response.prettyPrint();

        // Status Code un "200" olduğunu Assert et
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.hasSize(10));// ilk 10 getirir



    }}