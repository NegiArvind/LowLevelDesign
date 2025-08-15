package models;

import eventObservers.DomainEvent;
import eventObservers.NewOrderEvent;
import services.BuildReceipt;
import services.Computer;
import strategy.CapabilityStrategy;

import java.util.UUID;

public abstract class BaseManufacturer implements Manufacturer {

    private final UUID id = UUID.randomUUID();
    private final String name;
    private final CapabilityStrategy capabilityStrategy;

    BaseManufacturer(String name, CapabilityStrategy capabilityStrategy) {
        this.name = name;
        this.capabilityStrategy = capabilityStrategy;
    }

    public UUID getId() {
        return id;
    }

    public String getDisplayName() {
        return name;
    }

    public CapabilityStrategy getCapabilityStrategy() {
        return capabilityStrategy;
    }

    public void onEvent(DomainEvent event) {
        if (event instanceof NewOrderEvent) {
            NewOrderEvent noe = (NewOrderEvent) event;
            System.out.println("[Notify] " + name + " saw new order " + noe.getOrder().getId());
        }
    }

    public BuildReceipt fulfill(Order order, Computer build) {
        System.out.println("[Build] " + name + " fulfilling order " + order.getId() + " => " + build);
        return new BuildReceipt(id, order.getId(), build.getBuildId());
    }
}
