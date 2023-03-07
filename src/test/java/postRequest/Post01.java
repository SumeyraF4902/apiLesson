package postRequest;

import baseURLS.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends GoRestCoBaseURL {
     /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et  requuest boody olmadığı(boş olduğu ) için 422 gönderir

   */


    @Test
    public void post01(){

        //Set URL
        //https://gorest.co.in/public/v2/users
        specification.pathParam("usersPath","users");

        // Set Expected Data
        GoRestApiTestData goRestApiTestData=new GoRestApiTestData();
        System.out.println("goRestApiTestData = " + goRestApiTestData.statusCodeForPostInvalid());

           //Send a Request
        Response response=given().
                spec(specification).
                when().
                header("Authorization","Bearer 1752c8a34b3ff3abb73f7d4935d57ab101fbd2cbef303f2b9c0c29e4e42fcd5a").
                post("/{usersPath}");

        System.out.println("response = ");
        response.prettyPrint();


        //Assertion
        assertEquals(goRestApiTestData.statusCodeForPostInvalid(),response.getStatusCode());

        response.then().assertThat().statusCode(422);
    }}
