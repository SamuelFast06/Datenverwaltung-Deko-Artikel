package Classes.Articles;

import Classes.HasName;
import Classes.SubClasses.UnitsAndValues.MeasuresValue;
import Classes.SubClasses.UnitsAndValues.Units.MeasuresUnit;
import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;
import Classes.SubClasses.UnitsAndValues.WeightValue;
import Classes.SubClasses.Measures;

import java.util.UUID;

public class Article implements HasName {

    private String id;
    private int articleNo;
    private String articleName;
    private WeightValue articleWeight;
    private String articleDescription;
    private String articleColor;
    private double articlePrice;
    private int articleQuantity;
    private Measures articleMeasures;

    public Article() {
        super();
    }

    public Article(String id, int articleNo, String articleName, WeightValue articleWeight, String articleDescription, String articleColor, double articlePrice, int articleQuantity, Measures articleMeasures) {
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

    //getter-setter-ToString

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public WeightValue getArticleWeight() {
        return articleWeight;
    }

    public void setArticleWeight(WeightValue articleWeight) {
        this.articleWeight = articleWeight;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getArticleColor() {
        return articleColor;
    }

    public void setArticleColor(String articleColor) {
        this.articleColor = articleColor;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public int getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(int articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public Measures getArticleMeasures() {
        return articleMeasures;
    }

    public void setArticleMeasures(Measures articleMeasures) {
        this.articleMeasures = articleMeasures;
    }

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

    @Override
    public String getName() {
        return articleName;
    }

    public static Article exampleArticle = new Article(UUID.randomUUID().toString(), 532, "bababanana", new WeightValue(80, WeightUnit.g), "This is a description", "This is a color", 99.99, 100, new Measures(new MeasuresValue(100, MeasuresUnit.cm), new MeasuresValue(100, MeasuresUnit.cm), new MeasuresValue(100, MeasuresUnit.cm)));
}
