package Classes.ContactPersons;

import Classes.Firebase.FirebaseContext;
import Classes.SubClasses.Address;
import Classes.frontend.Function;
import Classes.frontend.Frames.RequestFrame;
import Classes.frontend.RequestType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShowContactPersonFrame extends JFrame implements Function {

    private JPanel showContactPersonPane;

    //Labels
    private JLabel lbHeadline;
    private JLabel lbLastName;
    private JLabel lbCompany;
    private JLabel lbAddress;
    private JLabel lbBranchtype;
    private JLabel lbMobilenumber;
    private JLabel lbFirstName;
    private JLabel lbMessage;
    private JLabel lbImage;

    //Textfields
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfCompany;
    private JTextField tfBranchtype;
    private JTextField tfMobilenumber;

    //Buttons
    private JButton btnSave;
    private JButton btnCancel;

    //Other
    private JCheckBox cbEdit;
    private JScrollBar scrollBar1;
    private JTextField tfCountry;
    private JTextField tfCity;
    private JTextField tfZip;
    private JTextField tfStreet;
    private JTextField tfHouseNumber;
    private JLabel lbOtherInformation;
    private JLabel lbCountry;
    private JLabel lbCity;
    private JLabel lbZip;
    private JLabel lbStreet;
    private JLabel lbHouseNumber;


    private FirebaseContext firebaseContext;
    private ContactPersonsFrame contactPersonsFrame;

    private ContactPerson slcContactPerson;
    private ShowContactPersonFrame self = this;


    public ShowContactPersonFrame(FirebaseContext firebaseContext, ContactPerson contactPerson, ContactPersonsFrame contactPersonsFrame){
        this.firebaseContext = firebaseContext;
        this.contactPersonsFrame = contactPersonsFrame;
        slcContactPerson = contactPerson;
        setContentPane(showContactPersonPane);
        setLocation(800,300);
        setSize(400,450);
        setVisible(true);
        setResizable(true);

        setup();

        tfFirstName.disable();
        tfLastName.disable();
        tfBranchtype.disable();
        tfMobilenumber.disable();
        tfCompany.disable();

        tfCountry.setEnabled(false);
        tfCity.setEnabled(false);
        tfZip.setEnabled(false);
        tfStreet.setEnabled(false);
        tfHouseNumber.setEnabled(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        //lbImage.setIcon(icon);

    }

    public void apply(Boolean success) {
        if (success) {
            editContactPerson();
        } else {
            System.out.println("Article NOT saved!");
        }
    }

    public void setup(){

        //lbAddress.setText(slcContactPerson.getAddress());
        tfBranchtype.setText(slcContactPerson.getBranchtype());
        tfCompany.setText(slcContactPerson.getCompany());
        tfFirstName.setText(slcContactPerson.getFirstname());
        tfLastName.setText(slcContactPerson.getLastname());
        tfMobilenumber.setText(slcContactPerson.getMobilenumber());

        tfCountry.setText(slcContactPerson.getAddress().getCountry());
        tfCity.setText(slcContactPerson.getAddress().getCity());
        tfZip.setText(slcContactPerson.getAddress().getZip());
        tfStreet.setText(slcContactPerson.getAddress().getStreet());
        tfHouseNumber.setText(slcContactPerson.getAddress().getHouseNumber());

        btnSave.setEnabled(false);

        cbEdit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){

                    btnSave.setEnabled(true);

                    tfBranchtype.setEnabled(true);
                    tfCompany.setEnabled(true);
                    tfMobilenumber.setEnabled(true);
                    tfFirstName.setEnabled(true);
                    tfLastName.setEnabled(true);

                    tfCountry.setEnabled(true);
                    tfCity.setEnabled(true);
                    tfZip.setEnabled(true);
                    tfStreet.setEnabled(true);
                    tfHouseNumber.setEnabled(true);

                }

                if(e.getStateChange() == ItemEvent.DESELECTED){

                    btnSave.setEnabled(false);

                    tfBranchtype.setEnabled(false);
                    tfCompany.setEnabled(false);
                    tfMobilenumber.setEnabled(false);
                    tfFirstName.setEnabled(false);
                    tfLastName.setEnabled(false);

                    tfCountry.setEnabled(false);
                    tfCity.setEnabled(false);
                    tfZip.setEnabled(false);
                    tfStreet.setEnabled(false);
                    tfHouseNumber.setEnabled(false);
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame request = new RequestFrame(RequestType.edit, self, self.contactPersonsFrame);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    void editContactPerson() {
        //slcContactPerson.setAddress(tfAddress.getText());
        slcContactPerson.setCompany(tfCompany.getText());
        slcContactPerson.setBranchtype(tfBranchtype.getText());
        slcContactPerson.setFirstname(tfFirstName.getText());
        slcContactPerson.setLastname(tfLastName.getText());
        slcContactPerson.setMobilenumber(tfMobilenumber.getText());

        slcContactPerson.setAddress(new Address(tfCountry.getText(), tfCity.getText(), tfZip.getText(), tfStreet.getText(), tfHouseNumber.getText()));

        firebaseContext.editDocument(slcContactPerson);

        System.out.println("contactPerson changed");
        dispose();
    }

    public ContactPersonsFrame getContactPersonsFrame() {
        return contactPersonsFrame;
    }

    public void setContactPersonsFrame(ContactPersonsFrame contactPersonsFrame) {
        this.contactPersonsFrame = contactPersonsFrame;
    }
}
