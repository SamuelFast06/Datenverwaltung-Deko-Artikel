package Classes.Firebase;

import Classes.Articles.Article;
import Classes.ContactPersons.ContactPerson;
import Classes.Costumers.Costumer;
import Classes.Management.Management;
import Classes.User.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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


    public void addUser(User user, String managementID) throws IOException, ExecutionException, InterruptedException {
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

        InputStream is = connection.getInputStream();
        FirebaseResult firebaseResult = new ObjectMapper().readValue(is, FirebaseResult.class);
        user.setId(firebaseResult.getLocalId());

        // add the user to a management or create a new one
        DocumentReference docRef = db.collection("managements").document(managementID).collection("users").document();
        Map<String, Object> data = new ObjectMapper().convertValue(user, Map.class);

        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println(result.get().getUpdateTime());

        // add the user to the users collection
        docRef = db.collection("users").document(user.getId());
        result = docRef.set(data);
        result.get();

        currentUser = user;
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
            items.add(document.toObject(classType));
        }
        return items;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class FirebaseResult {
    String kind;
    String idToken;
    String email;
    String refreshToken;
    String expiresIn;
    String localId;
    String displayName;

    public FirebaseResult() {
        super();
    }

    public FirebaseResult(String kind, String idToken, String email, String refreshToken, String expiresIn, String localId, String displayName) {
        this.kind = kind;
        this.idToken = idToken;
        this.email = email;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.localId = localId;
        this.displayName = displayName;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiredIn) {
        this.expiresIn = expiredIn;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }
}
