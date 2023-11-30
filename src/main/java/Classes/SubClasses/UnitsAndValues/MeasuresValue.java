package Classes.SubClasses.UnitsAndValues;

import Classes.SubClasses.UnitsAndValues.Units.MeasuresUnit;

public class MeasuresValue {
    private double value;
    private MeasuresUnit measuresUnit;

    public MeasuresValue(double value, MeasuresUnit measuresUnit){
        this.value = value;
        this.measuresUnit = measuresUnit;
    }

    //Getter
    public double getValue() {
        return value;
    }
    public MeasuresUnit getMeasuresUnit() {
        return measuresUnit;
    }

    //Setter
    public void setValue(double value) {
        this.value = value;
    }
    public void setMeasuresUnit(MeasuresUnit measuresUnit) {
        this.measuresUnit = measuresUnit;
    }

}
