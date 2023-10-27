package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.util.*;


public class RegistryFrame extends JFrame{

    private JTextField tfUsername;
    private JTextField tfPasswort;
    private JLabel lbRegister;
    private JLabel lbUsername;
    private JLabel lbPasswort;
    private JLabel lbPasswortRepat;
    private JTextField tfRepeatPasswort;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel mainPanel;
    private JLabel lbMessage;
    private JCheckBox checkBox;

    private Data data = new Data(true);
    private ArrayList<User> users = data.getUsers();

    public RegistryFrame() {
       setContentPane(mainPanel);
        setSize(500,280);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String passwort = tfPasswort.getText();
                String repeatPasswort = tfRepeatPasswort.getText();
                if(isUsernameTaken(username) == false){
                    if(repeatPasswort.equals(passwort)){
                        users.add(new User(UUID.randomUUID(), username,passwort));
                        data.save();
                        clearAllTf();
                        lbMessage.setText("Registry Success");

                    }else{
                        System.out.println("Passwort is wronggg king gonnggggggggg");
                        System.out.println(tfPasswort.getText());
                        System.out.println(passwort);
                        System.out.println("repeat");
                        System.out.println(tfRepeatPasswort.getText());
                        System.out.println(repeatPasswort);
                    }
                }else{
                    System.out.println("Username is already used, friss mein fuuuuuusss d");
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close frame
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
