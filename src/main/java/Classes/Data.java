package Classes;

import java.io.IOException;
import java.util.*;

public class Data {
    private ArrayList<Article> articles = new ArrayList<Article>();
    private ArrayList<ContactPerson> contactPeople = new ArrayList<ContactPerson>();
    private ArrayList<Costumer> costumers = new ArrayList<Costumer>();
    private ArrayList<User> users = new ArrayList<User>();

    public Data() {
        super();
    }

    public Data(ArrayList<Article> articles, ArrayList<ContactPerson> contactPeople, ArrayList<Costumer> costumers, ArrayList<User> users) {
        this.articles = articles;
        this.contactPeople = contactPeople;
        this.costumers = costumers;
        this.users = users;
    }

    public Data(Boolean loadData) {
        if(loadData) {
            try {
                Data data = DataManager.getData();
                articles = data.articles;
                contactPeople = data.contactPeople;
                costumers = data.costumers;
                users = data.users;
            } catch (IOException e) {
                articles = new ArrayList<Article>();
                contactPeople = new ArrayList<ContactPerson>();
                costumers = new ArrayList<Costumer>();
                users = new ArrayList<User>();
            }
        } else {
            articles = new ArrayList<Article>();
            contactPeople = new ArrayList<ContactPerson>();
            costumers = new ArrayList<Costumer>();
            users = new ArrayList<User>();
        }
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

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        for(int i =0; i < users.size(); i++) {
            if(user.equals(users.get(i))) {
                costumers.remove(user);
            }
        }
    }

    //Methods for managing the Data
    public void save() {
        try {
            DataManager.writeData(this);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void reloadData() throws Error {
        try {
            Data data = DataManager.getData();
            articles = data.articles;
            contactPeople = data.contactPeople;
            costumers = data.costumers;
            users = data.users;
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new Error();
        }

    }

    public void deleteAllData() {
        try {
            DataManager.writeStringData("");
        } catch (IOException e) {
            System.out.println("Failed to delete all Data");
        }

        costumers = new ArrayList<Costumer>();
        contactPeople = new ArrayList<ContactPerson>();
        articles = new ArrayList<Article>();
        users = new ArrayList<User>();
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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}

