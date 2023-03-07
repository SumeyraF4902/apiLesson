package getRequest;

import baseURLS.ApiZippopotamBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.ZippoPotamPlaces;
import pojoDatas.ZippoPotamPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get11 extends ApiZippopotamBaseURL {
    /*


        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}

     */
    @Test
    public void get11(){
        // Step 1 URL
        specification.pathParams("countryPath","TR","postCodePath","34010");

        // Step 2 set Expected Data (Test caseden alınır)    her zaman içerdekinden başla yani 1 den
       /* { ---> bu bölüm için ZippoPotamPojos clası açtık bu nu orada yapacağız    2. ADIM. 1 Cİ ADIMDAKİLERİ DE KAPSAYACAK

            "post code": "34010",
                "country": "Turkey",
                "country abbreviation": "TR",

                 ********************************
                "places": [---> bu bölüm için ZippoPotamPlaces clası açtık bu nu orada yapacağız    1.ADIM
            {
                "place name": "Maltepe Mah.",
                    "longitude": "32.3609",
                    "state": "İstanbul",
                    "state abbreviation": "34",
                    "latitude": "40.1589"
            }
    ]*********************************
        }*/

        ZippoPotamPlaces zippoPotamPlaces=new ZippoPotamPlaces("Maltepe Mah.", "32.3609", "İstanbul", "34", "40.1589");

        ZippoPotamPojos zippoPotamPojos=new ZippoPotamPojos("34010","Turkey", "TR",zippoPotamPlaces);

        System.out.println("zippoPotamPojos = " + zippoPotamPojos);

        // Step 3  Kullanıcı GET Methodu ile Request Gönderir  ( //Step 3: Send a Request)

        Response response=given().
                spec(specification).
                when().
                get("/{countryPath}/{postCodePath}");

      //  response.prettyPrint();


        //Step 4: Assertion with GSON
        Map<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println("Actual Data: " + actualDataMap);

        //---> zippoPotamPojos Expected Dataları ----  actualDataMap =Actual Datalar simdi bunları karsılastırıyoruz

        //get(key)

        assertEquals(zippoPotamPojos.getCountry(), actualDataMap.get("country"));
        assertEquals(zippoPotamPojos.getPostCode(), actualDataMap.get("post code"));
        assertEquals(zippoPotamPojos.getCountryAbbreviation(), actualDataMap.get("country abbreviation"));
       assertEquals(zippoPotamPojos.getZippoPotamPlaces().getPlaceName(),(((Map)((List)actualDataMap.get("places")).get(0))).get("place name"));
       assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLatitude(),(((Map)((List)actualDataMap.get("places")).get(0))).get("latitude"));




    }
}
