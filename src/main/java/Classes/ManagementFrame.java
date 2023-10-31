package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.util.*;
import java.util.ArrayList;

public class ManagementFrame extends JFrame{
    private JPanel managementPanel;
    private JLabel lbCurrentUser;

    private Data data = new Data(true);
    private User user;

    public ManagementFrame(User iuser) {
        user = iuser;
        lbCurrentUser.setText("Current User: " + user.username);
        setContentPane(managementPanel);
        setLocation(0, 0);
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);


    }

    public static void main(String[] args){
        /*
        User testuser = new User(UUID.randomUUID(),"testuser","kamin187");
        ManagementFrame management = new ManagementFrame(testuser);

         */
    }
}
