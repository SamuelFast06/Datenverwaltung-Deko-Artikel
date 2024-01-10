package Classes;

import Classes.Articles.Article;
import Classes.ContactPersons.ContactPerson;
import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;
import Classes.Management.Settings;
import Classes.SubClasses.Measures;
import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;
import Classes.SubClasses.UnitsAndValues.WeightValue;
import Classes.User.User;

import Classes.frontend.Frames.LoginFrame;
import com.fasterxml.jackson.core.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {

        LoginFrame loginFrame = new LoginFrame();

        //FirebaseContext firebaseContext = new FirebaseContext();

        //firebaseContext.createManagementWithUser(new User("samuel.fast@abcde.com", "SamuelFast06", UUID.randomUUID().toString(), ""), new Management("TSTMNG", UUID.randomUUID().toString(), new Settings("")));
    }
}