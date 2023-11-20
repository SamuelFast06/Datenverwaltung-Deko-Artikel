package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ArticlesFrame extends JFrame implements Refreshable, Function{

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
    private ArticlesFrame self = this;

    public ArticlesFrame(User iuser, Data data){
        this.data = data;
        user = iuser;
        self = this;
        this.informationForm = new InformationForm(data, InformationType.articles, this);
        this.scrollPanel.add(this.informationForm);
        this.lbManagementName.setText(data.getName());
        this.lbCurrentUser.setText(iuser.username);
        this.btnShowArticle.disable();
        setContentPane(managementPanel);
        setLocation(0,0);
        setSize(720,420);
        setResizable(false);
        btnManager();

        setVisible(true);
    }

    public void setupArticleList(){
    }

    public void selectArticle(Article article){
        // Article in ArticleList auswählen und article
        this.selectedArticle = article;
        if (selectedArticle != null) {
            btnShowArticle.enable();
        }
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
                RequestFrame requestFrame = new RequestFrame(RequestType.remove, self, self);
            }
        });

        btnShowArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedArticle != null) {
                    ShowArticleFrame showArticleFrame = new ShowArticleFrame(data, selectedArticle, self);
                }
            }
        });

        btnSetQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuantityFrame setQuantityFrame = new SetQuantityFrame(selectedArticle, data, self);
                informationForm.refresh();
            }
        });

        btnPlusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedArticle != null) {
                    selectedArticle.setArticleQuantity(selectedArticle.getArticleQuantity() + 1);
                    data.uploadDataToServer();
                    informationForm.refresh();
                    System.out.println("Plus quantity");
                } else {
                    System.out.println("No article selected");
                }
            }
        });

        btnMinusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedArticle != null) {
                    if (selectedArticle.getArticleQuantity() > 0) {
                        selectedArticle.setArticleQuantity(selectedArticle.getArticleQuantity() - 1);
                        data.uploadDataToServer();
                        informationForm.refresh();
                        System.out.println("Minus quantity");
                    } else {
                        System.out.println("The quantity cannot be negative");
                    }
                } else {
                    System.out.println("No article selected");
                }
            }
        });
    }

    public void apply(Boolean success) {
        if (success) {
            data.removeArticle(selectedArticle);
            informationForm.refresh();
            System.out.println("'remove article'");
            informationForm.setHighlited(0);
        } else {
            System.out.println("Article NOT saved.");
        }
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

