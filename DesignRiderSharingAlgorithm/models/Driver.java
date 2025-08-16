package models;

public class Driver {
    private String name;
    private String driverId;
    private double rating;

    public Driver(String name, String driverId, double rating) {
        this.name = name;
        this.driverId = driverId;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
