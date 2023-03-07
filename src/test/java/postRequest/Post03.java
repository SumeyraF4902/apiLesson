package postRequest;

import baseURLS.DummyRestApiBaseURL;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;
import pojoDatas.DummyRestMiniPojoPost03;
import pojoDatas.DummyRestApiReqPojoPost03;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Post03 extends DummyRestApiBaseURL {

       /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */


        
    @Test
    public void post03(){

        //Step 1: Set URL
        //http://dummy.restapiexample.com/api/v1/create
        specification.pathParam("createPath", "create");


        //Step 2: Set Expected and Request Body
        /*
        {
  "name": "Drake F.",
  "salary": "40000",
  "age": "28"
}
         */

        DummyRestMiniPojoPost03 dummyMiniApiPojo=new DummyRestMiniPojoPost03("Drake F.", "40000","28");
        System.out.println("dummyMiniApiPojo = " + dummyMiniApiPojo);//dummyMiniApiPojo = DummyReatApiPojo{name='Drake F.', salary='40000', age='28'}
        /*
         {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",

    },
    "message": "Successfully! Record has been added."
}
         */
        DummyRestApiReqPojoPost03 dummyRestApiReqPojo=new DummyRestApiReqPojoPost03("success",dummyMiniApiPojo,"Successfully! Record has been added.");
        System.out.println("dummyRestApiReqPojo = " + dummyRestApiReqPojo);
        // koonsol cıktısı:dummyRestApiReqPojo = DummyRestApiReqPojo{status='success', data=DummyReatApiPojo{name='Drake F.', salary='40000', age='28'}, message='Successfully! Record has been added.'}

        //Step 3: Send a request
//Basic Auth.  ---> kullanılaak.
        // Dokumanda suth istemiyor fakat biz örnek olsun diye nasıl kukllanıalcğaını öğrenmek amaçlı olarak basic auth. ile işlem yapacağız.

        // ---> Beare token     Header da vermiştik.

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
               auth().basic("admin","password123").body(dummyMiniApiPojo).
                when().
                post("/{createPath}");


        System.out.println("Response Body: " );
        response.prettyPrint();


        //Step 4: Assertion
        //Pojo kullanrak assert ediniz.

      DummyRestApiReqPojoPost03 actualData = response.as(DummyRestApiReqPojoPost03.class);
        System.out.println("Actual Data: " + actualData);

        assertEquals(dummyRestApiReqPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyRestApiReqPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyRestApiReqPojo.getData().getAge(),actualData.getData().getAge());
        assertEquals(dummyRestApiReqPojo.getData().getName(),actualData.getData().getName());
        assertEquals(dummyRestApiReqPojo.getData().getSalary(),actualData.getData().getSalary());



    }
}
