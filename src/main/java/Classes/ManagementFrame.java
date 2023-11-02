package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private Data data = new Data(true);
    //private ArrayList<Classes.User> users = data.getUsers();
    private User user;

    public ManagementFrame(User iuser){
        user = iuser;
        lbCurrentUser.setText(user.username);
        setContentPane(managementPanel);
        setLocation(1920,1080);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

    public void btnManager(){

        btnArticles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
}
