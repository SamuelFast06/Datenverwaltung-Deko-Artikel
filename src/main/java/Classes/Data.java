package Classes;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data {
    private ArrayList<Article> articles = new ArrayList<Article>();
    private ArrayList<ContactPerson> contactPeople = new ArrayList<ContactPerson>();
    private ArrayList<Costumer> costumers = new ArrayList<Costumer>();
    private ArrayList<User> users = new ArrayList<User>();

    private final String urlString = "https://api.jsonbin.io/v3/b/65322cf512a5d376598e226c/latest?meta=false";

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

    //Methods for managing the Data
    public void save() {
        try {
            DataManager.writeData(this);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        uploadDataToServer();
    }

    public void reloadData() throws Error {

        // If the loading from the Server failes than load the local Data
        if(!loadDataFromServer()) {
            try {
                Data data = DataManager.getData();
                overrideData(data);
            } catch (IOException e) {
                System.out.println(e.toString());
                throw new Error();
            }
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

    // The loadDataFromServer and uploadDataToServer return true if all works fine and false if not
    public Boolean loadDataFromServer() {
        try {
            URL url = new URL(urlString);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("X-Master-Key", "$2a$10$WyC.qebXhP2FTTpNm.46cu2Nf6Qi0PEf/4Qq.6P8CMS.iPNgy5avG");

            ObjectMapper mapper = new ObjectMapper();
            Data data = mapper.readValue(con.getInputStream(), Data.class);

            overrideData(data);
            con.disconnect();
        } catch(Exception e) {
            System.out.println("The data could not be loaded from the server: " + e);
            return false;
        }
        return true;
    }



    public Boolean uploadDataToServer() {
        try {
            URL url = new URL("https://api.jsonbin.io/v3/b/65322cf512a5d376598e226c");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("X-Master-Key", "$2a$10$WyC.qebXhP2FTTpNm.46cu2Nf6Qi0PEf/4Qq.6P8CMS.iPNgy5avG");
            con.setRequestProperty("Content-Type", "application/json");

            con.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(new Data(articles, contactPeople, costumers, users));

            System.out.println(jsonString);

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            System.out.println("Upload response: " + con.getResponseMessage());

        } catch(Exception e) {
            System.out.println("Something went wrong with the upload. Please try again: " + e);
            return false;
        }
        return true;
    }

    public void addCostumer(Costumer costumer) {
        costumers.add(costumer);
    }

    public void overrideData(Data newData) {
        this.articles = newData.articles;
        this.contactPeople = newData.contactPeople;
        this.costumers = newData.costumers;
        this.users = newData.users;
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

