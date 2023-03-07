package getRequest;

import baseURLS.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.GoRestCoApiPoojoGet12;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13 extends GoRestCoBaseURL {
    /*


        Given
            https://gorest.co.in/public/v2/users/725273
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

    {
        "id": 724776,
        "name": "Divakar Guha",
        "email": "guha_divakar@witting.co",
        "gender": "male",
        "status": "active"
    }




     */

    @Test
    public void get13(){


        //Step 1:  Set URL
        //https://gorest.co.in/public/v2/users/725273
        specification.pathParams("usersPath","users",
                "idPath","723287");


        //Step 2: Expected Data

        GoRestCoApiPoojoGet12 goRestCoApiPojo = new GoRestCoApiPoojoGet12(723287,"Shivakari Ahuja",
                "ahuja_shivakari@mcglynn.io","male","inactive");

        /*
        {
"id": 723287,
"name": "Shivakari Ahuja",
"email": "ahuja_shivakari@mcglynn.io",
"gender": "male",
"status": "inactive"
}
         */
        System.out.println("GoRestCoAPİ: " + goRestCoApiPojo);


        //Step 3: Send a Request
        Response response = given().
                spec(specification).
                when().get("/{usersPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();


        //Step 4: Assertion

        //POjO --> Expected Data , Request Body,  Actual data

        GoRestCoApiPoojoGet12 actualDataPojo = response.as(GoRestCoApiPoojoGet12 .class);// actualDataPojo  yu, GoRestCoApiPoojoGet12  clasına bağladık key isimleri uyussun diye valular yine response
        // den gelecek ACTUALDATA YI VE ECPECTED DATAYI MATCH (EŞLEŞTİRMEK) İÇİN AYNI CLASIDAN OLUSTURDUK
        System.out.println("Actual Data: " + actualDataPojo);

        assertEquals(goRestCoApiPojo.getEmail(),actualDataPojo.getEmail());
        assertEquals(goRestCoApiPojo.getGender(),actualDataPojo.getGender());
        assertEquals(goRestCoApiPojo.getName(),actualDataPojo.getName());
        assertEquals(goRestCoApiPojo.getId(),actualDataPojo.getId());
        assertEquals(goRestCoApiPojo.getStatus(),actualDataPojo.getStatus());








    }

        
}

