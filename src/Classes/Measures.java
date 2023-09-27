public class Measures {

    private double length;
    private double wide;
    private double height;

    public Measures(double ilength, double iwide, double iheight){
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
