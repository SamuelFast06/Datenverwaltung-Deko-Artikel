package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class LoginFrame extends JFrame{

    private JTextField tfUsername;
    private JTextField tfPasswort;
    private JLabel lbLogin;
    private JLabel lbUsername;
    private JLabel lbPasswort;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JLabel lbMessage;
    private JButton btnRegistry;
    private JCheckBox checkBox;

    private int userindex;
    private int wrongPWcount = 0;

    private Data data = new Data(true);
    private ArrayList<Classes.User> users = data.getUsers();

    public LoginFrame() {
       setContentPane(loginPanel);
        setSize(500,280);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String passwort = tfPasswort.getText();
                if(isUsernameTaken(username)){
                    if(wrongPWcount < 3){
                        if(passwort.equals(users.get(userindex).passwort)) {
                            lbMessage.setText("login success");
                            clearAllTf();
                            //MainFrame();
                        } else{
                            tfPasswort.setText("");
                            wrongPWcount++;
                            lbMessage.setText("Passwort is wrong!" + " Wrong Passwort-counter: " + wrongPWcount);
                        }
                    }else if(wrongPWcount == 3){
                        clearAllTf();
                        lbMessage.setText("Wrong Passwort-counter is exceeded (" + wrongPWcount + ")");
                        tfPasswort.disable();
                        tfUsername.disable();

                    }



                }

            }
        });
        btnRegistry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistryFrame registry = new RegistryFrame();
            }
        });

    }


    private boolean isUsernameTaken(String username){
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

    private void loginSuccess(){

    }

    public static void main(String[] args){
        LoginFrame login = new LoginFrame();
    }
}
