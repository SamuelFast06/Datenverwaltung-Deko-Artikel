package Classes.Articles;

import Classes.Firebase.FirebaseContext;
import Classes.frontend.Refreshable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetQuantityFrame extends JFrame {

    private JPanel quantityPanel;

    //Labels
    private JLabel lbMessage;

    //Textfields
    private JTextField tfQuantity;

    //Buttons
    private JButton btnSave;

    //Other

    private Article selectedArticle;
    private FirebaseContext firebaseContext;

    public SetQuantityFrame(Article selectedArticle, FirebaseContext firebaseContext, Refreshable refreshForm) {
        this.selectedArticle = selectedArticle;
        setContentPane(quantityPanel);
        setLocation(800,300);
        setSize(300,200);
        setVisible(true);
        setResizable(false);

        tfQuantity.setText(String.valueOf(selectedArticle.getArticleQuantity()));

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newValue = Integer.parseInt(tfQuantity.getText());
                if (checkChanges(newValue)) {
                    selectedArticle.setArticleQuantity(newValue);
                    firebaseContext.editDocument(selectedArticle);
                    refreshForm.refreshInformationPanel();
                    lbMessage.setText("Quantity updates.");

                    dispose();
                }
            }
        });
    }

    private boolean checkChanges(int value) {
        if (value < 0) {
            lbMessage.setText("Do not use negative numbers.");
            return false;
        }
        if (selectedArticle.getArticleQuantity() != value) return true;
        lbMessage.setText("Please use another value.");
        return false;
    }


}

