package Classes;

public class testClass {

    private String name;
    private String nachname;
    private int penislength;

    public testClass(String name, String nachname, int penislength){
        this.name = name;
        this.nachname = nachname;
        this.penislength = penislength;
    }

    //getter
    public String getName() {
        return name;
    }
    public String getNachname() {
        return nachname;
    }
    public int getPenislength() {
        return penislength;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public void setPenislength(int penislength) {
        this.penislength = penislength;
    }

    @Override
    public String toString() {
        return "testClass{" +
                "name='" + name + '\'' +
                ", nachname='" + nachname + '\'' +
                ", penislength=" + penislength +
                '}';
    }

}
