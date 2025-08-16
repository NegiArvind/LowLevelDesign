import models.Ride;
import strategy.PricingStrategy;

public class RiderService {
    private PricingStrategy pricingStrategy;

    RiderService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void assignPrice(Ride ride) {
        double price = pricingStrategy.calculateFare(ride);
        ride.setPrice(price);
    }
}
