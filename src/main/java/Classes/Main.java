package Classes;

import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        try {
            Data data = ManagementController.getDataManagement("653932ce0574da7622bd9406");
            data.addArticle(new Article(UUID.randomUUID(), 3, "Laptop", "1,2kg", "Newest Laptop on the market", "Grey", 999.99, 145, new Measures(20,28,2)));
            data.save();
        } catch (Exception e) {
            System.out.println("SWW");
        }
    }
}