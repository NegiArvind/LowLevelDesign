package strategy;

import models.Ride;
import models.TimeType;

import java.util.HashMap;
import java.util.Map;

public class DefaultPricingAlgorithm implements PricingStrategy {

    private final double baseFare;
    private final double distanceMultipliers;
    private Map<TimeType, Double> timeOfDayMultipliers;
    private Map<Integer, Double> demandMultipliers;

    public DefaultPricingAlgorithm(double baseFare, double distanceMultipliers) {
        this.baseFare = baseFare;
        this.distanceMultipliers = distanceMultipliers;
        timeOfDayMultipliers = new HashMap<>();
        demandMultipliers = new HashMap<>();
        initializeMultipliers();
    }

    private void initializeMultipliers() {
        timeOfDayMultipliers.put(TimeType.PEAK, 1.5);
        timeOfDayMultipliers.put(TimeType.NORMAL, 1.0);
        timeOfDayMultipliers.put(TimeType.NIGHT, 1.2);

        // Demand level multipliers
        for(int i=0; i< 10; i++) {
            demandMultipliers.put(i, 1.0 + (i-1) * 0.05); // scale up by 5% each level
        }
    }

    private TimeType getTimeType(int hour) {
        if((hour >= 7 && hour <=9) || (hour >= 17 && hour <= 20)) {
            return TimeType.PEAK;
        } else if(hour >= 22 || hour <= 5) {
            return TimeType.NIGHT;
        } else {
            return TimeType.NORMAL;
        }
    }

    @Override
    public double calculateFare(Ride ride) {

        double price = baseFare + (ride.getDistance() * distanceMultipliers);

        // Time type multiplier
        TimeType timeType = getTimeType(ride.getTimeOfDay());
        price = price * timeOfDayMultipliers.get(timeType);

        // Demand type multiplier
        price = price * demandMultipliers.getOrDefault(ride.getDemandLevel(), 1.0);

        return Math.round((price * 100) / 100);
    }
}
