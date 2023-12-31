package Classes;

import Classes.Articles.Article;
import Classes.ContactPersons.ContactPerson;
import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;
import Classes.SubClasses.Measures;
import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;
import Classes.SubClasses.UnitsAndValues.WeightValue;
import Classes.User.User;

import com.fasterxml.jackson.core.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {

        FirebaseContext firebaseContext = new FirebaseContext();

        Article article = new Article("0b174d5b-db0f-46ec-ac35-01d019b12e56",1243,"bimbim", new WeightValue(),"this is a arsch","test",323864846234.99,1, new Measures());


        firebaseContext.signIn("samuel.fast@icloud.com", "SamuelFast06");
        firebaseContext.addDocument(article);
        ArrayList list = firebaseContext.getDocuments(Article.class);

        System.out.println(list);

        //firebaseContext.removeDocument("0b174d5b-db0f-46ec-ac35-01d019b12e56" ,Article.class);
        article.setArticleName("bumbum");
        firebaseContext.editDocument(article);
    }
}