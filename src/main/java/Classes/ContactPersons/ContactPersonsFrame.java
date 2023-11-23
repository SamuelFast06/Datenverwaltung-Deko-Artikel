package Classes.ContactPersons;

import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ContactPersonsFrame extends JFrame implements Refreshable, Function {

    private JPanel contactPersonPanel;

    //Labels
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;

    //Other
    private JButton btnRemoveContactPerson;
    private JButton btnAddContactPerson;
    private JButton btnShowContactPerson;
    private JScrollPane scrollPane;
    private JPanel scrollPanel;

    private User user;
    private Data data;
    private ContactPerson selectedContactPerson;
    private InformationForm informationForm;
    private ContactPersonsFrame self = this;

    public ContactPersonsFrame(User iuser, Data data){
        this.data = data;
        user = iuser;
        self = this;
        this.informationForm = new InformationForm(data, InformationType.contactPeople, this);
        this.scrollPanel.add(this.informationForm);
        this.lbManagementName.setText(data.getName());
        this.lbCurrentUser.setText(iuser.getUsername());
        this.btnShowContactPerson.disable();
        setContentPane(contactPersonPanel);
        setLocation(0,0);
        setSize(720,420);
        setResizable(false);
        btnManager();
        disableButtons();

        setVisible(true);
    }

    public void setupArticleList(){
    }

    public void setSelectContactPerson(ContactPerson contactPerson){
        // ContactPerson in ContactPersonList auswählen und contactPerson
        this.selectedContactPerson = contactPerson;
        if (selectedContactPerson != null) {
            enableButtons();
        } else {
            disableButtons();
        }
    }

    private void enableButtons() {
        btnShowContactPerson.setEnabled(true);
        btnRemoveContactPerson.setEnabled(true);

        refreshInformationPanel();
    }

    private void disableButtons() {
        btnShowContactPerson.setEnabled(false);
        btnRemoveContactPerson.setEnabled(false);
        refreshInformationPanel();
    }


    public void btnManager(){
        btnAddContactPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddContactPersonFrame addContactPersonFrame = new AddContactPersonFrame(data, self);
            }
        });

        btnRemoveContactPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame requestFrame = new RequestFrame(RequestType.remove, self, self);
            }
        });

        btnShowContactPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedContactPerson != null) {
                    //ShowContactPersonFrame showContactPersonFrame = new ShowContactPersonFrame(data, selectedContactPerson, self);
                }
            }
        });

    }

    public void apply(Boolean success) {
        if (success) {
            data.removeContactPerson(selectedContactPerson);
            informationForm.refresh();
            System.out.println("'remove contactPerson'");
            informationForm.setHighlited(0);
        } else {
            System.out.println("contactPerson NOT removed.");
        }
    }

    public void refreshInformationPanel() { informationForm.refresh(); }

    public static void main(String[] args){
        User testuser = new User();
        testuser.setUsername("testuser");
        testuser.setPasswort("test");
        try {
            ContactPersonsFrame contactPersonManage = new ContactPersonsFrame(testuser, ManagementController.getDataManagement("654c908654105e766fcd758e"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

