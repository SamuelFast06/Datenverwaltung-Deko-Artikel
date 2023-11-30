package Classes.frontend;

import Classes.Costumers.*;
import Classes.User;
import Classes.User.*;
import Classes.ContactPersons.*;
import Classes.Articles.*;

import javax.swing.*;

public class DataButton<T> extends JPanel{

    private JPanel panel1;

    //Labels
    private JLabel lbName;


    T dataElement;

    public DataButton(T dataElement) {
        if (dataElement.getClass().equals(Costumer.class)) {
            Costumer costumer = (Costumer) dataElement;
            lbName.setText(costumer.getName());
        } else if (dataElement.getClass().equals(ContactPerson.class)) {
            ContactPerson contactPerson = (ContactPerson) dataElement;
            lbName.setText(contactPerson.getName());
        } else if (dataElement.getClass().equals(User.class)) {
            User user = (User) dataElement;
            lbName.setText(user.getUsername());
        }
    }

}
