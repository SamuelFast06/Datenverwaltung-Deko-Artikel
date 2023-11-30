package Classes.User;
import java.util.*;
import java.util.ArrayList;

public class User {

    String emailAddress;
    String passwort;
    String id;

    public User() {
        super();
    }

    public User(String id, String emailAddress, String passwort) {
        this.emailAddress = emailAddress;
        this.passwort = passwort;
        this.id = id;
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

