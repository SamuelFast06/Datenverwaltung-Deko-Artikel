package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton btnAdd;
    private JButton btnCancel;
    private JLabel lbQuantity;
    private JLabel lbColor;
    private JLabel lbWeight;
    private JLabel lbDescription;
    private JPanel showArticlePane;
    private JCheckBox cbEdit;

    private Data data = new Data();
    private ArrayList<Article> articles = data.getArticles();

    private Article slcArticle;

    public ShowArticleFrame(Article article){
        slcArticle = article;
        setContentPane(showArticlePane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(false);

        lbName.setText(article.getArticleName());
        lbPrice.setText(""+article.getArticlePrice()+"");
        lbQuantity.setText(""+article.getArticleQuantity()+"");
        lbColor.setText(article.getArticleColor());
        lbWeight.setText(article.getArticleWeight());
        lbLength.setText(""+article.getArticleMeasures().getLength()+"");
        lbWide.setText(""+article.getArticleMeasures().getWide()+"");
        lbHeight.setText(""+article.getArticleMeasures().getHeight()+"");

        if(slcArticle != null){
            setupTextfields();
        }
    }


    public void setupTextfields(){

        tfName.setText(slcArticle.getArticleName());
        tfPrice.setText(Double.toString(slcArticle.getArticlePrice()));
        tfQuantity.setText(Integer.toString(slcArticle.getArticleQuantity()));
        tfColor.setText(slcArticle.getArticleColor());
        tfWeight.setText(slcArticle.getArticleName());
        tfDescription.setText(slcArticle.getArticleDescription());
        tfLength.setText(Double.toString(slcArticle.getArticleMeasures().getLength()));
        tfWide.setText(Double.toString(slcArticle.getArticleMeasures().getWide()));
        tfHeight.setText(Double.toString(slcArticle.getArticleMeasures().getHeight()));

        if(cbEdit.isSelected() == false){
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
        if(cbEdit.isSelected() == true){
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
    }

}
