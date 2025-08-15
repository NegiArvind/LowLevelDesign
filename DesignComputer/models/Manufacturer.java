package models;

import eventObservers.OrderEventListener;
import services.BuildReceipt;
import services.Computer;
import strategy.CapabilityStrategy;

import java.util.UUID;

public interface Manufacturer extends OrderEventListener {
    UUID getId();
    String getDisplayName();
    CapabilityStrategy getCapabilityStrategy();
    BuildReceipt fulfill(Order order, Computer build);
}
