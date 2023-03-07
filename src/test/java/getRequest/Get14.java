package getRequest;

import baseURLS.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Get14 extends JsonPlaceHolderBaseURL {
    /*


        Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

  {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }

     */

        
    @Test
    public void get14(){
        //Step 1: Set URL
        //https://jsonplaceholder.typicode.com/todos/198
        specification.pathParams("todosPath","todos",
                "idPath","198");


        //Step 2: Set Expected Data

        String expectedData = " {\n" +
                "   \"userId\": 10,\n" +
                "  \"id\": 198,\n" +
                " \"title\": \"quis eius est sint explicabo\",\n" +
                "  \"completed\": true\n" +
                "}";

        System.out.println("Expected Data: " + expectedData);

       HashMap<String,Object> expectedDataMap=JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);



        /*
         JsonPlaceHolderBaseURL jsonPlaceHolderBaseURL = new JsonPlaceHolderBaseURL();

        String ex = jsonPlaceHolderBaseURL.createEdilen(userId);
         */


        //Step 3: Send a request
        Response response=given().
                spec(specification).
                when().
                get("/{todosPath}/{idPath}");

        System.out.println("RESPONSE:");
        response.prettyPrint();
        // Step 4: Assertion

        //actualData response 'dan alınır.

        //HashMap<String,Object> actualDataMap =  response.as(HashMap.class);   // ---> NOme Problemooo


        //  JsonPath jsonPath = response.jsonPath(); ///  Json----> NOme Problemooo

        //  response.then().assertThat().body(""); /// ---> responseBody    Nome Problemo
        //  HashMap<String,Object>actualDataMap = JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class); ---> object mapper


        HashMap<String,Object> actualDataMapJSONToJAVA = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);

        System.out.println("actualDataMapJSONToJAVA: " + actualDataMapJSONToJAVA);

        //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.

        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        HashMap<String,Object> reqBodyAndExpectedDataMap=jsonPlaceHolderTestData.setUpExpectedData();

        System.out.println("reqBodyAndExpectedDataMap = " + reqBodyAndExpectedDataMap);

        /*
        ASSERTION HOMEWORK
         */


        Assert.assertEquals(reqBodyAndExpectedDataMap.get("UserId"),actualDataMapJSONToJAVA.get("UserId"));
        Assert.assertEquals(reqBodyAndExpectedDataMap.get("id"),actualDataMapJSONToJAVA.get("id"));
        Assert.assertEquals(reqBodyAndExpectedDataMap.get("completed"),actualDataMapJSONToJAVA.get("completed"));
        Assert.assertEquals(reqBodyAndExpectedDataMap.get("title"),actualDataMapJSONToJAVA.get("title"));


        //  KARŞILASTIRMADA EN KISA YOL

        for (String key:actualDataMapJSONToJAVA .keySet()){

            Assert.assertEquals(expectedDataMap.get(key),actualDataMapJSONToJAVA .get(key));

        }


        //  KARŞILASTIRMADA EN KISA YOLLARDAN BİRİ

        for (Object value:actualDataMapJSONToJAVA .values()){

            Assert.assertEquals(expectedDataMap.get(value),actualDataMapJSONToJAVA .get(value));

        }


    }
}
