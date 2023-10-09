package Classes;
import java.util.*;

public class Article {

    private UUID id;
    private int articleNo;
    private String articleName;
    private String articleWeight;
    private String articleDescription;
    private String articleColor;
    private double articlePrice;
    private int articleQuantity;
    private Measures articleMeasures;

    public Article() {
        super();
    }

    public Article(UUID id, int articleNo, String articleName, String articleWeight, String articleDescription, String articleColor, double articlePrice, int articleQuantity, Measures articleMeasures) {
        this.id = id;
        this.articleNo = articleNo;
        this.articleName = articleName;
        this.articleWeight = articleWeight;
        this.articleDescription = articleDescription;
        this.articleColor = articleColor;
        this.articlePrice = articlePrice;
        this.articleQuantity = articleQuantity;
        this.articleMeasures = articleMeasures;
    }

    //getter

    public UUID getId() { return id; }
    public int getArticleNo() {
        return articleNo;
    }
    public String getArticleName() {
        return articleName;
    }
    public String getArticleWeight() {
        return articleWeight;
    }
    public String getArticleDescription() {
        return articleDescription;
    }
    public String getArticleColor() {
        return articleColor;
    }
    public double getArticlePrice() {
        return articlePrice;
    }
    public int getArticleQuantity() {
        return articleQuantity;
    }
    public Measures getArticleMeasures() {
        return articleMeasures;
    }

    //setter

    public void setId(UUID id) { this.id = id; }
    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
    public void setArticleWeight(String articleWeight) {
        this.articleWeight = articleWeight;
    }
    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }
    public void setArticleColor(String articleColor) {
        this.articleColor = articleColor;
    }
    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }
    public void setArticleQuantity(int articleQuantity) {
        this.articleQuantity = articleQuantity;
    }
    public void setArticleMeasures(Measures articleMeasures) {
        this.articleMeasures = articleMeasures;
    }

    //toString


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleNo=" + articleNo +
                ", articleName='" + articleName + '\'' +
                ", articleWeight='" + articleWeight + '\'' +
                ", articleDescription='" + articleDescription + '\'' +
                ", articleColor='" + articleColor + '\'' +
                ", articlePrice=" + articlePrice +
                ", articleQuantity=" + articleQuantity +
                ", articleMeasures=" + articleMeasures +
                '}';
    }
}
class Measures {

    private double length;
    private double wide;
    private double height;

    public Measures() {
        super();
    }

    public Measures(double ilength, double iwide, double iheight) {
        length = ilength;
        wide = iwide;
        height = iheight;

    }

    //getter
    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWide() {
        return wide;
    }

    //setter
    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    //toString
    public String toString() {
        return "Measures{" +
                "length=" + length +
                ", wide=" + wide +
                ", height=" + height +
                '}';
    }


}
