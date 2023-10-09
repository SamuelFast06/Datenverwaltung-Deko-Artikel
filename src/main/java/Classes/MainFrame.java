package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class MainFrame extends JFrame{

    private JTextField tfUsername;
    private JTextField tfPasswort;
    private JLabel lbLogin;
    private JLabel lbUsername;
    private JLabel lbPasswort;
    private JLabel lbPasswortRepat;
    private JTextField tfRepeatPasswort;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel mainPanel;
    private JCheckBox checkBox;

    public MainFrame() {
       setContentPane(mainPanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getName();
                String passwort = tfPasswort.getName();
                String repeatPasswort = tfRepeatPasswort.getName();

                if(!isUsernameTaken(username)){
                    if(repeatPasswort == passwort){
                        
                    }
                }


            }
        });


    }
    private boolean isUsernameTaken (String username){
        for(int i = 0; i < userlist.length; i++){
            if(username == userlist[i].username){
                return true;
            }
        }
        return false;
    }



    //User-data
    User[] userlist = {
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



    /*public static void main(String[] args){

    }*/
}
