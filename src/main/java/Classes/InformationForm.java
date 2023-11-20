package Classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InformationForm extends JPanel {
    Data data;
    InformationType type;
    ArticlesFrame parent;

    int highlited = 0;
    private EmptyBorder paddingBorder = new EmptyBorder(2,0,2,0);


    public InformationForm(Data data, InformationType type, ArticlesFrame parent) {
        this.data = data;
        this.type = type;
        this.parent = parent;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        switch (type) {
            case articles:
                for (int i = 0; i < data.getArticles().size(); i++) {
                    Article article = data.getArticles().get(i);
                    int currentValue = i + 1;
                    ArticleButton articleButton = new ArticleButton(data.getArticles().get(i));
                    JButton button = new JButton();
                    button.setBorder(BorderFactory.createLineBorder(currentValue == highlited ? new Color(35, 198, 211) : new Color(24, 129, 165), 5, true));
                    JPanel buttonPanel = new JPanel();
                    button.add(articleButton);
                    buttonPanel.add(button);
                    buttonPanel.setBorder(paddingBorder);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            highlited = currentValue;
                            parent.selectArticle(article);
                            refresh();
                        }
                    });
                    this.add(buttonPanel);

                }
                break;
            case costumer:
                for (int i = 0; i < data.getCostumers().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getCostumers().get(i).getFirstName());
                    this.add(label);
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

        setVisible(true);
    }

    public void refresh() {
        this.removeAll();

        switch (type) {
            case articles:
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
                            highlited = currentValue;
                            parent.selectArticle(article);
                            refresh();
                        }
                    });
                    this.add(buttonPanel);
                }
                break;
            case costumer:
                for (int i = 0; i < data.getCostumers().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getCostumers().get(i).getFirstName());
                    this.add(label);
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

enum InformationType {
    articles, costumer, contactPeople, users, noType
}