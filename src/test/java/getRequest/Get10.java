package getRequest;

import baseURLS.DummyRestApiBaseURL;
import com.google.gson.Gson;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.mapper.factory.Jackson1ObjectMapperFactory;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get10  extends DummyRestApiBaseURL {
    /*

    Given
	   	   https://dummy.restapiexample.com/api/v1/employees

		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
            Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
            Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular



     */
    @Test
    public void get10(){
        // STEP 1: SET UURL
        specification.pathParam("employeesPath","employees");

        // Step 2: Expected Data

        //Başkka bir classta expected dataları setleyelim

        DummyRestApiTestData dummyRestApiTestData= new DummyRestApiTestData();

        List<Map<String,Object>> expectedData=dummyRestApiTestData.setUpDummyRestTestDat();


        System.out.println("expectedData = " + expectedData);


        //n STEP 3: SEND A REQUEST
        Response response=given().
                spec(specification).
                when().
                get("/{employeesPath}");

        response.prettyPrint();

        // Assertion

        // 1 Way:

     /*   response.then().assertThat().statusCode((Integer) expectedData.get(0).get("StatusCode")).
                body("data[-1].employee_name",equalTo(expectedData.get(1).get("EmployeeName")),
                        "data[5].employee_salary",equalTo(expectedData.get(2).get("EmployeeSalary")),
                        "data.employee_age",hasItems(((List)expectedData.get(3).get("EmployeeAges")).get(0),
                                ((List)expectedData.get(3).get("EmployeeAges")).get(1),
                                ((List)expectedData.get(3).get("EmployeeAges")).get(2)));*/

        /*
        en mantıklı coozuumlerden biri ugur beyin paylaşımı

        List <Integer> yasListesi = jsonPath.getList("data.employee_age");

    List<Integer> arananYaslar = Arrays.asList(21,23,61);

     Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(arananYaslar));


     data.findAll{it.condition}.datafield
     key_value - varsa -> map  yaparız
         */


        // Homeworks:

        /*
        GSON
        JsonPath

        metotoalrını kullanarak assertion işlemlerini tamamlayınız .
         */
        JsonPath jsonPath =response.jsonPath();

       // List<String> actualData=response.jsonPath().getList("data");
        /*
        And
            Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
            Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
            Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular
         */
     //  System.out.println("actualData = " + actualData);
       // System.out.println(actualData.size());// 24
    /*    List<String> idS=jsonPath.getList("data.findAll{(it.id)=17}.employee_name");
        System.out.println(idS);
        assertTrue(idS.contains("Doris Wilder"));
       int employeeSalary=jsonPath.get("{(id=6)}.employee_salary");****
        System.out.println("employeeSix = " + employeeSalary); ***    calısmıyor
        assertEquals(employeeSalary,372000);******
      /*  List<Integer> employeeAge=jsonPath.getList("data.findAll{(it.id)>=1}.employee_age");
        assertTrue(employeeAge.contains(21));
        assertTrue(employeeAge.contains(23));
        assertTrue(employeeAge.contains(59));*/



         /*List<Map<String,Object>> actualData = response.jsonPath().getList("data");

        System.out.print("actualData = " + actualData);

        Assert.assertEquals(expectedData.get(1).get("EmployeeName"),actualData.get(actualData.size()-1).get("employee_name"));
        Assert.assertEquals(expectedData.get(2).get("EmployeeSalary"),actualData.get(5).get("employee_salary"));

        List<Integer> ages = response.jsonPath().getList("data.findAll{(it.employee_age)>0}.employee_age");


        Assert.assertTrue(ages.containsAll((List<Integer>) expectedData.get(1).get("EmployeeAges")));*/



    }
}
