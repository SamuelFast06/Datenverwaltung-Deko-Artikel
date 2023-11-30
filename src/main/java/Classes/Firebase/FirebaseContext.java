package Classes.Firebase;

import Classes.Management.Management;
import Classes.User.User;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FirebaseContext {
    static final String API_KEY = "AIzaSyB_EYCwXOEjIjVjfNDEDvVW_SGpfaJzb-4";

    public void addUser(User user, Management management) {
        try {
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write("{\"email\":\"pablo@cock.com\",\"password\":\"pablo12345\",\"returnSecureToken\":true}");
            osw.flush();
            osw.close();
            os.close();

            connection.connect();

            System.out.println(connection.getResponseMessage());
        } catch (Exception e) {
            System.out.println("Failed to create new user: " + e.getLocalizedMessage());
        }

    }
}
