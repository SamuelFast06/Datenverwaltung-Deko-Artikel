package Classes.frontend.Frames;

import Classes.Firebase.FirebaseContext;
import Classes.Management.Management;

import Classes.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.UUID;

public class ChooseManagementFrame extends JFrame{

    private JPanel chooseManagementPanel;

    //Labels
    private JLabel lbCreateName;
    private JLabel lbJoinID;
    private JLabel lbMessageCreate;
    private JLabel lbMessage;
    private JLabel lbHeadline;

    //Textfields
    private JTextField tfCreateName;
    private JTextField tfJoinID;

    //Buttons
    private JButton btnCreateManagement;
    private JButton btnJoinManagement;
    private JPanel lbHeadlinePanel;
    private JPanel btnColorPanel;

    //Other
    private FirebaseContext firebaseContext;
    private User user;


    public ChooseManagementFrame(User user, FirebaseContext firebaseContext){
        this.firebaseContext = firebaseContext;
        this.user = user;

        setContentPane(chooseManagementPanel);
        setLocation(800,300);
        setSize(400,180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnManager();

        uiDesignSetup();
    }

    public void btnManager(){
        btnCreateManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String newManagementName = tfCreateName.getText();

                    String name = tfCreateName.getText().replaceAll("[\n \t]", "");
                    if (name.toCharArray().length > 0) {
                        firebaseContext.createManagementWithUser(user, new Management(name, UUID.randomUUID().toString()));

                        lbMessage.setText("Created " + newManagementName);

                        dispose();
                        LoginFrame loginFrame = new LoginFrame();
                    } else {
                        lbMessageCreate.setText("Invalid ManagementName");
                    }
                } catch (Exception ex) {
                    System.out.println("Failed to create a new Management: " + ex.toString());
                }

            }
        });

        btnJoinManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String joinID = tfJoinID.getText();
                try {
                    String t = tfCreateName.getText().replaceAll("[\n \t]","");
                    if(t.toCharArray().length > 0) {

                        firebaseContext.joinManagementWithUser(user, joinID);
                        lbMessage.setText("Joined " + firebaseContext.getManagement().getName());

                        dispose();
                        LoginFrame loginFrame = new LoginFrame();
                    }else{
                        lbMessage.setText("Join-ID does not exist");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void uiDesignSetup(){

        Color colorFgr = Color.WHITE;
        Color colorBgr = Color.GRAY;
        Color colorBorder = Color.DARK_GRAY;
        int thickness = 2;

        //PANELS

        chooseManagementPanel.setBackground(new Color(50,54,58));
        lbHeadlinePanel.setBackground(colorBgr);

        //BUTTONS
        btnColorPanel.setBackground(Color.DARK_GRAY);

        //Background-Color
        btnJoinManagement.setBackground(colorBgr);
        btnCreateManagement.setBackground(colorBgr);

        //Text-Color
        btnJoinManagement.setForeground(colorFgr);
        btnCreateManagement.setForeground(colorFgr);

        //LABELS

        //Text-Color
        lbHeadline.setForeground(colorFgr);
        lbCreateName.setForeground(colorFgr);
        lbMessage.setForeground(colorFgr);
        lbJoinID.setForeground(colorFgr);

        //TEXTFIELDS

        //Background-Color
        tfCreateName.setBackground(colorBgr);
        tfJoinID.setBackground(colorBgr);

        //Text-Color
        tfCreateName.setForeground(colorFgr);
        tfJoinID.setForeground(colorFgr);

        //Borders
        tfCreateName.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));
        tfJoinID.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));

    }
}
