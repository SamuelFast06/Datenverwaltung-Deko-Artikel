package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class ManagementFrame extends JFrame{

    private JPanel managementPanel;
    private JButton btnSettings;
    private JButton btnArticles;
    private JButton btnCustomers;
    private JButton btnContactPersons;
    private JLabel lbManagementName;
    private JLabel lbCurrentUser;
    private JLabel lbMessage;
    private JLabel imgLabel;

    InformationType tappedType = InformationType.noType;

    private Data data;

    private User user;

    public ManagementFrame(User iuser, Data data){
        this.data = data;
        setContentPane(managementPanel);
        this.user = iuser;
        lbCurrentUser.setText(user.username);
        lbManagementName.setText(data.getName());
        setLocation(0,0);
        setSize(720,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnManager();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("le monkeSMOLL.png"));
        imgLabel.setIcon(icon);
    }

    public void btnManager(){
        btnArticles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArticlesFrame articlesManagement = new ArticlesFrame(user, data);
            }
        });

        btnCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnContactPersons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){

        ManagementFrame test = new ManagementFrame(new User(), new Data());

        /*try {
            Data data = ManagementController.getDataManagement("653932ce0574da7622bd9406");
            ManagementFrame management = new ManagementFrame(new User(), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
    }

}
