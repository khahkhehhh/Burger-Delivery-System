public class Address {
    String street;
    String city;
    
    public Address(String street, String city )
    {
        this.street=street;
        this.city=city;
    }

    public String toString(){
        return street + ", " + city;
    }
}


