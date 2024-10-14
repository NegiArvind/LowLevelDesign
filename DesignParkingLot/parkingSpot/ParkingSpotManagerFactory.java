package parkingSpot;

import vehicle.VehicleType;

import java.util.List;

public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        if(vehicleType == VehicleType.TWO_WHEELER) {
            List<ParkingSpot> parkingSpotList = TwoWheelerParkingSpotManager.initialize();
            new TwoWheelerParkingSpotManager(parkingSpotList);
        } else {
            List<ParkingSpot> parkingSpotList = FourWheelerParkingSpotManager.initialize();
            return new FourWheelerParkingSpotManager(parkingSpotList);
        }
        return null;
    }
}
