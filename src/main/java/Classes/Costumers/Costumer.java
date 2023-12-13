package Classes.Costumers;
import Classes.HasName;
import Classes.SubClasses.Address;
import Classes.SubClasses.Birthdate;
import Classes.SubClasses.Gender;

import java.util.*;

public class Costumer implements HasName {
    private String id;
    String firstName;
    String lastName;
    Birthdate birthdate;
    Address address;
    String mobilenumber;
    String emailAddress;
    Gender gender;

    public Costumer() {
        super();
    }

    public Costumer(String id, String firstName, String lastName, Birthdate birthdate, Address address, String mobilenumber, String emailAddress, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public String getId() { return id; }
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

    public Gender getGender() {
        return gender;
    }
    public String getName() { return "" + firstName + " " + lastName + "";}


    public void setId(String id) { this.id = id; }
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

