package Classes.Management;

public class Management {
    String name;
    String id;
    Settings settings;

    public Management() {
        super();
    }

    public Management(String name, String id, Settings settings) {
        this.name = name;
        this.id = id;
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}