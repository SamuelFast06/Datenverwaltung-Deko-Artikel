package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Classes.DataManagement;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;

//import static org.junit.Assert.assertEquals;
import org.json.simple.JSONObject;

public class UserData {

    final static String filePath = "/Users/samuelfast/IdeaProjects/Datenverwaltung-Deko-Artikel/src/main/java/Files/UserData.json";
    public static void writeStringData(String data) throws IOException {
        FileWriter file = new FileWriter(new File(filePath));
        file.write(data);
        file.close();
    }

    public static String getStringData() {
        String data = "";

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch(Exception e) {
            System.out.println("An error occurred.");
        }

        return data;
    }

    public static void writeData(Object data) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        String stringData = "";
        try {
            // convert user object to json string and return it
            stringData = mapper.writeValueAsString(data);
        }
        catch (JsonGenerationException | JsonMappingException  e) {
            // catch various errors
            e.printStackTrace();
        }

        FileWriter file = new FileWriter(new File(filePath));
        file.write(stringData);
        file.close();
    }

    public static DataManagement getData() throws java.io.IOException, java.lang.ClassNotFoundException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(getStringData());
        //JavaType type = mapper.getTypeFactory().constructType(T);

        DataManagement data = mapper.convertValue(jsonNode, DataManagement.class);
        return data;

    }

    public static void main(String[] agrs) throws IOException, ClassNotFoundException{

        DataManagement data = getData();
        ObjectMapper mapper = new ObjectMapper();

        String stringData = mapper.writeValueAsString(data);
        System.out.println(stringData);
    }
}

class Car {

    public String color;
    public String type;

    // standard getters setters
}
