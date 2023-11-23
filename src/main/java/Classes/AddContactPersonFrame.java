package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class AddContactPersonFrame extends JFrame{
    private JLabel lbHeadline;
    private JLabel lbLastName;
    private JLabel lbCompany;
    private JTextField tfLength;
    private JTextField tfWide;
    private JTextField tfHeight;
    private JTextPane tfDescription;
    private JButton btnAdd;
    private JButton btnCancel;
    private JLabel lbAddress;
    private JLabel lbBranchtype;
    private JLabel lbmobilenumber;
    private JPanel addCustomerPane;
    private JLabel lbFirstName;
    private JLabel lbMessage;
    private JLabel lbImage;
    private JScrollBar scrollBar1;
    private Data data;
    private ArticlesFrame parent;

    public AddContactPersonFrame(Data data, ArticlesFrame parent){
        this.data = data;
        this.parent = parent;
        setContentPane(addCustomerPane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(true);

        btnManager();
    }

    public void btnManager(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atNo = tfArticleNo.getText();
                String atName = tfName.getText();
                String atPrice = tfPrice.getText();
                String atQuantity = tfQuantity.getText();
                String atColor = tfColor.getText();
                String atWeight = tfWeight.getText();
                String atLength = tfLength.getText();
                String atWide = tfWide.getText();
                String atHeight = tfHeight.getText();
                String atDescription = tfDescription.getText();

                Article newArticle = new Article(UUID.randomUUID(),Integer.valueOf(atNo),atName,atWeight,atDescription,atColor,Double.valueOf(atPrice),Integer.valueOf(atQuantity), new Measures(Double.valueOf(atLength),Double.valueOf(atWide),Double.valueOf(atHeight)));
                data.addArticle(newArticle);
                parent.refreshInformationPanel();

                dispose();
            }
        });
    }

}
