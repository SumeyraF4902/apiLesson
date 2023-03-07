package getRequest;

import baseURLS.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07  extends DummyRestApiBaseURL {
     /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And
*/
    @Test
    public void get07(){
/*
        1) Set URL
        2) Set Expected Data
        3) Send a Request
        4) Assertion
         */
        // STep 1: Set URL
        //https://dummy.restapiexample.com/api/v1/employe

        specification.pathParam("employeesPath","employees");

        // Step 2: Expected Data (ignored)
        // Step 3: Send a request

        Response response =given().
                spec(specification).
                when().
                get("/{employeesPath}");
        response.prettyPrint();

        //Step 4: Assertion
        response.then().assertThat().statusCode(200);

        //  employee_age i 55'ten büyük olanları konsola yazdırınız.
        JsonPath jsonPath=response.jsonPath();
        List<Integer> employeeAges=jsonPath.getList("data.employee_age");
        System.out.println("employeeAges = " + employeeAges);


        // 55'ten büyük olanların 8 tane olduğunu assert ediniz.
        int count=0;
        for(Integer w: employeeAges){
            if(w>55){
                count++;
            }
        }
        System.out.println("count = " + count);
        assertEquals(count,8);

        //  id si 17 den büyük olanları konsola yazdırınız

       /*  id lerin tamamını böyle alıp üstteki örnekteki gibi for ile 17 den büyük olanları yazdırabililriz    1 YOL
        List<Integer> idS=jsonPath.getList("data.id");
        System.out.println("idS = " + idS);*/


        // 2 YOL  kısa yol lambdada yapar gibi
        List<Integer> idS=jsonPath.getList("data.findAll{(it.id)>17}.id");// id si 17 den büyük id ler
        System.out.println("idS = " + idS);// idS = [18, 19, 20, 21, 22, 23, 24]

       // List<Integer> idS=jsonPath.getList("data.findAll{(it.id)>17}.employee_salary");   id si 17 den büyük olan employee_salary getir

        // 7 tane olduğunu assert ediniz.
        assertEquals(7, idS.size());

        // salary si 100.000'den az olanları konsola yazdırınız.
        List<String> salary=jsonPath.getList("data.findAll{(it.employee_salary)<100000}.employee_name");
        System.out.println("salary= " + salary);
        //            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        Assert.assertTrue(salary.contains("Doris Wilder"));
    }
}
