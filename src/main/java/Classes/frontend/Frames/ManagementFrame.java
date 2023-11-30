package Classes.frontend.Frames;

import Classes.Articles.ArticlesFrame;
import Classes.ContactPersons.ContactPersonsFrame;
import Classes.Costumers.CostumersFrame;
import Classes.ManagementController;
import Classes.User;
import Classes.frontend.InformationType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ManagementFrame extends JFrame{

    private JPanel managementPanel;

    //Panels
    private JPanel lbManagementColorPanel;
    private JPanel lbCurrentUserColorPanel;
    private JPanel btnColorPanel;

    //Labels
    private JLabel lbManagementName;
    private JLabel lbCurrentUser;
    private JLabel lbMessage;
    private JLabel lbImage;
    private JLabel lbStammdaten;

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

        uiDesignSetup();


        setContentPane(managementPanel);
        lbCurrentUser.setText("Current User: "+user.username);
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

    public void uiDesignSetup(){

        Color colorFgr = Color.WHITE;
        Color colorBgr = Color.GRAY;
        Color colorBorder = Color.DARK_GRAY;
        int thickness = 2;


    //PANELS

        managementPanel.setBackground(new Color(50,54,58));

    //BUTTONS
        btnColorPanel.setBackground(Color.DARK_GRAY);

        //Background-Color
        btnArticles.setBackground(colorBgr);
        btnSettings.setBackground(colorBgr);
        btnCustomers.setBackground(colorBgr);
        btnContactPersons.setBackground(colorBgr);

        //Text-Color
        btnArticles.setForeground(colorFgr);
        btnSettings.setForeground(colorFgr);
        btnCustomers.setForeground(colorFgr);
        btnContactPersons.setForeground(colorFgr);

        //Border
        btnArticles.setBorder(BorderFactory.createLineBorder(colorBorder,thickness,true));
        btnSettings.setBorder(BorderFactory.createLineBorder(colorBorder,thickness,true));
        btnCustomers.setBorder(BorderFactory.createLineBorder(colorBorder,thickness,true));
        btnContactPersons.setBorder(BorderFactory.createLineBorder(colorBorder,thickness,true));

    //LABELS

        //Backgorund-Color
        lbManagementColorPanel.setBackground(colorBgr);
        lbCurrentUserColorPanel.setBackground(colorBgr);

        //Text-Color
        lbManagementName.setForeground(colorFgr);
        lbCurrentUser.setForeground(colorFgr);
        lbMessage.setForeground(colorFgr);
        lbStammdaten.setForeground(colorFgr);

        //Border
        lbManagementColorPanel.setBorder(BorderFactory.createLineBorder(colorBorder,thickness,true));
        lbCurrentUserColorPanel.setBorder(BorderFactory.createLineBorder(colorBorder,thickness,true));








    }


    //TEST
    public static void main(String[] args){

        try {
            User testuser = new User();
            Data data = ManagementController.createManagement("test",testuser);
            ManagementFrame management = new ManagementFrame(testuser, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
