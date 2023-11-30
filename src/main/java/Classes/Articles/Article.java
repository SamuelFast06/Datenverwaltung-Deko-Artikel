package Classes.Articles;
import Classes.HasName;
import Classes.SubClasses.Measures;
import Classes.SubClasses.UnitsAndValues.WeightValue;

import java.awt.*;
import java.util.*;

public class Article implements HasName {

    private UUID id;
    private int articleNo;
    private String articleName;
    private WeightValue articleWeight;
    private String articleDescription;
    private Color articleColor;
    private double articlePrice;
    private int articleQuantity;
    private Measures articleMeasures;

    public Article() {
        super();
    }

    public Article(UUID id, int articleNo, String articleName, WeightValue articleWeight, String articleDescription, Color articleColor, double articlePrice, int articleQuantity, Measures articleMeasures) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Color getArticleColor() {
        return articleColor;
    }

    public void setArticleColor(Color articleColor) {
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
}
