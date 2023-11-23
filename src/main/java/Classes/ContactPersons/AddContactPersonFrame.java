package Classes.ContactPersons;

import Classes.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class AddContactPersonFrame extends JFrame{

    private JPanel addCustomerPane;

    //labels
    private JLabel lbHeadline;
    private JLabel lbLastName;
    private JLabel lbCompany;
    private JLabel lbAddress;
    private JLabel lbBranchtype;
    private JLabel lbMobilenumber;
    private JLabel lbFirstName;
    private JLabel lbMessage;
    private JLabel lbImage;

    //TextFields
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfCompany;
    private JTextField tfBranchtype;
    private JTextField tfMobilenumber;
    private JTextField tfAddress;

    //Buttons
    private JButton btnSave;
    private JButton btnCancel;

    //Other
    private JScrollBar scrollBar1;

    private Data data;
    private ContactPersonsFrame parent;

    public AddContactPersonFrame(Data data, ContactPersonsFrame parent){
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
                String cpAddress = tfAddress.getText();
                String cpMobilenumber = tfMobilenumber.getText();
                String cpCompany = tfCompany.getText();
                String cpBranchtype = tfBranchtype.getText();

                ContactPerson newContactPerson = new ContactPerson(UUID.randomUUID(),cpFirstName,cpLastName,cpCompany,cpAddress,cpBranchtype,cpMobilenumber);
                data.addContactPerson(newContactPerson);
                parent.refreshInformationPanel();

                dispose();
            }
        });
    }

}
