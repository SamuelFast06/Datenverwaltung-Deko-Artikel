package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        new LoginFrame();
        /*
        try{
            Data LocalManagement = ManagementController.createManagement("LocalManageent",new User(UUID.randomUUID(), "localuser", "passwort"));
            String id = LocalManagement.getId();
            User user = LocalManagement.getUsers().get(1);
            new ManagementFrame(user,LocalManagement);
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        */
    }
}