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

public class HomeWork09Authorization extends RestFulLBookerHerOkuAppBaseURL {

    // PUT 02 DEKI ORNEGİN AUTHORİZATION  İLE YAPIMI (HERSEYI AYNI SADECE RESPONSE İCİNDE HEADERE AUTHORİZATION  GIRILECEK)

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
@Test
    public void homeWork09(){
    //Set URL
    //https://restful-booker.herokuapp.com/booking/37
    specification.pathParams("bookingPath","booking","idPath","96");


    MainPojoPut02 bookingdatesPojo=new MainPojoPut02("2022-01-01","2023-01-01");


    BookingDatesPojoPut02 bookingExpecetedData=new BookingDatesPojoPut02("Drake","F..",4000,true,bookingdatesPojo,"API and Appium");


    //Step 3: Send a request
    Response response = given().
            spec(specification).
            contentType(ContentType.JSON).
            when().
            header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
            body(bookingExpecetedData).
            put("/{bookingPath}/{idPath}");

    System.out.println("RESPONSE: ");
    response.prettyPrint();

    //Step 4: Assertion
    JsonPath actualData=response.jsonPath();
    assertEquals(actualData.getString("firstname"),bookingExpecetedData.getFirstname());
    assertEquals(actualData.getString("lastname"),bookingExpecetedData.getLastname());
    assertEquals(actualData.getInt("totalprice"),bookingExpecetedData.getTotalprice());
    assertEquals(actualData.getBoolean("depositpaid"),bookingExpecetedData.getDepositpaid());
    assertEquals(actualData.getString("bookingdates.checkin"),bookingdatesPojo.getCheckin());
    assertEquals(actualData.getString("bookingdates.checkout"),bookingdatesPojo.getCheckout());
    assertEquals(actualData.getString("additionalneeds"),bookingExpecetedData.getAdditionalneeds());


}

}