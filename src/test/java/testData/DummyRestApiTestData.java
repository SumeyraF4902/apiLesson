package testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyRestApiTestData {
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
    public List<Map<String,Object>> expectedDataList=new ArrayList<>();

    public List<Map<String,Object>>setUpDummyRestTestDat() {

        //1. Expected Data
        HashMap<String, Object> expectedDataStatus = new HashMap<>();
        expectedDataStatus.put("StatusCode", 200);

        // 2.Expected Data
        HashMap<String, Object> expectedDataName = new HashMap<>();
        expectedDataName.put("EmployeeName", "Doris Wilder");

        //3.Expected Data
        HashMap<String, Object> expectedDataSalary = new HashMap<>();
        expectedDataSalary.put("EmployeeSalary", 372000);

        //4.Expected Data
        List<Integer> expectedDataAges = new ArrayList<>();
        expectedDataAges.add(21);
        expectedDataAges.add(23);
        expectedDataAges.add(59);

        HashMap<String, Object> expectedDataMapAges = new HashMap<>();
        expectedDataMapAges.put("EmployeeAges", expectedDataAges);

        expectedDataList.add(expectedDataStatus);
        expectedDataList.add(expectedDataName);
        expectedDataList.add(expectedDataSalary);
        expectedDataList.add(expectedDataMapAges);

        return expectedDataList;

    }

        public HashMap<String,String>setExpectedDataForDelete(String status,String data ,String message){ //  DELETE02 CLASI ICIN ;

            /*    {
                        "status": "success",
                "data": "719",
                "message": "Successfully! Record has been deleted"
}*/

            HashMap<String,String> expectedData=new HashMap<>();
            expectedData.put("status", status);
            expectedData.put("data", data);
            expectedData.put("message", message);

            return expectedData;


    }
}
