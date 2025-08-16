package strategy;

import models.Ride;

public interface PricingStrategy {
    double calculateFare(Ride ride);
}
