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


public class LoginFrame extends JFrame{

    private JPanel loginPanel;

    //Labels
    private JLabel lbLogin;
    private JLabel lbUsername;
    private JLabel lbPasswort;
    private JLabel lbMessage;
    private JLabel lbToRegistry;

    //Textfields
    private JTextField tfUsername;
    private JPasswordField tfPasswort;

    //Buttons
    private JButton btnOK;
    private JButton btnCancel;
    private JButton btnRegister;
    private JPanel lbLoginPanel;
    private JPanel btnColorPanel;
    private JCheckBox cbPasswort;

    //Other
    private JCheckBox checkBox;

    private int userindex = 0;
    private int wrongPWcount = 0;
    private FirebaseContext firebaseContext;

    //Constructor
    public LoginFrame() {
        this.firebaseContext = new FirebaseContext();

        setContentPane(loginPanel);
        setLocation(800,300);
        setSize(400,280);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        btnManager();

        uiDesignSetup();
    }

    private void btnManager(){
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfUsername.getText();
                String passwort = tfPasswort.getText();

                if(wrongPWcount < 3) {
                    try {
                        firebaseContext.signIn(email, passwort);

                        // When the login succeeds, the user is good to go
                        lbMessage.setText("login success");

                        tfUsername.disable();
                        btnOK.disable();
                        btnCancel.disable();
                        tfUsername.setText(null);
                        tfPasswort.setText(null);

                        startManagment(firebaseContext);
                        dispose();
                    } catch (Exception ex) {
                        wrongPWcount++;
                        lbMessage.setText("Passwort or username is wrong! " + (4 - wrongPWcount) + " attempts left");
                    }
                }else if(wrongPWcount >= 3){
                    tfUsername.setText(null);
                    tfPasswort.setText(null);
                    lbMessage.setText("TOO MANY ATTEMPTS! Number of Trys is exceeded");
                    tfPasswort.disable();
                    tfUsername.disable();
                    btnOK.disable();

                }
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegisterFrame registry = new RegisterFrame(firebaseContext);
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
                }

                if(e.getStateChange() == ItemEvent.DESELECTED){
                    tfPasswort.setEchoChar('\u2022');
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

        loginPanel.setBackground(new Color(50,54,58));
        lbLoginPanel.setBackground(colorBgr);

        //BUTTONS
        btnColorPanel.setBackground(Color.DARK_GRAY);

        //Background-Color
        btnOK.setBackground(colorBgr);
        btnCancel.setBackground(colorBgr);
        btnRegister.setBackground(colorBgr);

        //Text-Color
        btnOK.setForeground(colorFgr);
        btnCancel.setForeground(colorFgr);
        btnRegister.setForeground(colorFgr);

        //LABELS

        //Text-Color
        lbLogin.setForeground(colorFgr);
        lbUsername.setForeground(colorFgr);
        lbMessage.setForeground(colorFgr);
        lbPasswort.setForeground(colorFgr);
        lbToRegistry.setForeground(colorFgr);

        //TEXTFIELDS

        //Background-Color
        tfUsername.setBackground(colorBgr);
        tfPasswort.setBackground(colorBgr);
        cbPasswort.setBackground(colorBgr);

        //Text-Color
        tfUsername.setForeground(colorFgr);
        tfPasswort.setForeground(colorFgr);
        cbPasswort.setForeground(colorFgr);

        //Borders
        tfUsername.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));
        tfPasswort.setBorder(BorderFactory.createLineBorder(colorBgr,thickness,true));

    }


    private void startManagment(FirebaseContext firebaseContext){
        ManagementFrame management = new ManagementFrame(firebaseContext);
    }

    public static void main(String[] args){
        LoginFrame login = new LoginFrame();
    }
}
