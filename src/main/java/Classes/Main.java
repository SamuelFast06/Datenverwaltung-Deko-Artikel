package Classes;

import Classes.Articles.Article;
import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;
import Classes.SubClasses.Measures;
import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;
import Classes.SubClasses.UnitsAndValues.WeightValue;
import Classes.User.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {


        FirebaseContext firebaseContext = new FirebaseContext();

        Article article = new Article(UUID.randomUUID(),123,"banane", new WeightValue(),"this is a banana","yellow",5.99,100, new Measures());

        firebaseContext.addDocument(article, article.getId().toString());


    }
}