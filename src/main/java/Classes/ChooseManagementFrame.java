package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseManagementFrame extends JFrame{
    private JPanel chooseManagementPanel;
    private JButton btnCreateManagement;
    private JButton btnJoinManagement;
    private JTextField tfCreateName;
    private JTextField tfJoinID;
    private JLabel lbCreateName;
    private JLabel lbJoinID;
    private JLabel lbMessageCreate;
    private JLabel lbMessageJoin;
    private JLabel lbHeadline;

    private User user;


    public ChooseManagementFrame(User iuser){
        user = iuser;
        setContentPane(chooseManagementPanel);
        setLocation(0,0);
        setSize(400,280);
        setVisible(true);
        setResizable(false);
        btnManager();
    }

    public void btnManager(){
        btnCreateManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newManagementName = tfCreateName.getText();
                try {
                    ManagementController.createManagement(newManagementName, user);
                    lbMessageJoin.setText("Created " + newManagementName);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnJoinManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String joinID = tfJoinID.getText();
                try {
                    Data data = ManagementController.getDataManagement(joinID);
                    data.addUser(user);
                    lbMessageJoin.setText("Joined " + data.getName());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] pablo){
        User testUser = new User();
        ChooseManagementFrame frame = new ChooseManagementFrame(testUser);
    }
}
