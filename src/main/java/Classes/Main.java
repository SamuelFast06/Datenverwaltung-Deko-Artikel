package Classes;
public class Main {
    public static void main(String[] args) {
        Data management = new Data();

        management.reloadData();
        management.costumers.add(new Costumer("Paul", "Sobjak", new Birthdate(24, 07, 2008), new Address("Germany", "Detmold", "Blombergerstraße", "32756", "69"), "05432356234", "max@someEmail.com", "Man"));
        management.save();
        management.reloadData();
        System.out.println(management.costumers);
    }
}