package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChooseManagementFrame extends JFrame{
    private JPanel chooseManagementPanel;
    private JButton btnCreateManagement;
    private JButton btnJoinManagement;
    private JTextField tfCreateName;
    private JTextField tfJoinID;
    private JLabel lbCreateName;
    private JLabel lbJoinID;
    private JLabel lbMessageCreate;
    private JLabel lbMessage;
    private JLabel lbHeadline;

    private User user;


    public ChooseManagementFrame(User iuser){
        user = iuser;
        setContentPane(chooseManagementPanel);
        setLocation(800,300);
        setSize(400,180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnManager();
    }

    public void btnManager(){
        btnCreateManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newManagementName = tfCreateName.getText();
                try {
                    String t = tfCreateName.getText().replaceAll("[\n \t]","");
                    if(t.toCharArray().length > 0){
                        ManagementController.createManagement(newManagementName, user);
                        lbMessage.setText("Created " + newManagementName);

                        dispose();
                        LoginFrame loginFrame = new LoginFrame();
                    }else{
                        lbMessageCreate.setText("Invalid ManagementName");
                    }

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
                    String t = tfCreateName.getText().replaceAll("[\n \t]","");
                    if(t.toCharArray().length > 0) {
                        Data data = ManagementController.getDataManagement(joinID);
                        data.addUser(user);
                        lbMessage.setText("Joined " + data.getName());

                        dispose();
                        LoginFrame loginFrame = new LoginFrame();
                    }else{
                        lbMessage.setText("Join-ID does not exist");
                    }
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
