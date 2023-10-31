package Classes;

import javax.swing.*;

public class ManagementFrame extends JFrame{
    private JPanel managementPanel;
    private JButton btnCustomers;
    private JButton btnContactPersons;
    private JButton btnManagementSettings;
    private JLabel lbManagementName;
    private JButton btnArticles;
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
