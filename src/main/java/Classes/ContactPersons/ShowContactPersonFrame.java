package Classes.ContactPersons;

import Classes.ContactPersons.ContactPerson;
import Classes.ContactPersons.ContactPersonsFrame;
import Classes.Data;
import Classes.Function;
import Classes.RequestFrame;
import Classes.RequestType;

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
    private JTextField tfAddress;

    //Buttons
    private JButton btnSave;
    private JButton btnCancel;

    //Other
    private JCheckBox cbEdit;
    private JScrollBar scrollBar1;


    private Data data;
    private ContactPersonsFrame contactPersonsFrame;

    private ContactPerson slcContactPerson;
    private ShowContactPersonFrame self = this;


    public ShowContactPersonFrame(Data data, ContactPerson contactPerson, ContactPersonsFrame contactPersonsFrame){
        this.data = data;
        this.contactPersonsFrame = contactPersonsFrame;
        slcContactPerson = contactPerson;
        setContentPane(showContactPersonPane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(true);

        setup();

        tfFirstName.disable();
        tfLastName.disable();
        tfAddress.disable();
        tfBranchtype.disable();
        tfMobilenumber.disable();
        tfCompany.disable();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        lbImage.setIcon(icon);

    }

    public void apply(Boolean success) {
        if (success) {
            editContactPerson();
        } else {
            System.out.println("Article NOT saved!");
        }
    }

    public void setup(){

        lbAddress.setText(slcContactPerson.getAddress());
        lbBranchtype.setText(""+slcContactPerson.getBranchtype()+"");
        lbCompany.setText(""+slcContactPerson.getCompany()+"");
        lbFirstName.setText(slcContactPerson.getFirstname());
        lbLastName.setText(slcContactPerson.getLastname());
        lbMobilenumber.setText(""+slcContactPerson.getMobilenumber());

        btnSave.setEnabled(false);

        cbEdit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){

                    btnSave.setEnabled(true);

                    tfAddress.setEnabled(true);
                    tfBranchtype.setEnabled(true);
                    tfCompany.setEnabled(true);
                    tfMobilenumber.setEnabled(true);
                    tfFirstName.setEnabled(true);
                    tfLastName.setEnabled(true);

                }

                if(e.getStateChange() == ItemEvent.DESELECTED){

                    btnSave.setEnabled(false);

                    tfAddress.setEnabled(false);
                    tfBranchtype.setEnabled(false);
                    tfCompany.setEnabled(false);
                    tfMobilenumber.setEnabled(false);
                    tfFirstName.setEnabled(false);
                    tfLastName.setEnabled(false);
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
        slcContactPerson.setAddress(tfAddress.getText());
        slcContactPerson.setCompany(tfCompany.getText());
        slcContactPerson.setBranchtype(tfBranchtype.getText());
        slcContactPerson.setFirstname(tfFirstName.getText());
        slcContactPerson.setLastname(tfLastName.getText());
        slcContactPerson.setMobilenumber(tfMobilenumber.getText());

        data.uploadDataToServer();

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
