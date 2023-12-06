package Classes;

import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;
import Classes.User.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        FirebaseContext firebaseContext = new FirebaseContext();
        firebaseContext.addUser(new User(UUID.randomUUID().toString(), "myName@MyAddress.com", "Passwort"), new Management("TestManagement", UUID.randomUUID().toString()));
    }
}