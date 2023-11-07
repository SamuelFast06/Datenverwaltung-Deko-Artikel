package Classes;

import javax.swing.*;

public class InformationFrame {
    private Data data;
    private Informationtype type = Informationtype.noType;
    private JPanel panel;

    public InformationFrame(Data data, Informationtype type) {
        this.data = data;
        this.type = type;
        switch (type) {
            case articles:
                for (int i = 0; i < data.getArticles().size(); i++) {
                    panel.add(new JLabel(data.getArticles().get(i).getArticleName()));
                }
                break;
            case costumers:
                for (int i = 0; i < data.getCostumers().size(); i++) {
                    panel.add(new JLabel(data.getCostumers().get(i).getFirstName()));
                }
                break;
            case contactPeople:
                for (int i = 0; i < data.getContactPeople().size(); i++) {
                    panel.add(new JLabel(data.getContactPeople().get(i).getFirstname()));
                }
                break;
            case users:
                for (int i = 0; i < data.getUsers().size(); i++) {
                    panel.add(new JLabel(data.getUsers().get(i).getUsername()));
                }
                break;
            case noType:
                break;
        }

    }
}

enum Informationtype {
    articles, costumers, contactPeople, users, noType
}
