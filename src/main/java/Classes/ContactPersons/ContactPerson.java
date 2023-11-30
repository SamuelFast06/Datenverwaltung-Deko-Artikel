package Classes.ContactPersons;
import Classes.SubClasses.Address;
import Classes.HasName;

import java.util.*;

public class ContactPerson implements HasName {

    private UUID id;
    private String firstname;
    private String lastname;
    private String company;
    private Address address;
    private String branchtype;
    private String mobilenumber;

    public ContactPerson() {
        super();
    }

    public ContactPerson(UUID id, String firstname, String lastname, String company, Address address, String branchtype, String mobilenumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.branchtype = branchtype;
        this.mobilenumber = mobilenumber;
    }

    //getter

    public UUID getId() { return id; }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getCompany() {
        return company;
    }
    public Address getAddress() {
        return address;
    }
    public String getBranchtype() {
        return branchtype;
    }
    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getName() { return "" + firstname + " " +  lastname + "";}

    //setter

    public void setId(UUID id) { this.id = id; }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setBranchtype(String branchtype) {
        this.branchtype = branchtype;
    }
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    //ToString

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", branchtype='" + branchtype + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                '}';
    }
}
