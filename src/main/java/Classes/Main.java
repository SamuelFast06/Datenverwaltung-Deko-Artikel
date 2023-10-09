package Classes;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Data management = new Data();

        management.deleteAllData();
        management.save();

        management.reloadData();
        management.addCostumer(new Costumer(UUID.randomUUID(), "Paul", "Sobjak", new Birthdate(24, 07, 2008), new Address("Germany", "Detmold", "Blombergerstraße", "32756", "69"), "05432356234", "max@someEmail.com", "Man"));
        management.addArticle(new Article(UUID.randomUUID(), 1, "Table", "20kg", "This table is very cool", "brown", 75.95, 4, new Measures(200.0, 70.0, 80.0)));
        management.addContactPerson(new ContactPerson(UUID.randomUUID(), "Fabian", "Müller", "Max Rose GmbH", "Müllerstraße 36", "Maschienenbau", "0123456789"));
        management.addUser(new User(UUID.randomUUID(), "FabianMueller", "FaMue36"));

        management.save();
        management.reloadData();
        System.out.println(management.getCostumers());
    }
}