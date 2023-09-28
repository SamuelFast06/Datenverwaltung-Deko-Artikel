package Tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();

        obj.put("name", "Test");
        obj.put("id", "12345");

        System.out.println(obj.toJSONString());

        FileWriter file = new FileWriter(new File("/Users/samuelfast/IdeaProjects/Datenverwaltung-Deko-Artikel/src/Files/UserData.json"));
        file.write(obj.toJSONString());
        file.close();

        System.out.println("File was added");
    }
}