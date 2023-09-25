package Tests;

import java.io.FileWriter;
import java.io.IOException;
//import java.io.;
import org.json.simple.JSONObject;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();

        obj.put("name", "Test");
        obj.put("id", "12345");

        System.out.println(obj.toJSONString());

        FileWriter file = new FileWriter("Tests/json/test.json", false);
        file.write(obj.toJSONString());
        file.close();

        System.out.println("File was added");
    }
}