package Classes.SubClasses;

import Classes.SubClasses.UnitsAndValues.MeasuresValue;

public class Measures {

    private MeasuresValue length;
    private MeasuresValue wide;
    private MeasuresValue height;

    public Measures() {
        super();
    }

    public Measures(MeasuresValue ilength, MeasuresValue iwide, MeasuresValue iheight) {
        length = ilength;
        wide = iwide;
        height = iheight;

    }

    public MeasuresValue getLength() {
        return length;
    }

    public void setLength(MeasuresValue length) {
        this.length = length;
    }

    public MeasuresValue getWide() {
        return wide;
    }

    public void setWide(MeasuresValue wide) {
        this.wide = wide;
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
                ", wide=" + wide +
                ", height=" + height +
                '}';
    }
}
