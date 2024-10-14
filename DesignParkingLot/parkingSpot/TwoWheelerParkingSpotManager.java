package parkingSpot;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {
    private final static int TWO_WHEELER_PARKING_SLOT = 30;

    TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
    }

    public static List<ParkingSpot> initialize() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for(int i=0; i< TWO_WHEELER_PARKING_SLOT; i++) {
            parkingSpotList.add(new TwoWheelerParkingSpot(i+1, true));
        }
        return parkingSpotList;
    }
}
