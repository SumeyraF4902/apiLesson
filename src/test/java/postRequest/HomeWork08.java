package postRequest;


import baseURLS.RestFulLBookerHerOkuAppBaseURL;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.BookingDatesPojoPut02;
import pojoDatas.MainPojoPut02;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeWork08 extends RestFulLBookerHerOkuAppBaseURL {
    /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
        When
 		    Kullanıcı POST metodu ile request göderir
 	    Then
              Status Code un 200 olduğu doğrulanır
 		And
 		      Response Body nin aşağıdaki gibi olduğu verify edilir
 		    {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */
    @Test
    public void homeWork08(){
        //Set URL
        //https://restful-booker.herokuapp.com/booking/
        specification.pathParam("bookingPath","booking");

        MainPojoPut02 bookingdatesPojo=new MainPojoPut02("2022-09-05","2023-06-01");
        BookingDatesPojoPut02 bookingExpecetedData=new BookingDatesPojoPut02("Drake","F.",4000,true,bookingdatesPojo,"Full Stack Test Automation Course with API and Appium");

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().basic("admin","password123").
                body(bookingExpecetedData).
                when().
                post("/{bookingPath}");


        System.out.println("Response Body: " );
        response.prettyPrint();


       // Map<String,Object> actualData=response.as(Map.class);
        //BookingDatesPojoPut02 actualData=response.as( BookingDatesPojoPut02.class);
        JsonPath actualData=response.jsonPath();
        System.out.println("actualData = " + actualData);
        // Assertion
        Assert.assertEquals(bookingExpecetedData.getFirstname(),actualData.getString("firstname"));
   /*  Assert.assertEquals(bookingExpecetedData.getLastname(),actualData.getLastname());
        Assert.assertEquals(bookingExpecetedData.getTotalprice(),actualData.getTotalprice());
        Assert.assertEquals(bookingExpecetedData.getDepositpaid(),actualData.getDepositpaid());
        Assert.assertEquals(bookingExpecetedData.getBookingdates(),actualData.getBookingdates());
        Assert.assertEquals(bookingExpecetedData.getAdditionalneeds(),actualData.getAdditionalneeds());*/


    }
}
