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
        private JLabel lbRepeatPasswort;
        private JTextField tfRepeatPasswort;
        private JButton btnOK;
        private JButton btnCancel;
        private JPanel registerPanel;
        private JLabel lbMessage;

        private JCheckBox checkBox;

        private Data data;
        // private ArrayList<User> users = data.getUsers();

        public RegisterFrame() {
            setContentPane(registerPanel);
            setLocation(800,300);
            setSize(400,280);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
                    String repeatPasswort = tfRepeatPasswort.getText();

                    try {
                        if(ManagementController.usernameUnused(username)) {
                            if(passwort.equals(repeatPasswort)) {
                                User user = new User(UUID.randomUUID(), username, passwort);

                                lbMessage.setText("Register Success");
                                dispose();
                                ChooseManagementFrame chooseManagement = new ChooseManagementFrame(user);
                            } else {
                                lbMessage.setText("[RepeatPasswort] is not the same as [Passwort]");
                            }
                        } else {
                            lbMessage.setText("Username [" + username + "] is already used");
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
        }

    }
