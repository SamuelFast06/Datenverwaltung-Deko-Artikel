package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class ArticlesFrame extends JFrame {

    private JPanel managementPanel;
    private JButton btnRemoveArticle;
    private JButton btnAddArticle;
    private JButton btnShowArticle;
    private JButton btnSetQuantity;
    private JButton btnMinusQuantity;
    private JButton btnPlusQuantity;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
    private JLabel lbCurrentUser;
    private JLabel lbManagementName;
    private Data data = new Data(true);
    private ArrayList<Classes.Article> articles = data.getArticles();
    private User user;

    public ArticlesFrame(User iuser){
        user = iuser;
        setContentPane(managementPanel);
        setLocation(0,0);
        setSize(1280,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnManager();
    }

    public void setupArticleList(){
    }



    public void btnManager(){
        btnAddArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("turbo geeeeeeeeeey add article");
            }
        });

        btnRemoveArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("turbo geeeeeeeeeey remove article");
            }
        });

        btnShowArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("turbo geeeeeeeeeey show article");
            }
        });

        btnSetQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("turbo geeeeeeeeeey set quantity");
            }
        });

        btnPlusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("turbo geeeeeeeeeey plus quantity");
            }
        });

        btnMinusQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("turbo geeeeeeeeeey minus quantity");
            }
        });
    }
}
