import models.Driver;
import models.Ride;
import models.Rider;
import strategy.DefaultPricingAlgorithm;
import strategy.PricingStrategy;

public class Client {
    public static void main(String[] args) {

        Rider rider = new Rider("Alice", "R123");
        Driver driver = new Driver("Bob", "D456", 4.8);

        Ride ride = new Ride();
        ride.setRider(rider);
        ride.setDriver(driver);
        ride.setDistance(12.5);
        ride.setDemandLevel(2);

        PricingStrategy pricingStrategy = new DefaultPricingAlgorithm(50, 10);

        RiderService riderService = new RiderService(pricingStrategy);
        riderService.assignPrice(ride);

        System.out.println("Ride for " + ride.getRider().getName() + " with driver " + ride.getDriver().getName());
        System.out.println("Distance: " + ride.getDistance() + " km, Time: " + ride.getTimeOfDay() + ":00, Demand: " + ride.getDemandLevel());
        System.out.println("Final Price: ₹" + ride.getPrice());

    }
}
