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
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;
    private JPanel scrollPanel;
    private User user;

    private Data data;
    private Article selectedArticle;
    private InformationForm informationForm;
    private ArticlesFrame self;

    public ArticlesFrame(User iuser, Data data){
        this.data = data;
        user = iuser;
        self = this;
        this.informationForm = new InformationForm(data, InformationType.articles, this);
        this.scrollPanel.add(this.informationForm);
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

    public void selectArticle(Article article){
        // Article in ArticleList auswählen und article
        this.selectedArticle = article;
    }


    public void btnManager(){
        btnAddArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddArticleFrame addArticleFrame = new AddArticleFrame(data, self);
            }
        });

        btnRemoveArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.removeArticle(selectedArticle);
                informationForm.refresh();
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
                informationForm.refresh();
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

    public void refreshInformationPanel() { informationForm.refresh(); }

    public static void main(String[] args){
        User testuser = new User();
        testuser.username = "testuser";
        testuser.passwort = "test";
        try {
            ArticlesFrame articlesManage = new ArticlesFrame(testuser, ManagementController.getDataManagement("654c908654105e766fcd758e"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
