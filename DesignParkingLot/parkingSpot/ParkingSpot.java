package parkingSpot;

import vehicle.Vehicle;

public abstract class ParkingSpot {
    private int id;
    private boolean isEmpty;
    private Vehicle vehicle;

    ParkingSpot(int id, boolean isEmpty) {
        this.id = id;
        this.isEmpty = isEmpty;
    }

    void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isEmpty = false;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
