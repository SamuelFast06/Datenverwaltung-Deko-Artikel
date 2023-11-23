package Classes;

import Classes.Articles.ArticlesFrame;
import Classes.ContactPersons.ContactPersonsFrame;
import Classes.Costumers.CostumersFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ManagementFrame extends JFrame{

    private JPanel managementPanel;

    //Labels
    private JLabel lbManagementName;
    private JLabel lbCurrentUser;
    private JLabel lbMessage;
    private JLabel lbImage;

    //Buttons
    private JButton btnSettings;
    private JButton btnArticles;
    private JButton btnCustomers;
    private JButton btnContactPersons;

    //Other

    InformationType tappedType = InformationType.noType;
    private Data data;
    private User user;

    //Constructor
    public ManagementFrame(User iuser, Data data){
        this.data = data;
        this.user = iuser;

        setContentPane(managementPanel);
        lbCurrentUser.setText(user.username);
        lbManagementName.setText(data.getName());
        setLocation(800,300);
        setSize(1080,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnManager();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        lbImage.setIcon(icon);
    }

    public void btnManager(){

        //Articles Frame Button
        btnArticles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArticlesFrame articlesManagement = new ArticlesFrame(user, data);
            }
        });

        //Customers Frame Button
        btnCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CostumersFrame costumersManagement = new CostumersFrame(user, data);
            }
        });

        //ContactPersons Frame Button
        btnContactPersons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactPersonsFrame contactPersonsManagement = new ContactPersonsFrame(user, data);
            }
        });

        //Settings Frame Button
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsFrame settingsFrame = new SettingsFrame(user, data);
            }
        });
    }


    //TEST
    public static void main(String[] args){

        try {
            Data data = ManagementController.getDataManagement("654c908654105e766fcd758e");
            ManagementFrame management = new ManagementFrame(new User(), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
