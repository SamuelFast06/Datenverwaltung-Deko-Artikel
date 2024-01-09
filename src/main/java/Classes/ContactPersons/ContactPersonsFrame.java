package Classes.ContactPersons;

import Classes.*;
import Classes.Firebase.FirebaseContext;
import Classes.frontend.*;
import Classes.frontend.Frames.RequestFrame;

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
    private FirebaseContext firebaseContext;
    private ContactPerson selectedContactPerson;
    private InformationForm informationForm;
    private ContactPersonsFrame self = this;

    public ContactPersonsFrame(FirebaseContext firebaseContext){
        this.firebaseContext = firebaseContext;
        self = this;
        this.informationForm = new InformationForm(firebaseContext, InformationType.contactPeople, this);
        this.scrollPanel.add(this.informationForm);
        this.lbManagementName.setText(firebaseContext.getManagement().getName());
        this.lbCurrentUser.setText(firebaseContext.currentUser.getEmailAddress());
        this.btnShowContactPerson.disable();
        setContentPane(contactPersonPanel);
        setLocation(800,300);
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
                AddContactPersonFrame addContactPersonFrame = new AddContactPersonFrame(firebaseContext, self);
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
                    ShowContactPersonFrame showContactPersonFrame = new ShowContactPersonFrame(firebaseContext, selectedContactPerson, self);
                }
            }
        });

    }

    public void apply(Boolean success) {
        if (success) {
            firebaseContext.removeDocument(selectedContactPerson.getId(), ContactPerson.class);
            informationForm.refresh();
            System.out.println("'remove contactPerson'");
            informationForm.setHighlited(0);
        } else {
            System.out.println("contactPerson NOT removed.");
        }
    }

    public void refreshInformationPanel() { informationForm.refresh(); }

}

