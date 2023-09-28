package Tests;

import java.io.DataInput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/samuelfast/IdeaProjects/Datenverwaltung-Deko-Artikel/src/main/java/Tests/test.json";
        ObjectMapper mapper = new ObjectMapper();

        //TestClass data = new TestClass("no", new TestClass2(5));

        /*String stringData = "";
        try {
            // convert user object to json string and return it
            stringData = mapper.writeValueAsString(data);
        } catch (JsonGenerationException | JsonMappingException e) {
            // catch various errors
            e.printStackTrace();
        }
        FileWriter file = new FileWriter(new File(filePath));
        file.write(stringData);
        file.close();*/

        String data = "";

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }

        TestClass testClass = mapper.readValue(data, TestClass.class);

        System.out.println(testClass);
    }
}

class TestClass {
    private String string;
    private TestClass2 number;

    public TestClass2 getNumber() {
        return number;
    }

    public void setNumber(TestClass2 number) {
        this.number = number;
    }


    public TestClass() {
        super();
    }
    public TestClass(String string, TestClass2 number) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        this.string = string;
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

class TestClass2 {
    int number;

    public TestClass2() {
        super();
    }
    public TestClass2(int number) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException{
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}