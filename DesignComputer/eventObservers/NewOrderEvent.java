package eventObservers;

import models.Order;

public class NewOrderEvent implements DomainEvent {
    private final Order order;

    public NewOrderEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
