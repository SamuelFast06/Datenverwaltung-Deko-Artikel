package Classes;

import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;
import Classes.User.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        FirebaseContext firebaseContext = new FirebaseContext();
        firebaseContext.addUser(new User("pablo", "kkd", "nbjaefj"), new Management());
    }
}