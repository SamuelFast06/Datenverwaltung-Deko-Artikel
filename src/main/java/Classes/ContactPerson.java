package Classes;

public class ContactPerson {

    private String firstname;
    private String lastname;
    private String company;
    private String address;
    private String branchtype;
    private String mobilenumber;

    public ContactPerson(String ifirstname, String ilastname, String icompany, String iaddress, String ibranchtype, String imobilenumber){
        firstname = ifirstname;
        lastname = ilastname;
        company = icompany;
        address = iaddress;
        branchtype = ibranchtype;
        mobilenumber = imobilenumber;
    }

    //getter
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getCompany() {
        return company;
    }
    public String getAddress() {
        return address;
    }
    public String getBranchtype() {
        return branchtype;
    }
    public String getMobilenumber() {
        return mobilenumber;
    }

    //setter
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBranchtype(String branchtype) {
        this.branchtype = branchtype;
    }
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    //ToString
    public String toString() {
        return "ContactPerson{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", branchtype='" + branchtype + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                '}';
    }
}
