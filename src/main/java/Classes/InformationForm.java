package Classes;

import Classes.Articles.Article;
import Classes.Articles.ArticleButton;
import Classes.Articles.ArticlesFrame;
import Classes.Costumers.Costumer;
import Classes.Costumers.CostumersFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationForm<T> extends JPanel {
    Data data;
    InformationType type;
    T parent;

    int highlited = 0;
    private EmptyBorder paddingBorder = new EmptyBorder(2,0,2,0);


    public InformationForm(Data data, InformationType type, T parent) {
        this.data = data;
        this.type = type;
        this.parent = parent;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        refresh();

        setVisible(true);
    }

    public void refresh() {
        this.removeAll();

        switch (type) {
            case articles:
                ArticlesFrame articlesFrame = (ArticlesFrame) parent;
                for (int i = 0; i < data.getArticles().size(); i++) {
                    Article article = data.getArticles().get(i);
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
                for (int i = 0; i < data.getCostumers().size(); i++) {
                    Costumer costumer = data.getCostumers().get(i);
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
                for (int i = 0; i < data.getContactPeople().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getContactPeople().get(i).getFirstname());
                    this.add(label);
                }
                break;
            case users:
                for (int i = 0; i < data.getUsers().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getUsers().get(i).getUsername());
                    this.add(label);
                }
                break;
            case noType:
                break;
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

