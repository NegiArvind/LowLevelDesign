package eventObservers;

import java.util.LinkedList;
import java.util.List;

public class OrderEventBus {

    private final List<OrderEventListener> listeners = new LinkedList<>();

    public void subscribe(OrderEventListener orderEventListener) {
        listeners.add(orderEventListener);
    }

    public void unsubscribe(OrderEventListener orderEventListener) {
        listeners.remove(orderEventListener);
    }

    public void publish(DomainEvent domainEvent) {
        for(OrderEventListener oel : listeners) {
            oel.onEvent(domainEvent);
        }
    }
}
