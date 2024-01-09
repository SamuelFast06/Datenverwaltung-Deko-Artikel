package Classes.frontend;

import Classes.Articles.Article;
import Classes.Articles.ArticleButton;
import Classes.Articles.ArticlesFrame;
import Classes.ContactPersons.ContactPerson;
import Classes.Costumers.Costumer;
import Classes.Costumers.CostumersFrame;
import Classes.Firebase.FirebaseContext;
import Classes.User.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InformationForm<T> extends JPanel {

    InformationType type;
    T parent;
    FirebaseContext firebaseContext;

    int highlited = 0;
    private EmptyBorder paddingBorder = new EmptyBorder(2,0,2,0);


    public InformationForm(FirebaseContext firebaseContext, InformationType type, T parent) {
        this.firebaseContext = firebaseContext;
        this.type = type;
        this.parent = parent;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        refresh();

        setVisible(true);
    }

    public void refresh(){
        this.removeAll();

        try {
            switch (type) {
                case articles:
                    ArticlesFrame articlesFrame = (ArticlesFrame) parent;

                    ArrayList articles = firebaseContext.getDocuments(Article.class);
                    for (int i = 0; i < articles.size(); i++) {
                        Article article = (Article) articles.get(i);
                        int currentValue = i + 1;
                        ArticleButton articleButton = new ArticleButton(article);
                        JButton button = new JButton();
                        button.setBorder(BorderFactory.createLineBorder(currentValue == highlited ? new Color(35, 198, 211) : new Color(24, 129, 165), 5, true));

                        JPanel buttonPanel = new JPanel();
                        button.add(articleButton);
                        buttonPanel.add(button);
                        buttonPanel.setBorder(paddingBorder);
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (highlited != currentValue) {
                                    highlited = currentValue;
                                    articlesFrame.setSelectArticle(article);
                                    refresh();
                                } else {
                                    highlited = 0;
                                    articlesFrame.setSelectArticle(null);
                                    refresh();
                                }
                            }
                        });
                        this.add(buttonPanel);
                    }
                    break;
                case costumer:
                    CostumersFrame costumersFrame = (CostumersFrame) parent;

                    ArrayList costumers = firebaseContext.getDocuments(Costumer.class);
                    for (int i = 0; i < costumers.size(); i++) {
                        Costumer costumer = (Costumer) costumers.get(i);
                        int currentValue = i + 1;
                        DataButton dataButton = new DataButton(costumer);
                        JButton button = new JButton();
                        button.setBorder(BorderFactory.createLineBorder(currentValue == highlited ? new Color(35, 198, 211) : new Color(24, 129, 165), 5, true));

                        JPanel buttonPanel = new JPanel();
                        button.add(dataButton);
                        buttonPanel.add(button);
                        buttonPanel.setBorder(paddingBorder);
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (highlited != currentValue) {
                                    highlited = currentValue;
                                    costumersFrame.setSelectedCostumer(costumer);
                                    refresh();
                                } else {
                                    highlited = 0;
                                    costumersFrame.setSelectedCostumer(null);
                                    refresh();
                                }
                            }
                        });
                        this.add(buttonPanel);
                    }
                    break;
                case contactPeople:

                    ArrayList contactPersons = firebaseContext.getDocuments(ContactPerson.class);
                    for (int i = 0; i < contactPersons.size(); i++) {
                        JLabel label = new JLabel();
                        label.setText(((ContactPerson) contactPersons.get(i)).getFirstname());
                        this.add(label);
                    }
                    break;


                case users:

                    ArrayList users = firebaseContext.getDocuments(User.class);
                    for (int i = 0; i < users.size(); i++) {
                        JLabel label = new JLabel();
                        label.setText(((User) users.get(i)).getEmailAddress());
                        this.add(label);
                    }
                    break;
                case noType:
                    break;
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        this.updateUI();
    }

    public int getHighlited() {
        return highlited;
    }

    public void setHighlited(int highlited) {
        this.highlited = highlited;
    }
}

