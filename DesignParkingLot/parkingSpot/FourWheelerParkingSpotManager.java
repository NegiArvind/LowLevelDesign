package parkingSpot;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {

    private final static int FOUR_WHEELER_PARKING_SLOT = 100;

    FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
    }

    public static List<ParkingSpot> initialize() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for(int i=0; i< FOUR_WHEELER_PARKING_SLOT; i++) {
            parkingSpotList.add(new FourWheelerParkingSpot(i+1, true));
        }
        return parkingSpotList;
    }
}
