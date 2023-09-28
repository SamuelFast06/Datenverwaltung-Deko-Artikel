package Classes;

import java.util.ArrayList;

public class User {

    String username;
    String passwort;
    int id;

    public User(String iusername, String ipasswort, int iid){
        username = iusername;
        passwort = ipasswort;
        id = iid;
    }

    //getter
    public String getUsername() {
        return username;
    }
    public String getPasswort() {
        return passwort;
    }
    public int getId() {
        return id;
    }


    //setter
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }










}

