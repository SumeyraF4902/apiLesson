package getRequest;

import baseURLS.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestCoApiPoojoGet12;
import utilities.JsonToJava;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12  extends GoRestCoBaseURL {
    /*


        Given
            https://gorest.co.in/public/v2/users/724774
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

(Json formatında)
    {
    "id": 724774,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}



     */
    @Test
    public void get12(){


        //Step 1: Set URL
        //https://gorest.co.in/public/v2/users/724774
        specification.pathParams("usersPath","users",
                "idPath","724774");




        //Step 2: Set Expected Data


        String expectedData ="{\"id\":724774,\"name\":\"Amb. Dhaanyalakshmi Namboothiri\",\"email\":\"dhaanyalakshmi_namboothiri_amb@grimes.biz\",\"gender\":\"male\",\"status\":\"inactive\"}";
        //Object Mapper
       /*
       Object Mapper ı kullanaiblmek için
       maven projelerinde pom.xml
       dependcy eklemem gerekiyor.  --->> maven repo

        */

        System.out.println("Expected Data:\n " + expectedData);


        GoRestCoApiPoojoGet12 goRestCoApiPoojoGet12= JsonToJava.convertJsonToJavaObject(expectedData, GoRestCoApiPoojoGet12.class);
        System.out.println("goRestCoApiPoojoGet12 = " + goRestCoApiPoojoGet12);

        HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap: " + expectedDataMap );

        //Step 3:

        Response response=given().
                spec(specification).when().get("/{usersPath}/{idPath}");
        System.out.println("RESPONSE:");
        response.prettyPrint();

        //STEP 4 ASSERTION

        HashMap<String,Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);// json formatını javada hashmapa cevirdik.  response.asString() i,HashMap.classa cevirdik
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("gender"),actualDataMap.get("gender"));
        assertEquals(expectedDataMap.get("name"),actualDataMap.get("name"));
        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("email"),actualDataMap.get("email"));
        assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));


    }

}

