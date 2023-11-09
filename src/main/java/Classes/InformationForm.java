package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InformationForm extends JPanel {
    Data data;
    InformationType type;
    Article selectedArticle;


    public InformationForm(Data data, InformationType type) {
        this.data = data;
        this.type = type;
        this.selectedArticle = selectedArticle;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        switch (type) {
            case articles:
                for (int i = 0; i < data.getArticles().size(); i++) {
                    Article article = data.getArticles().get(i);
                    ArticleButton articleButton = new ArticleButton(data.getArticles().get(i));
                    JButton button = new JButton();
                    button.add(articleButton);
                    float btnMaxWith = button.getMaximumSize().width;
                    button.setAlignmentX(btnMaxWith);
                    int finalI = i;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new ShowArticleFrame(article);
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

    public static void main(String[] args) {
        try {
            Data data = ManagementController.getDataManagement("653932ce0574da7622bd9406");
            new InformationForm(data, InformationType.articles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

enum InformationType {
    articles, costumer, contactPeople, users, noType
}