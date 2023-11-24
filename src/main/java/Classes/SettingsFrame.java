package Classes;

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
    private Data data;
    private User user;

        public SettingsFrame(User user, Data data){
            this.data = data;
            this.user = user;

            setContentPane(settingsPanel);
            lbCurrentUser.setText(user.username);
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
