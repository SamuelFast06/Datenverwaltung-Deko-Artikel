package Classes;

import javax.swing.*;

public class SettingsFrame extends JFrame{

    private JPanel settingsPanel;
    private JTabbedPane tpSettings;
    private JLabel lbHeadline;
    private JLabel lbCurrentUser;

    //Client-Settings
    private JPanel clientSettingsPane;
    private JTabbedPane tpClientSettings;
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
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
            lbArticlesImage.setIcon(icon);
            lbCostumerImage.setIcon(icon);
            lbContactPersonImage.setIcon(icon);
        }
}
