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

    public static void main(String[] args) {
        DataManagement management = new DataManagement();

        management.costumers.add(new Costumer("Max", "Rose", new Birthdate(24, 07, 2008), new Address("Germany", "Detmold", "Blombergerstraße", "32756", "69"), "05432356234", "max@someEmail.com", "man"));
        management.save();
    }
}

