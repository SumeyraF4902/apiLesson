package getRequest;

import baseURLS.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.HomeWork06PojoData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HomeWork06 extends GoRestCoBaseURL {
    /*
    Given
            https://gorest.co.in/public/v2/users/713683
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
      {

    "id": 713683,
    "name": "Chandni Sinha",
    "email": "chandni_sinha@ohara-sporer.name",
    "gender": "male",
    "status": "active"
}
     */
    @Test
    public void homeWork(){

        // Step 1 URL
        specification.pathParams("usersPath", "users","idPath","713683");

        // Step 2 set Expected Data
      HomeWork06PojoData expectedData=new HomeWork06PojoData(713683, "Chandni Sinha", "chandni_sinha@ohara-sporer.name", "male", "active");
        System.out.println("expectedData = " + expectedData);

        //Step 3: Send a Request)

        Response response=given().
                spec(specification).when().get("/{usersPath}/{idPath}");
        System.out.println("Response");
        response.prettyPrint();

       // Status Code un "200" olduğunu Assert et
        response.then().assertThat().statusCode(200);

        //Step 4: Assertion with GSON
       Map<String,Object> actualDataMap=response.as(HashMap.class);

        System.out.println("Actual Data: " + actualDataMap);
        assertEquals(expectedData.getId(), actualDataMap.get("id"));
        assertEquals(expectedData.getName(), actualDataMap.get("name"));
        assertEquals(expectedData.getEmail(), actualDataMap.get("email"));
        assertEquals(expectedData.getGender(), actualDataMap.get("gender"));
        assertEquals(expectedData.getStatus(), actualDataMap.get("status"));

    }
}
