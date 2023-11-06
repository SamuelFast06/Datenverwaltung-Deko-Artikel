package Classes;

import Classes.Files.LListInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

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
    private Data data = new Data();
    private ArrayList<Classes.Article> articles = data.getArticles();
    private User user;

    private Article selectedArticle;

    public ArticlesFrame(User iuser){
        user = iuser;
        setContentPane(managementPanel);
        setLocation(0,0);
        setSize(1020,420);
        setVisible(true);
        setResizable(false);
        btnManager();
    }

    public void setupArticleList(){
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
        ArticlesFrame articlesManage = new ArticlesFrame(testuser);
    }
}
