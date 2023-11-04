package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


public class LoginFrame extends JFrame{

    private JTextField tfUsername;
    private JTextField tfPasswort;
    private JLabel lbLogin;
    private JLabel lbUsername;
    private JLabel lbPasswort;
    private JButton btnOK;
    private JPanel loginPanel;
    private JLabel lbMessage;
    private JButton btnCancel;
    private JLabel lbToRegistry;
    private JButton btnRegister;
    private JCheckBox checkBox;

    private int userindex = 0;
    private int wrongPWcount = 0;

    private Data data = new Data();
    private ArrayList<Classes.User> users = data.getUsers();

    public LoginFrame() {
       setContentPane(loginPanel);
       setLocation(800,300);
       setSize(400,280);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setVisible(true);
       setResizable(false);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String passwort = tfPasswort.getText();

                if(wrongPWcount < 3) {
                    try {
                        Data management = ManagementController.getDataManagement(new User(UUID.randomUUID(), username, passwort));

                        if (management != null) {
                            data.overrideData(management);
                            lbMessage.setText("login success");

                            tfUsername.disable();
                            btnOK.disable();
                            btnCancel.disable();
                            clearAllTf();

                            startManagment(new User(UUID.randomUUID(), username, passwort), data);
                            dispose();

                        } else {
                            wrongPWcount++;
                            lbMessage.setText("Passwort or username is wrong! " + (4 - wrongPWcount) + " attempts left");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }else if(wrongPWcount >= 3){
                    clearAllTf();
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


    private boolean isUsernameAvailable(String username){
        for(int i = 0; i < users.size(); i++){
            if(username.equals(users.get(i).username)){
                userindex = i;
                return true;
            }
        }
        return false;
    }
    private void clearAllTf(){
        tfUsername.setText("");
        tfPasswort.setText("");
    }

    private void startManagment(User user, Data data){
        ManagementFrame management = new ManagementFrame(user, data);
    }

    public static void main(String[] args){
        LoginFrame login = new LoginFrame();
    }
}
