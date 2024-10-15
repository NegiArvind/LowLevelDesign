import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement inventoryManagement;
    ReservationManagement reservationManagement;
    Location location;

    Store() {
        reservationManagement = new ReservationManagement();
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicleList) {
        inventoryManagement = new VehicleInventoryManagement(vehicleList);
    }

    // add vehicles, update vehicles, get vehicles -> All these will be supported by inventory management

    public Reservation createReservation(Vehicle vehicle, User user) {
        return reservationManagement.createReservation(vehicle, user);
    }

    public boolean completeReservation(int reservationId) {
        //take out the reservation from the list and call complete the reservation method.
        reservationManagement.completeReservation(reservationId);
        return true;
    }
}
