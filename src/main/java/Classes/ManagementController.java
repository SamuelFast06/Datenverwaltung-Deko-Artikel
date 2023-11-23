package Classes;

import Classes.Articles.Article;
import Classes.ContactPersons.ContactPerson;
import Classes.Costumers.Costumer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ManagementController {
    final static String id = "6537f19212a5d376598ff424";
    final static String XMASTERKEY = "$2a$10$WyC.qebXhP2FTTpNm.46cu2Nf6Qi0PEf/4Qq.6P8CMS.iPNgy5avG";

    public static ArrayList<ControlledManagement> getControlledManagements() throws IOException {
        ArrayList<ControlledManagement> controlledManagements = new ArrayList<ControlledManagement>();

        URL url = new URL("https://api.jsonbin.io/v3/b/" + id + "/latest?meta=false");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Master-Key", XMASTERKEY);

        ObjectMapper mapper = new ObjectMapper();

        ControlledManagement[] newControlledManagementsArray = mapper.readValue(con.getInputStream(), ControlledManagement[].class);

        for(int i = 0; i < newControlledManagementsArray.length; i++) {
            controlledManagements.add(newControlledManagementsArray[i]);
        }

        con.disconnect();

        return controlledManagements;
    }

    static void uploadControlledManagements(ArrayList<ControlledManagement> managements) throws IOException {
        URL url = new URL("https://api.jsonbin.io/v3/b/" + id);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("X-Master-Key", XMASTERKEY);
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(managements);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        System.out.println("Upload response: " + con.getResponseMessage());
    }

    static void addControlledManagement(ControlledManagement management) throws IOException {
        ArrayList<ControlledManagement> controlledManagements = getControlledManagements();
        controlledManagements.add(management);

        uploadControlledManagements(controlledManagements);
    }

    static void deleteManagement(String binId) throws IOException {
        ArrayList<ControlledManagement> controlledManagements = getControlledManagements();

        for(int i = 0; i < controlledManagements.size(); i++) {
            if (binId == null) {
                if (controlledManagements.get(i).binId == null) {
                    controlledManagements.remove(controlledManagements.get(i));
                }
            } else if (binId.equals(controlledManagements.get(i).binId)) {
                controlledManagements.remove(controlledManagements.get(i));
            }
        }

        uploadControlledManagements(controlledManagements);
    }

    public static Data getDataManagement(String id) throws IOException {
        URL url = new URL("https://api.jsonbin.io/v3/b/" + id + "/latest?meta=false");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Master-Key", XMASTERKEY);

        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue(con.getInputStream(), Data.class);

        con.disconnect();

        return data;
    }

    static Data getDataManagement(User user) throws IOException {
        ArrayList<ControlledManagement> controlledManagements = getControlledManagements();
        String managementId = "";

        managementLoop: for(int m = 0; m < controlledManagements.size(); m++) {
            ArrayList<User> users = controlledManagements.get(m).users;
            for(int u = 0; u < users.size(); u++) {
                if(user.username.equals(users.get(u).username) && user.passwort.equals(users.get(u).passwort)) {
                    managementId = controlledManagements.get(m).binId;
                    break managementLoop;
                }
            }
        }

        if (!managementId.isEmpty()) {
            return getDataManagement(managementId);
        }

        return null;
    }

    static Boolean usernameUnused(String username) throws IOException {
        ArrayList<ControlledManagement> controlledManagements = getControlledManagements();

        managementLoop: for(int m = 0; m < controlledManagements.size(); m++) {
            ArrayList<User> users = controlledManagements.get(m).users;
            for(int u = 0; u < users.size(); u++) {
                if(username.equals(users.get(u).username)) {
                    return false;
                }
            }
        }

        return true;
    }

    static Data createManagement(String name, User user) throws IOException {
        String binId = "";


        URL makeBinUrl = new URL("https://api.jsonbin.io/v3/b");

        HttpURLConnection con = (HttpURLConnection) makeBinUrl.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("X-Master-Key", XMASTERKEY);
        con.setRequestProperty("X-Bin-Name", name);

        con.setDoOutput(true);

        Data newManagement = new Data(new ArrayList<Article>(), new ArrayList<ContactPerson>(), new ArrayList<Costumer>(), new ArrayList<User>(), "", name);

        ObjectMapper mapper  = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String encoded = mapper.writeValueAsString(newManagement);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = encoded.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        CreateBinResponse response = mapper.readValue(con.getInputStream(), CreateBinResponse.class);
        binId = response.metadata.id;
        newManagement.setId(binId);

        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        ControlledManagement newControlledManagement = new ControlledManagement(users, binId);

        newManagement.addUser(user);

        newManagement.uploadDataToServer();
        addControlledManagement(newControlledManagement);

        System.out.println(con.getResponseMessage());

        return newManagement;
    }
}

class ControlledManagement {
    ArrayList<User> users;
    String binId;

    public ControlledManagement() {
        super();
    }

    public ControlledManagement(ArrayList<User> users, String binId) {
        this.users = users;
        this.binId = binId;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getBinId() {
        return binId;
    }

    public void setBinId(String binId) {
        this.binId = binId;
    }
}

class CreateBinResponse {
    Data record;
    CreateBinMetaData metadata;

    public CreateBinResponse() {
        super();
    }

    public Data getRecord() {
        return record;
    }

    public void setRecord(Data record) {
        this.record = record;
    }

    public CreateBinMetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(CreateBinMetaData metadata) {
        this.metadata = metadata;
    }
}

class CreateBinMetaData {
    String id;

    public CreateBinMetaData() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
