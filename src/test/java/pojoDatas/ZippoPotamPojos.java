package pojoDatas;

public class ZippoPotamPojos {
    /*
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

POJO Plain Old Java Object
      Expected Data veya Actual Dataları depolamak için yani tutmak için kullanıyoruz.

    1)Fieldlar ----> Var.     PRIVATE   -------> Her bir json için
    2)Parametresiz Constructor
    3)Parametreli Constructor
    4)Gettter and Setter  FİELDLARA ULAŞMAK İCİN KULLANILIR
    5) toString()
     */


    //1)Fieldlar ----> Var.     PRIVATE   -------> Her bir json için

    private  String postCode;
    private  String country;
    private  String countryAbbreviation;
    private ZippoPotamPlaces zippoPotamPlaces;         // places YERİNE PLACES İCİN OLUSTURDUUGUMUZ CLASSI KOYDUK.

    //    2)Create a without Parametresiz Constructor

    public ZippoPotamPojos() {
    }


    //    3)  Create a without Parametreli Constructor

    public ZippoPotamPojos(String postCode, String country, String countryAbbreviation, ZippoPotamPlaces zippoPotamPlaces) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.zippoPotamPlaces = zippoPotamPlaces;
    }


    //    4)Gettter and Setter  FİELDLARA ULAŞMAK İCİN KULLANILIR

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public ZippoPotamPlaces getZippoPotamPlaces() {
        return zippoPotamPlaces;
    }

    public void setZippoPotamPlaces(ZippoPotamPlaces zippoPotamPlaces) {
        this.zippoPotamPlaces = zippoPotamPlaces;
    }


    //    5) toString()


    @Override
    public String toString() {
        return "ZippoPotamPojos{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                ", zippoPotamPlaces=" + zippoPotamPlaces +
                '}';
    }
}
