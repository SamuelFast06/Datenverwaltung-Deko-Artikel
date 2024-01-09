package Classes.Articles;

import Classes.*;
import Classes.Firebase.FirebaseContext;
import Classes.User.User;
import Classes.frontend.*;
import Classes.frontend.Frames.RequestFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ArticlesFrame extends JFrame implements Refreshable, Function {

    private JPanel articlesPanel;

    //Labels
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;

    //Buttons
    private JButton btnRemoveArticle;
    private JButton btnAddArticle;
    private JButton btnShowArticle;
    private JButton btnSetQuantity;
    private JButton btnMinusQuantity;
    private JButton btnPlusQuantity;

    //Other
    private JScrollPane scrollPane;
    private JPanel scrollPanel;

    private FirebaseContext firebaseContext;
    private Article selectedArticle;
    private InformationForm informationForm;
    private ArticlesFrame self = this;

    public ArticlesFrame(FirebaseContext firebaseContext){
        this.firebaseContext = firebaseContext;

        User user = firebaseContext.currentUser;

        self = this;
        this.informationForm = new InformationForm(firebaseContext, InformationType.articles, this);
        this.scrollPanel.add(this.informationForm);
        this.lbManagementName.setText(firebaseContext.getManagement().getName());
        //this.lbCurrentUser.setText(user.getUsername());
        this.btnShowArticle.disable();
        setContentPane(articlesPanel);
        setLocation(800,300);
        setSize(720,420);
        setResizable(false);
        btnManager();
        disableButtons();

        setVisible(true);
    }

    public void setupArticleList(){
    }

    public void setSelectArticle(Article article){
        // Article in ArticleList auswählen und article
        this.selectedArticle = article;
        if (selectedArticle != null) {
            enableButtons();
        } else {
            disableButtons();
        }
    }

    private void enableButtons() {
        btnShowArticle.setEnabled(true);
        btnMinusQuantity.setEnabled(true);
        btnPlusQuantity.setEnabled(true);
        btnRemoveArticle.setEnabled(true);
        btnSetQuantity.setEnabled(true);

        refreshInformationPanel();
    }

    private void disableButtons() {
        btnShowArticle.setEnabled(false);
        btnMinusQuantity.setEnabled(false);
        btnPlusQuantity.setEnabled(false);
        btnRemoveArticle.setEnabled(false);
        btnSetQuantity.setEnabled(false);

        refreshInformationPanel();
    }


    public void btnManager(){
        btnAddArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddArticleFrame addArticleFrame = new AddArticleFrame(firebaseContext, self);
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
                    ShowArticleFrame showArticleFrame = new ShowArticleFrame(firebaseContext, selectedArticle, self);
                }
            }
        });

        btnSetQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuantityFrame setQuantityFrame = new SetQuantityFrame(selectedArticle, firebaseContext, self);
                informationForm.refresh();
            }
        });

        btnPlusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedArticle != null) {
                    selectedArticle.setArticleQuantity(selectedArticle.getArticleQuantity() + 1);
                    firebaseContext.editDocument(selectedArticle);
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
                        firebaseContext.editDocument(selectedArticle);
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
            firebaseContext.removeDocument(selectedArticle.getId(), Article.class);
            informationForm.refresh();
            System.out.println("'remove article'");
            informationForm.setHighlited(0);
        } else {
            System.out.println("Article NOT removed.");
        }
    }

    public void refreshInformationPanel() { informationForm.refresh(); }
}

