package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ArticlesFrame extends JFrame {

    private JPanel managementPanel;
    private JButton btnRemoveArticle;
    private JButton btnAddArticle;
    private JButton btnShowArticle;
    private JButton btnSetQuantity;
    private JButton btnMinusQuantity;
    private JButton btnPlusQuantity;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;
    private JPanel scrollPanel;
    private Data data = new Data();
    private ArrayList<Classes.Article> articles = data.getArticles();
    private User user;

    private Article selectedArticle;

    public ArticlesFrame(User iuser, Data data){
        user = iuser;
        this.scrollPanel.add(new InformationForm(data, InformationType.articles));
        this.lbManagementName.setText(data.getName());
        this.lbCurrentUser.setText(iuser.username);
        setContentPane(managementPanel);
        setLocation(0,0);
        setSize(1020,420);
        setResizable(false);
        btnManager();

        setVisible(true);
    }

    public void setupArticleList(){
    }

    public Article selectArticle(Article article){
        // Article in ArticleList auswählen und article

        return article;
    }


    public void btnManager(){
        btnAddArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddArticleFrame addArticleFrame = new AddArticleFrame();
            }
        });

        btnRemoveArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.removeArticle(selectedArticle); //brauch ich hier noch suchen ????
                System.out.println("'remove article'");
            }
        });

        btnShowArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowArticleFrame showArticleFrame = new ShowArticleFrame(selectedArticle);
            }
        });

        btnSetQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("'set quantity'");
            }
        });

        btnPlusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("'plus quantity'");
            }
        });

        btnMinusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("'minus quantity'");
            }
        });
    }

    public static void main(String[] args){
        User testuser = new User();
        testuser.username = "testuser";
        testuser.passwort = "test";
        try {
            ArticlesFrame articlesManage = new ArticlesFrame(testuser, ManagementController.getDataManagement("653932ce0574da7622bd9406"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
