package Classes;
import java.util.*;
import java.util.ArrayList;

public class User {

    String username;
    String passwort;
    UUID id;

    public User() {
        super();
    }

    public User(UUID id, String username, String passwort) {
        this.username = username;
        this.passwort = passwort;
        this.id = id;
    }

    //getter
    public String getUsername() {
        return username;
    }
    public String getPasswort() {
        return passwort;
    }
    public UUID getId() {
        return id;
    }


    //setter
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }
}

