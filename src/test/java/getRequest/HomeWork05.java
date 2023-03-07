package getRequest;

import baseURLS.HomeWork04URL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HomeWork05 extends HomeWork04URL {
    /*
    Given
             https://swapi.dev/api/vehicles/7
        When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
             Response body nin bu şekilde olduğunu doğrular
{
    "name": "X-34 landspeeder",
    "model": "X-34 landspeeder",
    "manufacturer": "SoroSuub Corporation",
    "cost_in_credits": "10550",
    "length": "3.4 ",
    "max_atmosphering_speed": "250",
    "crew": "1",
    "passengers": "1",
    "cargo_capacity": "5",
    "consumables": "unknown",
    "vehicle_class": "repulsorcraft",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/"
    ],
    "created": "2014-12-10T16:13:52.586000Z",
    "edited": "2014-12-20T21:30:21.668000Z",
    "url": "https://swapi.dev/api/vehicles/7/"
}
     */
    @Test
    public void homeWork05(){
        //Kullanıcı GET Methodu ile Request Gönderir
        specification.pathParams("vehiclesPath", "vehicles", "idPath", "7");
        Response response =given().
                spec(specification).
                when().
                get("/{vehiclesPath}/{idPath}");

        response.prettyPrint();// prettyPrint kullanırsak icerisinde neler var görürüz

        //Status Code un "200" olduğunu Assert et
        response.then().assertThat().statusCode(200);
    }
}
