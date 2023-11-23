package Classes.Costumers;

import Classes.Data;
import Classes.InformationForm;
import Classes.InformationType;
import Classes.User;

import javax.swing.*;

public class CostumersFrame extends JFrame{
    private JPanel costumersPanel;
    private JPanel scrollPanel;
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;
    private JButton showCostumerButton;
    private JButton removeCostumerButton;
    private JButton addCostumerButton;
    Data data;
    Costumer selectedCostumer;
    CostumersFrame self = this;

    public CostumersFrame(User user, Data data) {
        this.data = data;
        setContentPane(costumersPanel);
        setSize(720,420);
        setLocation(0,0);
        setResizable(false);
        this.scrollPanel.add(new InformationForm(data, InformationType.costumer, self));
        lbManagementName.setText(data.getName());
        changeLbUser(user.getUsername());

        disableButtons();

    }

    private void disableButtons() {
        showCostumerButton.setEnabled(false);
        removeCostumerButton.setEnabled(false);
    }

    private void enableButtons() {
        showCostumerButton.setEnabled(true);
        removeCostumerButton.setEnabled(true);
    }

    private void changeLbUser(String newValue) { lbCurrentUser.setText("Current user: " + newValue); }
}
