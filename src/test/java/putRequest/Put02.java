package putRequest;

import baseURLS.RestFulLBookerHerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.BookingDatesPojoPut02;


import pojoDatas.MainPojoPut02;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends RestFulLBookerHerOkuAppBaseURL {
    private BookingDatesPojoPut02 bookingDatesPojoPut02;
    /*
        Given
	        1) https://restful-booker.herokuapp.com/booking/37
	        2) {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
        3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
            Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

            Cookie =>>> "token": "e36ab98e8e042a7"  =====>Benim tokenim post mandan create ettim
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
     */


    //""token": "3b6cdc0856c9857"   =====>Benim tokenim post mandan create ettim

    @Test
    public void put02() {

        //Set URL
        //https://restful-booker.herokuapp.com/booking/37
        specification.pathParams("bookingPath","booking","idPath","37");


        //Set Expected and Request Body
        /*
         {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
         */

        MainPojoPut02 bookingdatesPojo=new MainPojoPut02("2022-01-01","2023-01-01");


        BookingDatesPojoPut02 bookingExpecetedData=new BookingDatesPojoPut02("Drake","F..",4000,true,bookingdatesPojo,"API and Appium");

        System.out.println("bookingExpecetedData = " + bookingExpecetedData);

//System.out.println(restFulBookingPojo);
        //Step 3: Send a request;

        //Cookie  -----  token=<token_value>

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                header("Cookie", "token=" + "3b6cdc0856c9857").
                body(bookingExpecetedData).
                put("/{bookingPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();


        //Forbidden     ----->>>> Token değiştirdim

        //401  ----->> Unauth.     -----------------    Authj. ile ilgli herahngi bir value bulunmadığı zaman.
        //403 ------>> Forbidden    - - -- - -- - -- Token veya ilgili auth. metodu ne ise onunla ilgili oalrak value var fakat yanlış yahut expire olmuş olabilir.



        //Step 4: Assertion

        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getString("firstname"),bookingExpecetedData.getFirstname());
        assertEquals(jsonPath.getString("lastname"),bookingExpecetedData.getLastname());
        assertEquals(jsonPath.getInt("totalprice"),bookingExpecetedData.getTotalprice());
        assertEquals(jsonPath.getBoolean("depositpaid"),bookingExpecetedData.getDepositpaid());
        assertEquals(jsonPath.getString("bookingdates.checkin"),bookingdatesPojo.getCheckin());
        assertEquals(jsonPath.getString("bookingdates.checkout"),bookingdatesPojo.getCheckout());
        assertEquals(jsonPath.getString("additionalneeds"),bookingExpecetedData.getAdditionalneeds());




    }



}
