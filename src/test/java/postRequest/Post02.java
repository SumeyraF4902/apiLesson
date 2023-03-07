package postRequest;

import baseURLS.GoRestCoBaseURL;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.Post02PojoData;
import testData.GoRestApiTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post02 extends GoRestCoBaseURL {
    /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et create kodu 201 dir
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */

    @Test
    public void post02() {

        //Set Base URL
        //https://gorest.co.in/public/v2/users

        specification.pathParam("usersPath", "users");

        //Step 2: Set Expected and Request Body
        GoRestApiTestData goRestApiTestData=new GoRestApiTestData();
       HashMap<String,String> reqBodyAndExpectedDataMap=goRestApiTestData.reqBodyAndExpectedData("ALİ","male","task@eby","active");

        System.out.println("goRestApiTestDataMap = " + reqBodyAndExpectedDataMap);




        //Step 3:Send a request
        Response response=given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBodyAndExpectedDataMap).
                when().
                header("Authorization","Bearer 1752c8a34b3ff3abb73f7d4935d57ab101fbd2cbef303f2b9c0c29e4e42fcd5a").
                post("/{usersPath}");

        System.out.println("Response Body= " );
        response.prettyPrint();

        // Status Code un "201" olduğunu Assert et
      //  response.then().assertThat().statusCode(201);

        //Step 4: Assertion

        //Pojo kullanrak assert ediniz.

        Post02PojoData pojoExpectedDataMap=new Post02PojoData("ALİ","male","task@eby","active");

        System.out.println("pojoExpectedDataMap = " + pojoExpectedDataMap);

        Post02PojoData actualDataMap=response.as(Post02PojoData.class);
        System.out.println("actualDataMap = " + actualDataMap);


        assertEquals(pojoExpectedDataMap.getName(),actualDataMap.getName());
        assertEquals(pojoExpectedDataMap.getGender(),actualDataMap.getGender());
        assertEquals(pojoExpectedDataMap.getEmail(),actualDataMap.getEmail());
        assertEquals(pojoExpectedDataMap.getStatus(),actualDataMap.getStatus());


    }

}
