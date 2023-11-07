package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.*;


    public class RegisterFrame extends JFrame {

        private JTextField tfUsername;
        private JTextField tfPasswort;
        private JLabel lbRegister;
        private JLabel lbUsername;
        private JLabel lbPasswort;
        private JLabel lbPasswortRepat;
        private JTextField tfRepeatPasswort;
        private JButton btnOK;
        private JButton btnCancel;
        private JPanel registerPanel;
        private JLabel lbMessage;
        private JLabel lbRepeatPasswort;
        private JTextField tfName;
        private JCheckBox checkBox;

        private Data data = new Data();
        private ArrayList<User> users = data.getUsers();

        public RegisterFrame() {
            setContentPane(registerPanel);
            setLocation(800,300);
            setSize(400,280);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setVisible(true);
            setResizable(false);

            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = tfName.getText();
                    String username = tfUsername.getText();
                    String passwort = tfPasswort.getText();
                    String repeatPasswort = tfRepeatPasswort.getText();

                    try {
                        if(ManagementController.usernameUnused(username)) {
                            if(passwort.equals(repeatPasswort)) {
                                User user = new User(UUID.randomUUID(), username, passwort);

                                data = ManagementController.createManagement(name, user);

                                lbMessage.setText("Register Success");
                                dispose();
                                LoginFrame newlogin = new LoginFrame();
                            } else {
                                lbMessage.setText("[RepeatPasswort] is not the same as [Passwort]");
                            }
                        } else {
                            lbMessage.setText("Username [" + username + "] is already used");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    /*if(isUsernameTaken(username) == true){
                        lbMessage.setText("Username " + "[" + username + "]" + " is already used");
                    }else{
                        if(passwort.equals(repeatPasswort)) {
                            if (!passwort.equals("") && !repeatPasswort.equals("")) {
                                data.reloadData();
                                users.add(new User(UUID.randomUUID(), username, passwort));
                                data.save();
                                clearAllTf();
                                lbMessage.setText("Register Success");
                                dispose();
                                LoginFrame newlogin = new LoginFrame();

                            } else {
                                lbMessage.setText("Passwort is wrong");
                            }
                        } else {
                            lbMessage.setText("[RepeatPasswort] is not the same as [Passwort]");
                        }
                    }*/
                }
            });

            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }

        private boolean isUsernameTaken(String username){
            for(int i = 0; i < users.size(); i++){
                data.reloadData();
                if(username == users.get(i).username){
                    return true;
                }
            }
            return false;
        }
        private void clearAllTf(){
            tfUsername.setText("");
            tfPasswort.setText("");
            tfRepeatPasswort.setText("");
        }
    }
