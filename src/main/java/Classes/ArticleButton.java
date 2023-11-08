package Classes;

import javax.swing.*;
import java.awt.*;

public class ArticleButton extends JPanel {

    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JPanel panel;

    public ArticleButton(Article article) {
        JLabel nameLabel = new JLabel(article.getArticleName());
        nameLabel.setFont(new Font(null, Font.BOLD, 20));
        JLabel quantitylabel = new JLabel("" + article.getArticleQuantity() + "");

        this.add(nameLabel);
        this.add(quantitylabel);

        setVisible(true);
    }


}
