package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShowArticleFrame extends JFrame{
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
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel lbQuantity;
    private JLabel lbColor;
    private JLabel lbWeight;
    private JLabel lbDescription;
    private JPanel showArticlePane;
    private JCheckBox cbEdit;
    private JScrollBar scrollBar1;
    private JLabel lbImage;

    private Data data;

    private Article slcArticle;

    public ShowArticleFrame(Article article){
        slcArticle = article;
        setContentPane(showArticlePane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(false);

        setup();

        tfName.disable();
        tfPrice.disable();
        tfQuantity.disable();
        tfColor.disable();
        tfWeight.disable();
        tfDescription.disable();
        tfLength.disable();
        tfWide.disable();
        tfHeight.disable();

        lbName.setText(article.getArticleName());
        lbPrice.setText(""+article.getArticlePrice()+"");
        lbQuantity.setText(""+article.getArticleQuantity()+"");
        lbColor.setText(article.getArticleColor());
        lbWeight.setText(article.getArticleWeight());
        lbLength.setText(""+article.getArticleMeasures().getLength()+"");
        lbWide.setText(""+article.getArticleMeasures().getWide()+"");
        lbHeight.setText(""+article.getArticleMeasures().getHeight()+"");

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        lbImage.setIcon(icon);

        /*if(slcArticle != null){
            setup();
        }
        */
    }


    public void setup(){

        tfName.setText(slcArticle.getArticleName());
        tfPrice.setText(Double.toString(slcArticle.getArticlePrice()));
        tfQuantity.setText(Integer.toString(slcArticle.getArticleQuantity()));
        tfColor.setText(slcArticle.getArticleColor());
        tfWeight.setText(slcArticle.getArticleName());
        tfDescription.setText(slcArticle.getArticleDescription());
        tfLength.setText(Double.toString(slcArticle.getArticleMeasures().getLength()));
        tfWide.setText(Double.toString(slcArticle.getArticleMeasures().getWide()));
        tfHeight.setText(Double.toString(slcArticle.getArticleMeasures().getHeight()));

        btnSave.disable();

        cbEdit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){

                    btnSave.enable();

                    tfName.enable();
                    tfPrice.enable();
                    tfQuantity.enable();
                    tfColor.enable();
                    tfWeight.enable();
                    tfDescription.enable();
                    tfLength.enable();
                    tfWide.enable();
                    tfHeight.enable();
                }

                if(e.getStateChange() == ItemEvent.DESELECTED){

                    btnSave.disable();

                    tfName.disable();
                    tfPrice.disable();
                    tfQuantity.disable();
                    tfColor.disable();
                    tfWeight.disable();
                    tfDescription.disable();
                    tfLength.disable();
                    tfWide.disable();
                    tfHeight.disable();
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RequestFrame request = new RequestFrame("Edit");

                if(request.getRequestYes() == true){
                    slcArticle.setArticleName(tfName.getText());
                    slcArticle.setArticlePrice(Double.valueOf(tfPrice.getText()));
                    slcArticle.setArticleQuantity(Integer.valueOf(tfQuantity.getText()));
                    slcArticle.setArticleColor(tfColor.getText());
                    slcArticle.setArticleWeight(tfWeight.getText());
                    slcArticle.setArticleDescription(tfDescription.getText());
                    slcArticle.setArticleMeasures(new Measures(Double.valueOf(tfLength.getText()),Double.valueOf(tfWide.getText()),Double.valueOf(tfHeight.getText())));

                    System.out.println("article changed");
                    dispose();
                }else if(request.getRequestNo() == true){
                    System.out.println("article NOT changed");
                    dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
