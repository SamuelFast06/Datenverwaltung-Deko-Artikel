package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.util.*;


public class MainFrame extends JFrame{

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

    public MainFrame() {
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
                        clearTf();

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
    }


    private boolean isUsernameTaken(String username){
        for(int i = 0; i < users.size(); i++){
            if(username == users.get(i).username){
                return true;
            }
        }
        return false;
    }
    private void clearTf(){
        tfUsername.setText("");
        tfPasswort.setText("");
        tfRepeatPasswort.setText("");
    }



    //User-data
    /*User[] userlist = {
     new User(UUID.randomUUID(), "kotbeutel4", "kamin187"),
     new User(UUID.randomUUID(), "ralf88", "kamin187"),
     new User(UUID.randomUUID(), "bob9", "kamin187"),
     new User(UUID.randomUUID(), "gandalf666", "kamin187"),
     new User(UUID.randomUUID(), "fridolin187", "kamin187"),
     new User(UUID.randomUUID(), "galoina3", "kamin187"),
     new User(UUID.randomUUID(), "andrusch5", "kamin187"),
     new User(UUID.randomUUID(), "josef888", "kamin187"),
     new User(UUID.randomUUID(), "freddyFazbear123", "kamin187"),
     new User(UUID.randomUUID(), "rootbeer", "kamin187")};
       */


    public static void main(String[] args){
        MainFrame registry = new MainFrame();
    }
}
