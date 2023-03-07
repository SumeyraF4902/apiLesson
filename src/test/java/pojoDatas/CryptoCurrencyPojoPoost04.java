package pojoDatas;

public class CryptoCurrencyPojoPoost04 {
    /*
     {
    "cryptocurrency": "BTC",
    "customer": {
        "reference_id": "20625123425",  //merch.code
        "first_name":"",
        "last_name":"",
        "email":"drakeF@gmail.com"
    }
}
     */
    private String cryptocurrency;
    private CustomerInfoPojoPost04 customer;

    public CryptoCurrencyPojoPoost04() {
    }

    public CryptoCurrencyPojoPoost04(String cryptocurrency, CustomerInfoPojoPost04 customer) {
        this.cryptocurrency = cryptocurrency;
        this.customer = customer;
    }

    public String getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(String cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public CustomerInfoPojoPost04 getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoPojoPost04 customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CryptoCurrencyPojoPoost04{" +
                "cryptocurrency='" + cryptocurrency + '\'' +
                ", customer=" + customer +
                '}';
    }
}
