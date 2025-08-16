package models;

public class Rider {
    private String name;
    private String riderId;

    public Rider(String name, String riderId) {
        this.name = name;
        this.riderId = riderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }
}
