package pojoDatas;

import java.util.List;

public class HomeWork07PojoDatas {
    /*
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

ADIMLAR
Fieldlar ----> Var.     PRIVATE   -------> Her bir json için
    2)Parametresiz Constructor
    3)Parametreli Constructor
    4)Gettter and Setter  FİELDLARA ULAŞMAK İCİN KULLANILIR
    5) toString()
     */

    //Fieldlar ----> Var.     PRIVATE   -------> Her bir json için
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String MGLT;
    private String starshipClass;
    private List<String> pilots;
    private List<String > films;
    private String created;
    private String edited;
    private String url;

 //  2)Parametresiz Constructor

    public HomeWork07PojoDatas() {
    }


    //   3)Parametreli Constructor

    public HomeWork07PojoDatas(String name, String model, String manufacturer, String costInCredits, String length, String maxAtmospheringSpeed, String crew, String passengers, String cargoCapacity, String consumables, String hyperdriveRating, String MGLT, String starshipClass, List<String> pilots, List<String> films, String created, String edited, String url) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperdriveRating = hyperdriveRating;
        this.MGLT = MGLT;
        this.starshipClass = starshipClass;
        this.pilots = pilots;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }


    //  4)Gettter and Setter  FİELDLARA ULAŞMAK İCİN KULLANILIR

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMGLT() {
        return MGLT;
    }

    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    //5) toString()


    @Override
    public String toString() {
        return "HomeWork07PojoDatas{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", costInCredits=" + costInCredits +
                ", length=" + length +
                ", maxAtmospheringSpeed=" + maxAtmospheringSpeed +
                ", crew=" + crew +
                ", passengers='" + passengers + '\'' +
                ", cargoCapacity=" + cargoCapacity +
                ", consumables='" + consumables + '\'' +
                ", hyperdriveRating=" + hyperdriveRating +
                ", MGLT=" + MGLT +
                ", starshipClass='" + starshipClass + '\'' +
                ", pilots=" + pilots +
                ", films=" + films +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

