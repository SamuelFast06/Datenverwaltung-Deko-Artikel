package Classes.Costumers;

import Classes.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class AddCostumerFrame extends JFrame{

    private JPanel addCustomerPane;

    //labels
    private JLabel lbHeadline;
    private JLabel lbLastName;
    private JLabel lbGender;
    private JLabel lbMobilenumber;
    private JLabel lbFirstName;
    private JLabel lbMessage;
    private JLabel lbImage;
    private JLabel lbAddress;
    private JLabel lbCountry;
    private JLabel lbCity;
    private JLabel lbStreet;
    private JLabel lbZip;
    private JLabel lbHouseNumber;
    private JLabel lbBirthdate;
    private JLabel lbEmail;

    //TextFields
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfGender;
    private JTextField tfMobilenumber;
    private JTextField tfDay;
    private JTextField tfMonth;
    private JTextField tfYear;
    private JTextField tfCountry;
    private JTextField tfCity;
    private JTextField tfStreet;
    private JTextField tfZip;
    private JTextField tfHouseNumber;
    private JTextField tfEmail;

    //Buttons
    private JButton btnSave;
    private JButton btnCancel;

    //Other
    private JScrollBar scrollBar1;

    private Data data;
    private CostumersFrame parent;

    public AddCostumerFrame(Data data, CostumersFrame parent){
        this.data = data;
        this.parent = parent;
        setContentPane(addCustomerPane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(true);

        btnManager();
    }

    public void btnManager(){
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpFirstName = tfFirstName.getText();
                String cpLastName = tfLastName.getText();

                String cpDay = tfDay.getText();
                String cpMonth = tfMonth.getText();
                String cpYear = tfYear.getText();

                String cpEmail = tfEmail.getText();
                String cpGender = tfGender.getText();
                String cpMobilenumber = tfMobilenumber.getText();

                String cpCountry = tfCountry.getText();
                String cpCity = tfCity.getText();
                String cpZip = tfZip.getText();
                String cpStreet = tfStreet.getText();
                String cpHouseNumber = tfHouseNumber.getText();


                Costumer newCostumer = new Costumer(UUID.randomUUID(),cpFirstName,cpLastName,new Birthdate(Integer.valueOf(cpDay),Integer.valueOf(cpMonth),Integer.valueOf(cpYear)),new Address(cpCountry,cpCity,cpStreet,cpZip,cpHouseNumber),cpMobilenumber,cpEmail,cpGender);
                data.addCostumer(newCostumer);
                parent.refreshInformationPanel();

                dispose();
            }
        });
    }

}
