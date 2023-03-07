package pojoDatas;

public class DummyRestApiReqPojoPost03 {
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
    private  String status;
    private DummyRestMiniPojoPost03 data;
    private String message;

    public DummyRestApiReqPojoPost03() {
    }

    public DummyRestApiReqPojoPost03(String status, DummyRestMiniPojoPost03 data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestMiniPojoPost03 getData() {
        return data;
    }

    public void setData(DummyRestMiniPojoPost03 data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
