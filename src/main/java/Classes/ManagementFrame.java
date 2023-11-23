package Classes;

import Classes.Articles.ArticlesFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ManagementFrame extends JFrame{

    private JPanel managementPanel;
    private JButton btnSettings;
    private JButton btnArticles;
    private JButton btnCustomers;
    private JButton btnContactPersons;
    private JLabel lbManagementName;
    private JLabel lbCurrentUser;
    private JLabel lbMessage;
    private JLabel lbImage;

    InformationType tappedType = InformationType.noType;

    private Data data;

    private User user;

    public ManagementFrame(User iuser, Data data){
        this.data = data;
        setContentPane(managementPanel);
        this.user = iuser;
        lbCurrentUser.setText(user.username);
        lbManagementName.setText(data.getName());
        setLocation(0,0);
        setSize(620,340);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnManager();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        lbImage.setIcon(icon);
    }

    public void btnManager(){
        btnArticles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArticlesFrame articlesManagement = new ArticlesFrame(user, data);
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

        try {
            Data data = ManagementController.getDataManagement("654c908654105e766fcd758e");
            ManagementFrame management = new ManagementFrame(new User(), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
