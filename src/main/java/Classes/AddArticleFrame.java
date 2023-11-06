package Classes;

import javax.swing.*;
import java.util.ArrayList;

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

    private Data data = new Data();
    private ArrayList<Classes.Article> articles = data.getArticles();

    public AddArticleFrame(){
        setContentPane(addArticlePane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(false);
    }

}
