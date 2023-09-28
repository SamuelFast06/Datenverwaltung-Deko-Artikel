package Classes;

public class User {

    String username;
    String passwort;

    public User(String iusername, String ipasswort){
        username = iusername;
        passwort = ipasswort;
    }

    public String getUsername() {
        return username;
    }
    public String getPasswort() {
        return passwort;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }
}

