package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;


public class ManagementFrame extends JFrame{

    private JPanel managementPanel;
    private JButton btnSettings;
    private JButton btnArticles;
    private JButton btnCustomers;
    private JButton btnContactPersons;
    private JTextArea textArea;
    private JLabel lbManagementName;
    private JLabel lbCurrentUser;
    private JLabel lbMessage;

    private Data data = new Data();
    private ArrayList<Classes.User> users = data.getUsers();
    private User user;

    public ManagementFrame(User iuser){
        setContentPane(managementPanel);
        user = iuser;
        lbCurrentUser.setText(user.username);
        setLocation(0,0);
        setSize(720,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnManager();
    }

    public void btnManager(){
        btnArticles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArticlesFrame articlesManagement = new ArticlesFrame(user);
            }
        });

        btnCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnContactPersons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        ManagementFrame management = new ManagementFrame(new User());
    }
}
