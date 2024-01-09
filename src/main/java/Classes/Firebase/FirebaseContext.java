package Classes.Firebase;

import Classes.Articles.Article;
import Classes.ContactPersons.ContactPerson;
import Classes.Costumers.Costumer;
import Classes.Management.Management;
import Classes.User.User;
import com.fasterxml.jackson.databind.*;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirebaseContext {
    static final String API_KEY = "AIzaSyB_EYCwXOEjIjVjfNDEDvVW_SGpfaJzb-4";
    FileInputStream serviceAccount = new FileInputStream("src/main/java/Classes/Firebase/dekodatamanagement-firebase-adminsdk-j68m3-f3792ab492.json");
    FirestoreOptions firestoreOptions =
            FirestoreOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    //.setDatabaseId()
                    .build();


    Firestore db = firestoreOptions.getService();

    public FirebaseContext() throws IOException {
        currentUser = null;
    }

    User currentUser;

    public void addUser(User user, Management management) {
        try {
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write("{\"email\":\"" + user.getEmailAddress() + "\",\"password\":\"" + user.getPasswort() + "\",\"returnSecureToken\":true}");
            osw.flush();
            osw.close();
            os.close();

            connection.connect();

            System.out.println(connection.getResponseMessage());

            // add the user to a management or create a new one
            DocumentReference docRef = db.collection("managements").document(management.getId()).collection("users").document();
            Map<String, Object> data = new HashMap<>();
            data.put("emailAddress", user.getEmailAddress());
            data.put("id", user.getId());
            data.put("managementID", management.getId());
            data.put("passwort", user.getPasswort());
            data.put("user", user);

            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println(result.get().getUpdateTime());

            // add the user to the users collection
            docRef = db.collection("users").document(user.getId());
            result = docRef.set(data);
            result.get();
        } catch (Exception e) {
            System.out.println("Failed to create new user: " + e.getLocalizedMessage());
        }
    }

    public void signIn(String emailAddress, String passwort) throws IOException, ExecutionException, InterruptedException {
        URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.addRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write("{\"email\":\"" + emailAddress + "\",\"password\":\"" + passwort + "\",\"returnSecureToken\":true}");
        osw.flush();
        osw.close();
        os.close();

        connection.connect();

        System.out.println(connection.getResponseMessage());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode firebaseResult = mapper.readTree(connection.getInputStream());
        String uid = firebaseResult.get("localId").asText();
        currentUser = db.collection("users").document(uid).get().get().toObject(User.class);
    }

    public <T> ArrayList<T> getDocuments(Class<T> classType) throws Exception {
        String key = "";
        if (classType == Article.class) {
            key = "Articles";
        } else if (classType == Costumer.class) {
            key = "Costumers";
        } else if (classType == ContactPerson.class) {
            key = "ContactPeople";
        } else if (classType == User.class) {
            key = "Users";
        }

        ApiFuture<QuerySnapshot> query = db.collection("managements").document(currentUser.getManagementID()).collection(key).get();

        ArrayList<T> items = new ArrayList<>();

        QuerySnapshot querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println(document.getData());
            items.add(document.toObject(classType));
        }
        return items;
    }

    public <T> void addDocument(T item, String docId){
        try {
        String key = "";

        if (item.getClass() == Article.class) {
            key = "Articles";
        } else if (item.getClass() == Costumer.class) {
            key = "Costumers";
        } else if (item.getClass() == ContactPerson.class) {
            key = "ContactPeople";
        } else if (item.getClass() == User.class) {
            key = "Users";
        }

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = mapper.convertValue(item, Map.class);


        CollectionReference collRef = db.collection("managements").document(currentUser.getManagementID()).collection(key);
        ApiFuture<WriteResult> result = db.collection("managements").document(currentUser.getManagementID()).collection(key).document(docId).set(data);
        System.out.println("added Document: " + item);
        System.out.println(result.get().getUpdateTime());

        } catch (Exception e) {
            System.out.println("Failed to add Document: " + e.getLocalizedMessage());
        }


    }

    public <T> void removeDocument(String docId,Class<T> classType){
        try{
        String key = "";
        if (classType == Article.class) {
            key = "Articles";
        } else if (classType == Costumer.class) {
            key = "Costumers";
        } else if (classType == ContactPerson.class) {
            key = "ContactPeople";
        } else if (classType == User.class) {
            key = "Users";
        }

        CollectionReference collRef = db.collection("managements").document(currentUser.getManagementID()).collection(key);
        ApiFuture<WriteResult> result = db.collection("managements").document(currentUser.getManagementID()).collection(key).document(docId).delete();
        System.out.println("removed Document: " + collRef.document(docId));
        System.out.println(result.get().getUpdateTime());

        } catch (Exception e) {
        System.out.println("Failed to remove Document: " + e.getLocalizedMessage());
        }

    }

    public <T> void editDocument(T item){
        try {
            String key = "";
            String docId;

            if (item.getClass() == Article.class) {
                key = "Articles";
                docId = ((Article) item).getId();
            } else if (item.getClass() == Costumer.class) {
                key = "Costumers";
                docId = ((Costumer) item).getId();
            } else if (item.getClass() == ContactPerson.class) {
                key = "ContactPeople";
                docId = ((ContactPerson) item).getId();
            } else if (item.getClass() == User.class) {
                key = "Users";
                docId = ((User) item).getId();
            } else{
                docId = null;
            }

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> data = mapper.convertValue(item, Map.class);

            CollectionReference collRef = db.collection("managements").document(currentUser.getManagementID()).collection(key);
            ApiFuture<WriteResult> result = db.collection("managements").document(currentUser.getManagementID()).collection(key).document(docId).set(data);
            System.out.println("edit Document: " + item);
            System.out.println(result.get().getUpdateTime());

        } catch (Exception e) {
            System.out.println("Failed to remove Document: " + e.getLocalizedMessage());
        }
    }
}
