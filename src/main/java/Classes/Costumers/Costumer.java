package Classes.Costumers;
import Classes.HasName;

import java.util.*;

public class Costumer implements HasName {
    private UUID id;
    String firstName;
    String lastName;
    Birthdate birthdate;
    Address address;
    String mobilenumber;
    String emailAddress;
    String gender;

    public Costumer() {
        super();
    }

    public Costumer(UUID id, String firstName, String lastName, Birthdate birthdate, Address address, String mobilenumber, String emailAddress, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public UUID getId() { return id; }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Birthdate getBirthdate() {
        return birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getGender() {
        return gender;
    }
    public String getName() { return "" + firstName + " " + lastName + "";}


    public void setId(UUID id) { this.id = id; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(Birthdate birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

class Birthdate {
    int day;
    int month;
    int year;

    public Birthdate() {
        super();
    }

    public Birthdate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class Address {
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

enum Gender{
    man,
    woman,
    divers
}