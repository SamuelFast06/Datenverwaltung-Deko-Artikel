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

    private  String id;
    private String name;

    public Data() {
        super();
    }

    public Data(ArrayList<Article> articles, ArrayList<ContactPerson> contactPeople, ArrayList<Costumer> costumers, ArrayList<User> users, String id, String name) {
        this.articles = articles;
        this.contactPeople = contactPeople;
        this.costumers = costumers;
        this.users = users;
        this.id = id;
        this.name = name;

        //Sollte man das neue Management direkt zu dem Server hinzufügen (ManagementController.addManagement();) ????
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
        name = "";

        uploadDataToServer();
    }

    // The loadDataFromServer and uploadDataToServer return true if all works fine and false if not
    public Boolean loadDataFromServer() {
        try {
            URL url = new URL("https://api.jsonbin.io/v3/b/" + id + "/latest?meta=false");

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
            URL url = new URL("https://api.jsonbin.io/v3/b/" + id);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("X-Master-Key", "$2a$10$WyC.qebXhP2FTTpNm.46cu2Nf6Qi0PEf/4Qq.6P8CMS.iPNgy5avG");
            con.setRequestProperty("Content-Type", "application/json");

            con.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(new Data(articles, contactPeople, costumers, users, id, name));

            System.out.println(jsonString);

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if(con.getResponseMessage().equals("Not Found")) {
                Exception exception = new Exception();
                throw exception;
            }

        } catch(Exception e) {
            System.out.println("Something went wrong with the upload. Please try again: " + e);
            return false;
        }
        return true;
    }

    public void addCostumer(Costumer costumer) {
        costumers.add(costumer);

        uploadDataToServer();
    }

    public void overrideData(Data newData) {
        this.articles = newData.articles;
        this.contactPeople = newData.contactPeople;
        this.costumers = newData.costumers;
        this.users = newData.users;
        this.name = newData.name;

        uploadDataToServer();
    }

    public void removeCostumer(Costumer costumer) {
        for(int i =0; i < costumers.size(); i++) {
            if(costumer.equals(costumers.get(i))) {
                costumers.remove(costumer);
            }
        }

        uploadDataToServer();
    }

    public void addContactPerson(ContactPerson contactPerson) {
        contactPeople.add(contactPerson);

        uploadDataToServer();
    }

    public void removeContactPerson(ContactPerson contactPerson) {
        for(int i =0; i < contactPeople.size(); i++) {
            if(contactPerson.equals(contactPeople.get(i))) {
                costumers.remove(contactPerson);
            }
        }

        uploadDataToServer();
    }

    public void addArticle(Article article) {
        articles.add(article);

        uploadDataToServer();
    }

    public void removeArticle(Article article) {
        for(int i =0; i < articles.size(); i++) {
            if(article.equals(articles.get(i))) {
                costumers.remove(article);
            }
        }

        uploadDataToServer();
    }

    public void addUser(User user) {
        users.add(user);

        uploadDataToServer();
    }

    public void removeUser(User user) {
        for(int i =0; i < users.size(); i++) {
            if(user.equals(users.get(i))) {
                costumers.remove(user);
            }
        }

        uploadDataToServer();
    }



    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;

        uploadDataToServer();
    }

    public ArrayList<ContactPerson> getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(ArrayList<ContactPerson> contactPeople) {
        this.contactPeople = contactPeople;

        uploadDataToServer();
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;

        uploadDataToServer();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;

        uploadDataToServer();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

        uploadDataToServer();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        uploadDataToServer();
    }
}

