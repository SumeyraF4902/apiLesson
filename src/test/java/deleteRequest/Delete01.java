package deleteRequest;

import baseURLS.RestFulLBookerHerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

public class Delete01 extends RestFulLBookerHerOkuAppBaseURL {

    /*   SİLDİĞİN ID BİRDAHA CALISMAZZZZZZZZZZZZZZZZZZZZ
        Given
            1)https://restful-booker.herokuapp.com/booking/948

            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */
    @Test
    public void delete01(){
        // Step :1 set URL
        //1)https://restful-booker.herokuapp.com/booking/5
        specification.pathParams("bookingPath","booking","idPath",2948);

        // Step02 :Set etmemiz gereken birsey olmadıgı ıcın ignore edilmiştir

        //Step 3: Send a request
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                when().
                delete("/{bookingPath}/{idPath}");

        System.out.println("RESPONSE");
        response.prettyPrint();

        // STEP 4:ASSERTİON

       response.then().assertThat().statusCode(201);
      String responseBody = response.asString();
        assertEquals(responseBody,"Created");
    }
}
