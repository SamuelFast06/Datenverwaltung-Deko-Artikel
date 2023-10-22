package Classes;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Data management = new Data();

        management.reloadData();
        management.addUser(new User(UUID.randomUUID(), "MaxAtslega", "MaxAtslega04  "));
        management.save();

        System.out.println(management.getUsers());
    }
}