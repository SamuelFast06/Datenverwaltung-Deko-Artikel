package Classes.User;
import java.util.*;
import java.util.ArrayList;

public class User {

    String emailAddress;
    String passwort;
    String id;
    String managementID;

    public User() {
        super();
    }

    public User(String emailAddress, String passwort, String id, String managementID) {
        this.emailAddress = emailAddress;
        this.passwort = passwort;
        this.id = id;
        this.managementID = managementID;
    }

    public String getManagementID() {
        return managementID;
    }

    public void setManagementID(String managementID) {
        this.managementID = managementID;
    }

    //getter
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getPasswort() {
        return passwort;
    }
    public String getId() {
        return id;
    }


    //setter
    public void setEmailAddress(String username) {
        this.emailAddress = username;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "User{" +
                "username='" + emailAddress + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }
}

