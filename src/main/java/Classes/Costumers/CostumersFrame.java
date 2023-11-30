package Classes.Costumers;

import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CostumersFrame extends JFrame implements Refreshable, Function {

    private JPanel costumersPanel;

    //Labels
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;

    //Other
    private JButton btnRemoveCostumer;
    private JButton btnAddCostumer;
    private JButton btnShowCostumer;
    private JScrollPane scrollPane;
    private JPanel scrollPanel;

    private User user;
    private Data data;
    private Costumer selectedCostumer;
    private InformationForm informationForm;
    private CostumersFrame self = this;

    public CostumersFrame(User iuser, Data data){
        this.data = data;
        user = iuser;
        self = this;
        this.informationForm = new InformationForm(data, InformationType.costumer, this);
        this.scrollPanel.add(this.informationForm);
        this.lbManagementName.setText(data.getName());
        this.lbCurrentUser.setText(iuser.getUsername());
        this.btnShowCostumer.disable();
        setContentPane(costumersPanel);
        setLocation(800,300);
        setSize(720,420);
        setResizable(false);
        btnManager();
        disableButtons();

        setVisible(true);
    }

    public void setSelectCostumer(Costumer costumer){
        // Costumer in CostumerList auswählen und costumer
        this.selectedCostumer = costumer;
        if (selectedCostumer != null) {
            enableButtons();
        } else {
            disableButtons();
        }
    }

    private void enableButtons() {
        btnShowCostumer.setEnabled(true);
        btnRemoveCostumer.setEnabled(true);

        refreshInformationPanel();
    }

    private void disableButtons() {
        btnShowCostumer.setEnabled(false);
        btnRemoveCostumer.setEnabled(false);
        refreshInformationPanel();
    }


    public void btnManager(){
        btnAddCostumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AddCostumerFrame addCostumerFrame = new AddCostumerFrame(data, self);
            }
        });

        btnRemoveCostumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame requestFrame = new RequestFrame(RequestType.remove, self, self);
            }
        });

        btnShowCostumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedCostumer != null) {
                    ShowCostumerFrame showCostumerFrame = new ShowCostumerFrame(data, selectedCostumer, self);
                }
            }
        });

    }

    public void apply(Boolean success) {
        if (success) {
            data.removeCostumer(selectedCostumer);
            informationForm.refresh();
            System.out.println("'remove costumer'");
            informationForm.setHighlited(0);
        } else {
            System.out.println("costumer NOT removed.");
        }
    }

    public void refreshInformationPanel() { informationForm.refresh(); }


    //TEST
    public static void main(String[] args){
        User testuser = new User();
        testuser.setUsername("testuser");
        testuser.setPasswort("test");
        try {
            CostumersFrame costumersFrame = new CostumersFrame(testuser, ManagementController.getDataManagement("654c908654105e766fcd758e"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSelectedCostumer(Costumer newCostumer) {
        this.selectedCostumer = newCostumer;
    }
}

