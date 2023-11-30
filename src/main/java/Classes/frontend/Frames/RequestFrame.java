package Classes.frontend.Frames;

import Classes.frontend.Function;
import Classes.frontend.Refreshable;
import Classes.frontend.RequestType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestFrame extends JFrame {

    private JPanel requestPanel;

    //Labels
    private JLabel lbQuestion;
    private JLabel lbImage;
    private JLabel lbMessage;

    //Buttons
    private JButton btnNo;
    private JButton btnYes;
    private JPanel lbQuestionPanel;
    private JPanel btnColorPanel;

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

        uiDesignSetup();

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

    public void uiDesignSetup(){

        Color colorFgr = Color.WHITE;
        Color colorBgr = Color.GRAY;
        Color colorBorder = Color.DARK_GRAY;
        int thickness = 2;

        //PANELS

        requestPanel.setBackground(new Color(50,54,58));
        lbQuestionPanel.setBackground(colorBgr);

        //BUTTONS
        btnColorPanel.setBackground(Color.DARK_GRAY);

        //Background-Color
        btnYes.setBackground(colorBgr);
        btnNo.setBackground(colorBgr);

        //Text-Color
        btnYes.setForeground(colorFgr);
        btnYes.setForeground(colorFgr);

        //LABELS

        //Text-Color
        lbQuestion.setForeground(colorFgr);
        lbMessage.setForeground(colorFgr);

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

