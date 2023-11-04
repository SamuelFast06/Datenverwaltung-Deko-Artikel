package Classes;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data {
    private ArrayList<Article> articles;
    private ArrayList<ContactPerson> contactPeople;
    private ArrayList<Costumer> costumers;
    private ArrayList<User> users;

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
    public Boolean save() {
        try {
            DataManager.writeData(this);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        try {
            uploadDataToServer();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Boolean reloadData() {

        // If the loading from the Server failes than load the local Data
        if(!loadDataFromServer()) {
            try {
                Data data = DataManager.getData();
                overrideData(data);
            } catch (IOException e) {
                System.out.println(e.toString());
                throw new Error();
            }
        } else {
            return true;
        }
        return false;
    }

    public Boolean deleteAllData() {
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

        return uploadDataToServer();
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

            return true;
        } catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }



    public boolean uploadDataToServer() {
        try {
            URL url = new URL("https://api.jsonbin.io/v3/b/" + id);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("X-Master-Key", "$2a$10$WyC.qebXhP2FTTpNm.46cu2Nf6Qi0PEf/4Qq.6P8CMS.iPNgy5avG");
            con.setRequestProperty("Content-Type", "application/json");

            con.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(new Data(articles, contactPeople, costumers, users, id, name));

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }return false;
    }

    public void addCostumer(Costumer costumer) {
        costumers.add(costumer);
        if(!uploadDataToServer()) {
            costumers.remove(costumer);
        }

    }

    public void overrideData(Data newData) {
        Data backupData = this;

        this.articles = newData.articles;
        this.contactPeople = newData.contactPeople;
        this.costumers = newData.costumers;
        this.users = newData.users;
        this.name = newData.name;

        if(!uploadDataToServer()) {
            this.articles = backupData.articles;
            this.contactPeople = backupData.contactPeople;
            this.costumers = backupData.costumers;
            this.users = backupData.users;
            this.name = backupData.name;
        }
    }

    public void removeCostumer(Costumer costumer) {
        costumers.remove(costumer);

        if(!uploadDataToServer()) {
            costumers.add(costumer);
        }
    }

    public void addContactPerson(ContactPerson contactPerson) {
        contactPeople.add(contactPerson);

        if(!uploadDataToServer()) {
            contactPeople.remove(contactPerson);
        }
    }

    public void removeContactPerson(ContactPerson contactPerson) {
        contactPeople.remove(contactPerson);

        if(!uploadDataToServer()) {
            contactPeople.add(contactPerson);
        }
    }

    public void addArticle(Article article) {
        articles.add(article);

        if(!uploadDataToServer()) {
            articles.remove(article);
        }
    }

    public void removeArticle(Article article) {
        articles.remove(article);

        if(!uploadDataToServer()) {
            articles.add(article);
        }
    }

    public void addUser(User user) {
        users.add(user);

        if(!uploadDataToServer()) {
            users.remove(user);
        }
    }

    public void removeUser(User user) {
        users.remove(user);

        if(!uploadDataToServer()) {
            users.add(user);
        }
    }



    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;

        //uploadDataToServer();
    }

    public ArrayList<ContactPerson> getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(ArrayList<ContactPerson> contactPeople) {
        this.contactPeople = contactPeople;

        //uploadDataToServer();
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;

        //uploadDataToServer();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;

        //uploadDataToServer();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

        //uploadDataToServer();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        //uploadDataToServer();
    }
}

