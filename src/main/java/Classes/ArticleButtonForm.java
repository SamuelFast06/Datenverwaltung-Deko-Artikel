package Classes;

import javax.swing.*;

public class ArticleButtonForm extends JFrame{
    private JLabel articleName;
    private JLabel articleQuantity;

    public ArticleButtonForm(Article article) {
        this.articleName.setText(article.getArticleName());
        this.articleQuantity.setText("" + article.getArticleQuantity() + "");
    }
}
