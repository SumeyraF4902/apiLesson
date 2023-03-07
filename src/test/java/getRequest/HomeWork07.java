package getRequest;

import baseURLS.HomeWork04URL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.HomeWork07PojoDatas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static testData.JsonPlaceHolderTestData.expectedData;

public class HomeWork07 extends HomeWork04URL {
    /*
        Given
            https://swapi.dev/api/starships/3
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
         {
    "name": "Star Destroyer",
    "model": "Imperial I-class Star Destroyer",
    "manufacturer": "Kuat Drive Yards",
    "cost_in_credits": "150000000",
    "length": "1,600",
    "max_atmosphering_speed": "975",
    "crew": "47,060",
    "passengers": "n/a",
    "cargo_capacity": "36000000",
    "consumables": "2 years",
    "hyperdrive_rating": "2.0",
    "MGLT": "60",
    "starship_class": "Star Destroyer",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/2/",
        "https://swapi.dev/api/films/3/"
    ],
    "created": "2014-12-10T15:08:19.848000Z",
    "edited": "2014-12-20T21:23:49.870000Z",
    "url": "https://swapi.dev/api/starships/3/"
}
     */
    @Test
    public void homeWork07(){
        // Step 1 URL
        specification.pathParams("starshipsPath","starships","idPath","3");

     /// Step 2 set Expected Data
        List<String> pilots=new ArrayList<>();
        List<String> films = new ArrayList<>();
        films.add("https://swapi.dev/api/films/1/");
        films.add("https://swapi.dev/api/films/2/");
        films.add("https://swapi.dev/api/films/3/");


        HomeWork07PojoDatas expectedData=new HomeWork07PojoDatas("Star Destroyer",
                "Imperial I-class Star Destroyer",
                "Kuat Drive Yards",
                "150000000",
                "1,600",
                "975",
                "47,060",
                "n/a",
                "36000000",
                "2 years",
                "2.0",
                "60",
                "Star Destroyer",
                pilots,
                films,
                "2014-12-10T15:08:19.848000Z",
                "2014-12-20T21:23:49.870000Z",
                "https://swapi.dev/api/starships/3/");
        System.out.println("homeWork07expectedData = " + expectedData);

        //Step 3: Send a Request
        Response response=given().
                spec(specification).when().get("/{starshipsPath}/{idPath}");
        response.prettyPrint();

        //  Status Code un "200" olduğunu Assert et
        response.then().assertThat().statusCode(200);

        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData: " + actualData);


        // Assertler
        assertEquals(expectedData.getName(),actualData.get("name"));
        assertEquals(expectedData.getModel(),actualData.get("model"));
        assertEquals(expectedData.getManufacturer(),actualData.get("manufacturer"));
        assertEquals(expectedData.getCostInCredits(),actualData.get("cost_in_credits"));
        assertEquals(expectedData.getLength(),actualData.get("length"));
        assertEquals(expectedData.getMaxAtmospheringSpeed(),actualData.get("max_atmosphering_speed"));
        assertEquals(expectedData.getCrew(),actualData.get("crew"));
        assertEquals(expectedData.getPassengers(),actualData.get("passengers"));
        assertEquals(expectedData.getCargoCapacity(),actualData.get("cargo_capacity"));
        assertEquals(expectedData.getConsumables(),actualData.get("consumables"));
        assertEquals(expectedData.getHyperdriveRating(),actualData.get("hyperdrive_rating"));
        assertEquals(expectedData.getMGLT(),actualData.get("MGLT"));
        assertEquals(expectedData.getStarshipClass(),actualData.get("starship_class"));
        assertEquals(expectedData.getPilots(),actualData.get("pilots"));
        assertEquals(expectedData.getFilms(),actualData.get("films"));
        assertEquals(expectedData.getCreated(),actualData.get("created"));
        assertEquals(expectedData.getEdited(),actualData.get("edited"));
        assertEquals(expectedData.getUrl(),actualData.get("url"));

    }
}

