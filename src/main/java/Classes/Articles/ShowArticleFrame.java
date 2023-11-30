package Classes.Articles;

import Classes.Data;
import Classes.Function;
import Classes.RequestFrame;
import Classes.RequestType;
import Classes.SubClasses.Measures;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShowArticleFrame extends JFrame implements Function {

    private JPanel showArticlePane;

    //Labels
    private JLabel lbHeadline;
    private JLabel lbName;
    private JLabel lbPrice;
    private JLabel lbMeasures;
    private JLabel lbLength;
    private JLabel lbWide;
    private JLabel lbHeight;
    private JLabel lbQuantity;
    private JLabel lbColor;
    private JLabel lbWeight;
    private JLabel lbDescription;
    private JLabel lbImage;

    //TextFields
    private JTextField tfName;
    private JTextField tfPrice;
    private JTextField tfQuantity;
    private JTextField tfColor;
    private JTextField tfWeight;
    private JTextField tfLength;
    private JTextField tfWide;
    private JTextField tfHeight;

    //Buttons
    private JButton btnSave;
    private JButton btnCancel;

    //Other
    private JCheckBox cbEdit;
    private JScrollBar scrollBar1;
    private JTextPane tfDescription;


    private Data data;
    private ArticlesFrame articlesFrame;

    private Article slcArticle;
    private ShowArticleFrame self = this;


    public ShowArticleFrame(Data data, Article article, ArticlesFrame articlesFrame){
        this.data = data;
        this.articlesFrame = articlesFrame;
        slcArticle = article;
        setContentPane(showArticlePane);
        setLocation(800,300);
        setSize(400,400);
        setVisible(true);
        setResizable(true);

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

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        lbImage.setIcon(icon);

    }

    public void apply(Boolean success) {
        if (success) {
            editArticle();
        } else {
            System.out.println("Article NOT saved!");
        }
    }

    public void setup(){

        tfName.setText(slcArticle.getArticleName());
        tfPrice.setText(Double.toString(slcArticle.getArticlePrice()));
        tfQuantity.setText(Integer.toString(slcArticle.getArticleQuantity()));
        tfColor.setText(slcArticle.getArticleColor());
        tfWeight.setText(slcArticle.getArticleName());
        tfDescription.setText(slcArticle.getArticleDescription());
        tfLength.setText(Double.toString(slcArticle.getArticleMeasures().getLength().getValue()));
        tfWide.setText(Double.toString(slcArticle.getArticleMeasures().getWide().getValue()));
        tfHeight.setText(Double.toString(slcArticle.getArticleMeasures().getHeight().getValue()));

        btnSave.setEnabled(false);

        cbEdit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){

                    btnSave.setEnabled(true);

                    tfName.setEnabled(true);
                    tfPrice.setEnabled(true);
                    tfQuantity.setEnabled(true);
                    tfColor.setEnabled(true);
                    tfWeight.setEnabled(true);
                    tfDescription.setEnabled(true);
                    tfLength.setEnabled(true);
                    tfWide.setEnabled(true);
                    tfHeight.setEnabled(true);

                }

                if(e.getStateChange() == ItemEvent.DESELECTED){

                    btnSave.setEnabled(false);

                    tfName.setEnabled(false);
                    tfPrice.setEnabled(false);
                    tfQuantity.setEnabled(false);
                    tfColor.setEnabled(false);
                    tfWeight.setEnabled(false);
                    tfDescription.setEnabled(false);
                    tfLength.setEnabled(false);
                    tfWide.setEnabled(false);
                    tfHeight.setEnabled(false);
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame request = new RequestFrame(RequestType.edit, self, self.articlesFrame);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    void editArticle() {
        slcArticle.setArticleName(tfName.getText());
        slcArticle.setArticlePrice(Double.valueOf(tfPrice.getText()));
        slcArticle.setArticleQuantity(Integer.valueOf(tfQuantity.getText()));
        slcArticle.setArticleColor(tfColor.getText());
        //slcArticle.setArticleWeight(Double.valueOf(tfWeight.getText()),/*WeightUnit*/);
        slcArticle.setArticleDescription(tfDescription.getText());
        //slcArticle.setArticleMeasures(new Measures(Double.valueOf(tfLength.getText()),Double.valueOf(tfWide.getText()),Double.valueOf(tfHeight.getText())));

        data.uploadDataToServer();

        System.out.println("article changed");
        dispose();
    }

    public ArticlesFrame getArticlesFrame() {
        return articlesFrame;
    }

    public void setArticlesFrame(ArticlesFrame articlesFrame) {
        this.articlesFrame = articlesFrame;
    }
}
