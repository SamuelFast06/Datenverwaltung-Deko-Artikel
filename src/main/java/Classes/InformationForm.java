package Classes;

import javax.swing.*;
import java.io.IOException;

public class InformationForm extends  JFrame {
    private JPanel panel;
    Data data;
    InformationType type;


    public InformationForm(Data data, InformationType type) {
        this.data = data;
        this.type = type;

        setContentPane(panel);
        setLocation(800,300);
        setSize(400,280);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setResizable(false);

        switch (type) {
            case articles:
                for (int i = 0; i < data.getArticles().size(); i++) {
                    ArticleButtonForm articleButton = new ArticleButtonForm(data.getArticles().get(i));
                    panel.add(articleButton);
                }
                break;
            case costumer:
                for (int i = 0; i < data.getCostumers().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getCostumers().get(i).getFirstName());
                    panel.add(label);
                }
                break;
            case contactPeople:
                for (int i = 0; i < data.getContactPeople().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getContactPeople().get(i).getFirstname());
                    panel.add(label);
                }
                break;
            case users:
                for (int i = 0; i < data.getUsers().size(); i++) {
                    JLabel label = new JLabel();
                    label.setText(data.getUsers().get(i).getUsername());
                    panel.add(label);
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