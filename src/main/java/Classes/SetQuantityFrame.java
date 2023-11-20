package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetQuantityFrame extends JFrame {
    JTextField tfQuantity;
    Article selectedArticle;
    JPanel quantityPanel;
    JButton btnSave;
    Data data;

    public SetQuantityFrame(Article selectedArticle, Data data, Refreshable refreshForm) {
        setContentPane(quantityPanel);
        setLocation(800,300);
        setSize(300,380);
        setVisible(true);
        setResizable(false);

        tfQuantity.setText(String.valueOf(selectedArticle.getArticleQuantity()));

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedArticle.setArticleQuantity(Integer.parseInt(tfQuantity.getText()));
                data.uploadDataToServer();
                refreshForm.refreshInformationPanel();
            }
        });
    }


}

