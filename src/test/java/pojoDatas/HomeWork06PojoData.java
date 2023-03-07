package pojoDatas;

public class HomeWork06PojoData {
    /*
    {

    "id": 714224,
    "name": "Deeksha Nayar",
    "email": "deeksha_nayar@schimmel.io",
    "gender": "male",
    "status": "inactive"
}


ADIMLAR
)Fieldlar ----> Var.     PRIVATE   -------> Her bir json için
    2)Parametresiz Constructor
    3)Parametreli Constructor
    4)Gettter and Setter  FİELDLARA ULAŞMAK İCİN KULLANILIR
    5) toString()
     */

    // Fieldlar ----> Var.     PRIVATE   -------> Her bir json için
    private  int id;
    private  String name;
    private  String email;
    private  String gender;
    private  String status;


    //2)Parametresiz Constructor


    public HomeWork06PojoData() {
    }

    //2)Parametresiz Constructor

    public HomeWork06PojoData(int id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    //4)Gettter and Setter  FİELDLARA ULAŞMAK İCİN KULLANILIR


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //    5) toString()


    @Override
    public String toString() {
        return "HomeWork06PojoData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
