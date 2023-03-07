package deleteRequest;

import baseURLS.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseURL {
    /*
    Given
            1)https://dummy.restapiexample.com/api/v1/delete/2

        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 200 olduğunu
		 And
		    Response body in

		    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
}

     */
    @Test
    public void delete02(){

        // Step 01: set URL
        //https://dummy.restapiexample.com/api/v1/delete/2
        specification.pathParams("deletePath", "delete","idPath","2");

        //SET EXPECTED DATA

        DummyRestApiTestData dummyRestApiTestData=new DummyRestApiTestData();
        HashMap<String,String>expectedData=dummyRestApiTestData.setExpectedDataForDelete("success","2","Successfully! Record has been deleted");


        //STEP 3 SEND A REQUEST

        Response response=given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/{deletePath}/{idPath}");

        System.out.println("RESPONSE");
        response.prettyPrint();

        // STEP04  ASSERTION

        JsonPath actualData=response.jsonPath();
        assertEquals(expectedData.get("status"), actualData.getString("status"));
        assertEquals(expectedData.get("data"), actualData.getString("data"));
        assertEquals(expectedData.get("message"), actualData.getString("message"));
    }
}
