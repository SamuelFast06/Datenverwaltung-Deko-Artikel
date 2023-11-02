package Classes;

import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        try {
            ManagementController.createManagement("ProMax", new User(UUID.randomUUID(), "FelixMenze", "MenzeFelix06"));
        } catch (Exception e) {
            System.out.println("SWW");
        }
    }
}