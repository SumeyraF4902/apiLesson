package getRequest;

import baseURLS.HomeWork02URL;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

public class Homework02  extends HomeWork02URL {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/
    @Test
            public <JSONObject> void homeWork02(){
        //    Kullanıcı GET Methodu ile Request Gönderir
        specification.pathParams("bookingPath","booking");
        specification.queryParam("firstname","Sarah");
        //specification.queryParam("firstname","Jim");

        Response response =given().
                spec(specification).
                when().
                get("/{bookingPath}");
      response.prettyPrint();


        // Status Code un "200" olduğunu Assert et
        //response.then().assertThat().statusCode(200);

        response.then().assertThat().statusCode(200);

        JsonPath jsonPath=response.jsonPath();
        try {
            jsonPath.getInt("[0].bookingid");
            Assert.assertTrue(true);

        }catch (NullPointerException e) {
            Assert.fail("Boookingid bulunamadı");
        }

    }

    }






