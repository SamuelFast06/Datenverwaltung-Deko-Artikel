package Classes;
public class Main {
    public static void main(String[] args) {
        DataManagement management = new DataManagement();

        management.costumers.add(new Costumer("Max", "Rose", new Birthdate(24, 07, 2008), new Address("Germany", "Detmold", "Blombergerstraße", "32756", "69"), "05432356234", "max@someEmail.com", "Man"));
        management.save();
    }
}