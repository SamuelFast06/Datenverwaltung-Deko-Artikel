package Classes.SubClasses.UnitsAndValues;

public class TimeValue {
    private double value;
    private TimeValue timeValue;

    public TimeValue(double value, TimeValue timeValue){
        this.value = value;
        this.timeValue = timeValue;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TimeValue getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(TimeValue timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public String toString() {
        return "TimeValue{" +
                "value=" + value +
                ", timeValue=" + timeValue +
                '}';
    }
}

