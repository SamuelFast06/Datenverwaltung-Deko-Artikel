public class Article {

    private int articleNo;
    private String articleName;
    private String articleWeight;
    private String articleDescription;
    private String articleColor;
    private double articlePrice;
    private int articleQuantity;
    private Measures articleMeasures;

    public Article(int iarticleNo, String iarticleName, String iarticleWeight, String iarticleDescription, String iarticleColor, double iarticlePrice, int iarticleQuantity, Measures iarticleMeasures){
        articleNo = iarticleNo;
        articleName = iarticleName;
        articleWeight = iarticleWeight;
        articleDescription = iarticleDescription;
        articleColor = iarticleColor;
        articlePrice = iarticlePrice;
        articleQuantity = iarticleQuantity;
        articleMeasures = iarticleMeasures;
    }

    //getter
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
    public String toString() {
        return "Article{" +
                "articleNo=" + articleNo +
                ", articleName='" + articleName + '\'' +
                ", articleWeight=" + articleWeight +
                ", articleDescription='" + articleDescription + '\'' +
                ", articleColor='" + articleColor + '\'' +
                ", articlePrice=" + articlePrice +
                ", articleQuantity=" + articleQuantity +
                ", articleMeasures=" + articleMeasures +
                '}';
    }
}