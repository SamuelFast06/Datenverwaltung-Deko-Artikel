package Classes.ContactPersons;
import Classes.SubClasses.Address;
import Classes.HasName;

import java.util.*;

public class ContactPerson implements HasName {

    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private Address address;
    private String branchType;
    private String mobileNumber;

    public ContactPerson() {
        super();
    }

    public ContactPerson(String id, String firstName, String lastName, String company, Address address, String branchType, String mobileNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.branchType = branchType;
        this.mobileNumber = mobileNumber;
    }

    //getter

    public String getId() { return id; }
    public String getFirstname() {
        return firstName;
    }
    public String getLastname() {
        return lastName;
    }
    public String getCompany() {
        return company;
    }
    public Address getAddress() {
        return address;
    }
    public String getBranchtype() {
        return branchType;
    }
    public String getMobilenumber() {
        return mobileNumber;
    }

    public String getName() { return "" + firstName + " " +  lastName + "";}

    //setter

    public void setId(String id) { this.id = id; }
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setBranchtype(String branchtype) {
        this.branchType = branchtype;
    }
    public void setMobilenumber(String mobilenumber) {
        this.mobileNumber = mobilenumber;
    }

    //ToString

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", branchtype='" + branchType + '\'' +
                ", mobilenumber='" + mobileNumber + '\'' +
                '}';
    }
}
