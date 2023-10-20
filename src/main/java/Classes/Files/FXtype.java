package Classes.Files;

public class FXtype {
    String function;
    public FXtype(String ifunction){
        function = ifunction;
    }

    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }
    @Override
    public String toString() {
        return "Type{" +
                "function='" + function + '\'' +
                '}';
    }
}
