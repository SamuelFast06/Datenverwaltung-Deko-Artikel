package Classes.frontend.Frames;

import Classes.Firebase.FirebaseContext;

import Classes.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.UUID;


public class RegisterFrame extends JFrame {

    private JPanel registerPanel;

    //Labels
    private JLabel lbMessage;
    private JLabel lbRegister;
    private JLabel lbEmail;
    private JLabel lbPasswort;
    private JLabel lbRepeatPasswort;

    //Textfields
    private JTextField tfEmail;
    private JPasswordField tfPasswort;
    private JPasswordField tfRepeatPasswort;

    //Buttons
    private JButton btnOK;
    private JButton btnCancel;

    //Other
    private JPanel btnColorPanel;
    private JPanel lbRegisterPanel;
    private JCheckBox cbPasswort;

    private FirebaseContext firebaseContext;
    // private ArrayList<User> users = data.getUsers();

    public RegisterFrame(FirebaseContext firebaseContext) {
        this.firebaseContext = firebaseContext;

        setContentPane(registerPanel);
        setLocation(800,300);
        setSize(400,280);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnManager();
        uiDesignSetup();
    }

    private void btnManager(){

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String passwort = tfPasswort.getText();
                String repeatPasswort = tfRepeatPasswort.getText();

                try {
                        if(passwort.equals(repeatPasswort)) {
                            User user = new User(email, passwort, UUID.randomUUID().toString(), null);

                            lbMessage.setText("Register Success");
                            dispose();
                            ChooseManagementFrame chooseManagement = new ChooseManagementFrame(user, firebaseContext);
                        } else {
                            lbMessage.setText("[RepeatPasswort] is not the same as [Passwort]");
                        }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                }
        });

        cbPasswort.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                char[] input = tfPasswort.getPassword();

                if(e.getStateChange() == ItemEvent.SELECTED){
                    tfPasswort.setEchoChar('\u0000');
                    tfRepeatPasswort.setEchoChar('\u0000');
                }

                if(e.getStateChange() == ItemEvent.DESELECTED){
                    tfPasswort.setEchoChar('\u2022');
                    tfRepeatPasswort.setEchoChar('\u2022');
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

        registerPanel.setBackground(new Color(50,54,58));
        lbRegisterPanel.setBackground(colorBgr);

        //BUTTONS
        btnColorPanel.setBackground(Color.DARK_GRAY);

        //Background-Color
        btnOK.setBackground(colorBgr);
        btnCancel.setBackground(colorBgr);

        //Text-Color
        btnOK.setForeground(colorFgr);
        btnCancel.setForeground(colorFgr);

        //LABELS

        //Text-Color
        lbRegister.setForeground(colorFgr);
        lbEmail.setForeground(colorFgr);
        lbMessage.setForeground(colorFgr);
        lbPasswort.setForeground(colorFgr);
        lbRepeatPasswort.setForeground(colorFgr);

        //TEXTFIELDS

        //Background-Color
        tfEmail.setBackground(colorBgr);
        tfPasswort.setBackground(colorBgr);
        tfRepeatPasswort.setBackground(colorBgr);
        cbPasswort.setBackground(colorBgr);

        //Text-Color
        tfEmail.setForeground(colorFgr);
        tfPasswort.setForeground(colorFgr);
        tfRepeatPasswort.setForeground(colorFgr);
        cbPasswort.setForeground(colorFgr);

        //Borders
        tfEmail.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));
        tfPasswort.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));
        tfRepeatPasswort.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));

    }

}
