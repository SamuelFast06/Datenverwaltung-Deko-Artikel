package Classes;

public class ContactPerson {

    private String firstname;
    private String lastname;
    private String company;
    private String address;
    private String branchtype;

    public ContactPerson(String ifirstname, String ilastname, String icompany, String iaddress, String ibranchtype){
        firstname = ifirstname;
        lastname = ilastname;
        company = icompany;
        address = iaddress;
        branchtype = ibranchtype;
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

    //ToString
    public String toString() {
        return "ContactPerson{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", branchtype='" + branchtype + '\'' +
                '}';
    }
}
