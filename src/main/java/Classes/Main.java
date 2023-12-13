package Classes;

import Classes.Articles.Article;
import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;
import Classes.SubClasses.Measures;
import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;
import Classes.SubClasses.UnitsAndValues.WeightValue;
import Classes.User.User;

import com.fasterxml.jackson.core.*;

import java.io.IOException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {

        FirebaseContext firebaseContext = new FirebaseContext();

        Article article = new Article(UUID.randomUUID(),123,"birne", new WeightValue(),"this is a birne","green",99123.99,1000312031, new Measures());


        firebaseContext.signIn("samuel.fast@icloud.com", "SamuelFast06");
        firebaseContext.addDocument(article, article.getId().toString());


    }
}