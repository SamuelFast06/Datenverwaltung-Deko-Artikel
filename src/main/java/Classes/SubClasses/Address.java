package Classes.SubClasses;

public class Address {
    String country;
    String city;
    String street;
    String zip;
    String houseNumber;

    public Address() {
        super();
    }

    public Address(String country, String city, String street, String zip, String houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
