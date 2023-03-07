package getRequest;

import baseURLS.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Get03 extends JsonPlaceHolderBaseURL {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın "quis ut nam facilis et officia qui" olduğunu verify et.,
		And
		    "completed" ın false olduğunu verify et.
		And
		    "userId" in 1 olduğunu verify et
     */
    /*
    {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false

4. adımdan oluşuyor
                     1)Set URL
                     2)SET EXPECTED DATA --> ŞUAN İÇİN İMPORT EDECEĞİM
                     3)SEND REQUEST
                     4) ASSERTİON
     */

    @Test
    public void get03(){
    //    Step 1  set URL   " https://jsonplaceholder.typicode.com/todos/2"
   specification.pathParams("todosPath","todos","idPath","2");

    //Step   2  Expected Data(ıgnored)

        // Step 3 Send Request
        Response response=given().
                spec(specification).
                when().
                get("/{todosPath}/{idPath}");

        response.prettyPrint(); // like syso

        // 1 YOL
        response.then().assertThat().statusCode(200).contentType("application/json");
        response.
                then().
                assertThat().
                body("title", equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false),
                        "userId",equalTo(1));

        //2 YOL
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false),
                        "userId",equalTo(1));
}}
