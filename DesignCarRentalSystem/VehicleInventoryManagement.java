import java.util.List;

public class VehicleInventoryManagement {
    private List<Vehicle> vehicleList;

    public VehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicles() {
        // filtering
        return vehicleList;
    }

    public void setVehicles(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    // Adding of new vehicle will be done here.
}
