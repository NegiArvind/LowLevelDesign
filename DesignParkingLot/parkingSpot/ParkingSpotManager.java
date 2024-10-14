package parkingSpot;

import vehicle.Vehicle;

import java.util.List;
import java.util.Objects;

public abstract class ParkingSpotManager {

    private List<ParkingSpot> parkingSpotList;

    ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingSpot findParkingSpace() {
        return parkingSpotList.stream().filter(ParkingSpot::isEmpty).findFirst().orElse(null);
    }

    public void addParkingSpace(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
    }

    public void removeParkingSpace(ParkingSpot parkingSpot) {
        parkingSpotList.remove(parkingSpot);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        int index = parkingSpotList.indexOf(parkingSpot);
        parkingSpot.parkVehicle(vehicle);
        parkingSpotList.set(index, parkingSpot);
    }

    public void removeVehicle(Vehicle vehicle) {
        ParkingSpot filledParkingSpot = parkingSpotList.stream().filter(parkingSpot -> parkingSpot.getVehicle().getVehicleNumber().equalsIgnoreCase(vehicle.getVehicleNumber())).findFirst().orElse(null);
        int index = parkingSpotList.indexOf(filledParkingSpot);

        if(Objects.nonNull(filledParkingSpot)) {
            filledParkingSpot.removeVehicle(vehicle);
            parkingSpotList.set(index, filledParkingSpot);
        }
    }
}
