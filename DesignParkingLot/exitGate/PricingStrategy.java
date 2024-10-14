package exitGate;

import entranceGate.Ticket;

public interface PricingStrategy {

    int getPrice(Ticket ticket);
}
