package Classes.frontend.Frames;

import Classes.Firebase.FirebaseContext;
import Classes.frontend.InformationType;

import Classes.User.User;

import javax.swing.*;

public class SettingsFrame extends JFrame{

    private JPanel settingsPanel;
    private JTabbedPane tpSettings;
    private JLabel lbHeadline;
    private JLabel lbCurrentUser;

    //Client-Settings
    private JPanel userSettingsPane;
    private JTabbedPane tpUserSettings;
        //Graphics
        private JPanel graphicsPanel;
        //Audio
        private JPanel audioPanel;

    //Management-Settings
    private JPanel managementSettingsPane;
    private JTabbedPane tbManagementSettings;
        //showManagement
        private JPanel showManagementPanel;
        private JLabel lbName;
        private JLabel lbID;
        private JTextField tfManagementName;
        private JTextField tfManagementID;

        //Users
        private JPanel showUsersPane;
        private JLabel lbUsers;
        private JScrollPane usersScrollPane;

        //ContactPersons
        private JLabel lbContactPersonImage;
        //Articles
        private JLabel lbArticlesImage;
        //Costumers
        private JLabel lbCostumerImage;
    private JPanel accountPanel;
    private JLabel lbUserName;
    private JTextField tfUserName;
    private JLabel lbUserPasswort;
    private JTextField tfUserPasswort;
    private JLabel lbUserInfo;
    private JLabel lbUserID;
    private JTextField tfUserID;
    private JLabel lbPersonalInfo;
    private JLabel lbPersonFirstName;
    private JTextField tfUserFirstName;
    private JTextField tfUserLastname;
    private JLabel lbUserLastName;
    private JLabel lbUserBirthdate;
    private JTextField tfUserDay;
    private JTextField tfUserYear;
    private JTextField tfUserMonth;
    private JLabel lbManagementInfo;


    InformationType tappedType = InformationType.noType;
    private FirebaseContext firebaseContext;

        public SettingsFrame(FirebaseContext firebaseContext){
            this.firebaseContext = firebaseContext;

            User user = firebaseContext.currentUser;;

            setContentPane(settingsPanel);
            //lbCurrentUser.setText(user.getUsername);
            setLocation(800,300);
            setSize(1080,720);
            setVisible(true);
            setResizable(false);
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
            lbArticlesImage.setIcon(icon);
            lbCostumerImage.setIcon(icon);
            lbContactPersonImage.setIcon(icon);
        }



}
