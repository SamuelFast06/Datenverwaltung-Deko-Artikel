package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InformationForm extends JPanel {
    Data data;
    InformationType type;
    ArticlesFrame parent;


    public InformationForm(Data data, InformationType type, ArticlesFrame parent) {
        this.data = data;
        this.type = type;
        this.parent = parent;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        switch (type) {
            case articles:
                for (int i = 0; i < data.getArticles().size(); i++) {
                    Article article = data.getArticles().get(i);
                    ArticleButton articleButton = new ArticleButton(data.getArticles().get(i));
                    JButton button = new JButton();
                    button.add(articleButton);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            parent.selectArticle(article);
                        }
                    });
                    this.add(button);
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
                    ArticleButton articleButton = new ArticleButton(article);
                    JButton button = new JButton();
                    button.add(articleButton);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            parent.selectArticle(article);
                        }
                    });
                    this.add(button);
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


}

enum InformationType {
    articles, costumer, contactPeople, users, noType
}