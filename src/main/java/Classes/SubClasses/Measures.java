package Classes.SubClasses;

import Classes.SubClasses.UnitsAndValues.MeasuresValue;

public class Measures {

    private MeasuresValue length;
    private MeasuresValue width;
    private MeasuresValue height;

    public Measures() {
        super();
    }

    public Measures(MeasuresValue ilength, MeasuresValue iwidth, MeasuresValue iheight) {
        length = ilength;
        width = iwidth;
        height = iheight;

    }

    public MeasuresValue getLength() {
        return length;
    }

    public void setLength(MeasuresValue length) {
        this.length = length;
    }

    public MeasuresValue getWide() {
        return width;
    }

    public void setWide(MeasuresValue width) {
        this.width = width;
    }

    public MeasuresValue getHeight() {
        return height;
    }

    public void setHeight(MeasuresValue height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Measures{" +
                "length=" + length +
                ", wide=" + width +
                ", height=" + height +
                '}';
    }
}
