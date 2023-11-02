package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

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
        private JCheckBox checkBox;

        private Data data = new Data(true);
        private ArrayList<User> users = data.getUsers();

        public RegisterFrame() {
            setContentPane(registerPanel);
            setLocation(800,300);
            setSize(400,280);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            btnManager();
        }

        public void btnManager(){
            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = tfUsername.getText();
                    String passwort = tfPasswort.getText();
                    String repeatPasswort = tfRepeatPasswort.getText();
                    if(isUsernameTaken(username) == true){
                        lbMessage.setText("Username " + "[" + username + "]" + " is already used");
                    }else{
                        if(repeatPasswort.equals(passwort) && !passwort.equals("") || !repeatPasswort.equals("")){
                            users.add(new User(UUID.randomUUID(), username,passwort));
                            data.save();
                            data.reloadData();
                            clearAllTf();
                            lbMessage.setText("Register Success");
                            dispose();

                        }else{
                            lbMessage.setText("Passwort is wrong");
                        }
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

        private boolean isUsernameTaken(String username){
            for(int i = 0; i < users.size(); i++){
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
