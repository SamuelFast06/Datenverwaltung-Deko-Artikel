package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                String username = tfUsername.getText();
                String passwort = tfPasswort.getText();
                String repeatPasswort = tfRepeatPasswort.getText();

                if(isUsernameTaken(username) == false){
                    if(repeatPasswort == passwort){
                        userlist[userlist.length+1] = new User(username,passwort, userlist.length+1);
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
     new User("kotbeutel4", "kamin187", 1),
     new User("ralf88", "kamin187", 2),
     new User("bob9", "kamin187", 3),
     new User("gandalf666", "kamin187", 4),
     new User("fridolin187", "kamin187", 5),
     new User("galoina3", "kamin187", 6),
     new User("andrusch5", "kamin187", 7),
     new User("josef888", "kamin187", 8),
     new User("freddyFazbear123", "kamin187", 9),
     new User("rootbeer", "kamin187", 10)};



    /*public static void main(String[] args){

    }*/
}
