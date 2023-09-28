package Classes;

import javax.swing.*;

public class MainFrame extends JFrame{

    private JTextField tfUsername;
    private JTextField tfPasswort;
    private JLabel lbLogin;
    private JLabel lbUsername;
    private JLabel lbPasswort;
    private JLabel lbPasswortRepat;
    private JTextField textField1;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel mainPanel;
    private JCheckBox checkBox;

    public MainFrame() {
       setContentPane(mainPanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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
