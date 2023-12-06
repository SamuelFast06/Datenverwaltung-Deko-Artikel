package Classes.Firebase;

import Classes.Management.Management;
import Classes.User.User;

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

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;

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

    public String getDocument() throws Exception {
        ApiFuture<QuerySnapshot> query = db.collection("managements").get();
// ...
// query.get() blocks on response
        QuerySnapshot querySnapshot = query.get();
        String str = "";

        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            str += (String) document.get("name") + " ";
        }
        return str;
    }
}
