package exitGate;

import entranceGate.Ticket;

public class CostComputation {

    private PricingStrategy pricingStrategy;

    CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    int getPrice(Ticket ticket) {
        return pricingStrategy.getPrice(ticket);
    }
}
