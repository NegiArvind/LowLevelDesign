package eventObservers;

public interface OrderEventListener {
    void onEvent(DomainEvent event);
}
