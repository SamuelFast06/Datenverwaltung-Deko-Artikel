package Classes;

import Classes.Files.UserData;

import java.io.IOException;
import java.util.*;

public class DataManagement {
    ArrayList<Article> articles = new ArrayList<Article>();
    ArrayList<ContactPerson> contactPeople = new ArrayList<ContactPerson>();
    ArrayList<Costumer> costumers = new ArrayList<Costumer>();

    public DataManagement() {
        super();
    }

    public void addCostumer(Costumer costumer) {
        costumers.add(costumer);
    }

    public void removeCostumer(Costumer costumer) {
        for(int i =0; i < costumers.size(); i++) {
            if(costumer.equals(costumers.get(i))) {
                costumers.remove(costumer);
            }
        }
    }

    public void addContactPerson(ContactPerson contactPerson) {
        contactPeople.add(contactPerson);
    }

    public void removeContactPerson(ContactPerson contactPerson) {
        for(int i =0; i < contactPeople.size(); i++) {
            if(contactPerson.equals(contactPeople.get(i))) {
                costumers.remove(contactPerson);
            }
        }
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public void removeArticle(Article article) {
        for(int i =0; i < articles.size(); i++) {
            if(article.equals(articles.get(i))) {
                costumers.remove(article);
            }
        }
    }

    //Methods for managing the Data
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
            throw new Error();
        }

    }

    public void deleteAllData() {
        try {
            UserData.writeStringData("");
        } catch (IOException e) {
            System.out.println("Failed to delete all Data");
        }

        costumers = new ArrayList<Costumer>();
        contactPeople = new ArrayList<ContactPerson>();
        articles = new ArrayList<Article>();
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<ContactPerson> getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(ArrayList<ContactPerson> contactPeople) {
        this.contactPeople = contactPeople;
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;
    }

    public static void main(String[] args) {
        DataManagement management = new DataManagement();

        management.costumers.add(new Costumer("Max", "Rose", new Birthdate(24, 07, 2008), new Address("Germany", "Detmold", "Blombergerstraße", "32756", "69"), "05432356234", "max@someEmail.com", "man"));
        management.save();
    }
}

