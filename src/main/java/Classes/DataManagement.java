package Classes;

import Classes.Files.UserData;

import java.io.IOException;
import java.util.*;

public class DataManagement {
    ArrayList<Article> articles = new ArrayList<Article>();
    ArrayList<ContactPerson> contactPeople = new ArrayList<ContactPerson>();
    ArrayList<Costumer> costumers = new ArrayList<Costumer>();

    public void save() {
        try {
            UserData.writeData(this);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void reloadData() throws Error {
        try {
            DataManagement data = UserData.getData();
            articles = data.articles;
            contactPeople = data.contactPeople;
            costumers = data.costumers;
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        throw new Error();
    }
}

