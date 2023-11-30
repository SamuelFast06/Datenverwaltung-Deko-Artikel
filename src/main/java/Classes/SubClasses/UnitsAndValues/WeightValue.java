package Classes.SubClasses.UnitsAndValues;

import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;

public class WeightValue {

    public double value;
    public WeightUnit weightUnit;

    public WeightValue(double value, WeightUnit weightUnit){
        this.value = value;
        this.weightUnit = weightUnit;
    }

    //Getter
    public double getValue() {
        return value;
    }
    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    //Setter
    public void setValue(double value) {
        this.value = value;
    }
    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
