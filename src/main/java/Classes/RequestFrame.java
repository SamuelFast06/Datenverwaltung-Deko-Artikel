package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.Authenticator;

public class RequestFrame extends JFrame {

    private JPanel requestPanel;

    //Labels
    private JLabel lbQuestion;
    private JLabel lbImage;
    private JLabel lbMessage;

    //Buttons
    private JButton btnNo;
    private JButton btnYes;

    //Other

    private static boolean requestYes;
    private static boolean requestNo;


    public RequestFrame(RequestType type, Function function, Refreshable refreshForm){
        setContentPane(requestPanel);
        setLocation(800,300);
        setSize(300,380);
        setVisible(true);
        setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("dog-question.jpg"));
        lbImage.setIcon(icon);

        try{

            switch(type){

                case edit:
                    lbQuestion.setText("Save this element?");
                    lbMessage.setText("The previous element will be replaced!!");

                    btnYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            function.apply(true);
                            refreshForm.refreshInformationPanel();
                            dispose();
                        }
                    });

                    btnNo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            function.apply(false);
                            dispose();
                        }
                    });
                    break;
                case remove:
                    lbQuestion.setText("Remove this element?");
                    lbMessage.setText("Tthe element will be permanently deleted!!");

                    btnYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            function.apply(true);
                            refreshForm.refreshInformationPanel();
                            dispose();
                        }
                    });

                    btnNo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            function.apply(false);
                            dispose();
                        }
                    });
                    break;
                default:
                    System.out.println("Wrong request-argument");
                    dispose();
                    break;
            }

        } catch(NumberFormatException ex){
            throw new RuntimeException(ex);
        }

    }

    public boolean getRequestYes() {
        return requestYes;
    }

    public void setRequestYes(boolean requestYes) {
        this.requestYes = requestYes;
    }

    public static boolean getRequestNo() {
        return requestNo;
    }

    public static void setRequestNo(boolean requestNo) {
        RequestFrame.requestNo = requestNo;
    }
}

