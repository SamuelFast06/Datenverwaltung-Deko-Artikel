class Costumer {
    String firstName;
    String lastName;
    Birthdate birthdate;
    Address address;
    String mobilenumber;
    String emailAddress;
    Gender gender;

    public Costumer(String firstName, String lastName, Birthdate birthdate, Address address, String mobileNumber, String emailAddress, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.mobilenumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

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

class Birthdate {
    int day;
    int month;
    int year;
}

class Address {
    String country;
    String city;
    String street;
    String zip;
    String houseNumber;

    public Address(String country, String city, String street, String zip, String houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.houseNumber = houseNumber;
    }
}

enum Gender{
    man,
    woman,
    divers
}