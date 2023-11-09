package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class AddArticleFrame extends JFrame{
    private JLabel lbHeadline;
    private JLabel lbName;
    private JLabel lbPrice;
    private JLabel lbMeasures;
    private JLabel lbLength;
    private JLabel lbWide;
    private JLabel lbHeight;
    private JTextField tfName;
    private JTextField tfPrice;
    private JTextField tfQuantity;
    private JTextField tfColor;
    private JTextField tfWeight;
    private JTextField tfLength;
    private JTextField tfWide;
    private JTextField tfHeight;
    private JTextPane tfDescription;
    private JButton btnAdd;
    private JButton btnCancel;
    private JLabel lbQuantity;
    private JLabel lbColor;
    private JLabel lbWeight;
    private JLabel lbDescription;
    private JPanel addArticlePane;
    private JLabel lbArticleNo;
    private JTextField tfArticleNo;
    private Data data;


    public AddArticleFrame(Data data){
        this.data = data;
        setContentPane(addArticlePane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(true);

        btnManager();
    }

    public void btnManager(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atNo = tfArticleNo.getText();
                String atName = tfName.getText();
                String atPrice = tfPrice.getText();
                String atQuantity = tfQuantity.getText();
                String atColor = tfColor.getText();
                String atWeight = tfWeight.getText();
                String atLength = tfLength.getText();
                String atWide = tfWide.getText();
                String atHeight = tfHeight.getText();
                String atDescription = tfDescription.getText();

                Article newArticle = new Article(UUID.randomUUID(),Integer.valueOf(atNo),atName,atWeight,atDescription,atColor,Double.valueOf(atPrice),Integer.valueOf(atQuantity), new Measures(Double.valueOf(atLength),Double.valueOf(atWide),Double.valueOf(atHeight)));
                data.addArticle(newArticle);
            }
        });
    }

}
