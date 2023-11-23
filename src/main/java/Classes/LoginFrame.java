package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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
    private JTextField tfPasswort;

    //Buttons
    private JButton btnOK;
    private JButton btnCancel;
    private JButton btnRegister;

    //Other
    private JCheckBox checkBox;

    private int userindex = 0;
    private int wrongPWcount = 0;

    //Constructor
    public LoginFrame() {
       setContentPane(loginPanel);
       setLocation(800,300);
       setSize(400,280);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setVisible(true);
       setResizable(false);
        btnManager();
    }

    private void btnManager(){
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String passwort = tfPasswort.getText();

                if(wrongPWcount < 3) {
                    try {
                        Data management = ManagementController.getDataManagement(new User(UUID.randomUUID(), username, passwort));

                        if (management != null) {
                            lbMessage.setText("login success");

                            tfUsername.disable();
                            btnOK.disable();
                            btnCancel.disable();
                            tfUsername.setText(null);
                            tfPasswort.setText(null);

                            startManagment(new User(UUID.randomUUID(), username, passwort), management);
                            dispose();

                        } else {
                            wrongPWcount++;
                            lbMessage.setText("Passwort or username is wrong! " + (4 - wrongPWcount) + " attempts left");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
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
                RegisterFrame registry = new RegisterFrame();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void startManagment(User user, Data data){
        ManagementFrame management = new ManagementFrame(user, data);
    }

    public static void main(String[] args){
        LoginFrame login = new LoginFrame();
    }
}
