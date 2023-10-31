package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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

    private Data data = new Data(true);
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
                data.reloadData();
                String username = tfUsername.getText();
                String passwort = tfPasswort.getText();
                if(isUsernameAvailable(username)){
                    if(wrongPWcount < 3){
                        if(passwort.equals(users.get(userindex).passwort)) {
                            lbMessage.setText("login success");
                            clearAllTf();
                            tfPasswort.disable();
                            tfUsername.disable();
                            btnOK.disable();
                            btnCancel.disable();
                            startManagment(userindex);
                            dispose();
                        } else{
                            tfPasswort.setText("");
                            wrongPWcount++;
                            lbMessage.setText("Passwort is wrong! " + (3 -wrongPWcount) + " Attemps left");
                        }
                    }else if(wrongPWcount == 3){
                        clearAllTf();
                        lbMessage.setText("TOO MANY ATTEMPTS! Number of Trys is exceeded");
                        tfPasswort.disable();
                        tfUsername.disable();
                        btnOK.disable();

                    }
                }else{
                    lbMessage.setText("A user with the username "+"["+ username + "]" +" is not available");
                }

            }
       });
       btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterFrame registry = new RegisterFrame();
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

    private void startManagment(int userindex){
        User user = users.get(userindex);
        ManagementFrame management = new ManagementFrame(user);
    }

    public static void main(String[] args){
        LoginFrame login = new LoginFrame();
    }
}
