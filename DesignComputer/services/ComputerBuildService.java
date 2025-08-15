package services;

import enums.ComponentType;
import enums.ComputerType;
import eventObservers.CatalogChangedEvent;
import eventObservers.NewOrderEvent;
import eventObservers.OrderEventBus;
import models.Manufacturer;
import models.Order;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ComputerBuildService {

    private final PartsCatalog partsCatalog;
    private final ComputerFactory factory;
    private final OrderEventBus eventBus = new OrderEventBus();
    private final List<Manufacturer> manufacturers = new ArrayList<>();
    private final WorkAllocator workAllocator = new WorkAllocator(manufacturers);
    private final AtomicLong orderSeq = new AtomicLong(1000);
    private final Set<UUID> bannedManufactures = new HashSet<>();

    public ComputerBuildService(PartsCatalog partsCatalog) {
        this.partsCatalog = partsCatalog;
        this.factory = new ComputerFactory(this.partsCatalog);
    }

    public synchronized boolean addManufacture(Manufacturer manufacturer) {
        if(bannedManufactures.contains(manufacturer.getId())) {
            return false;
        }
        manufacturers.add(manufacturer);
        eventBus.subscribe(manufacturer);
        return true;
    }

    public synchronized void removeManufacture(UUID id) {
        Iterator<Manufacturer> it = manufacturers.iterator();
        while(it.hasNext()) {
            Manufacturer manufacturer = it.next();
            if(manufacturer.getId().equals(id)) {
                it.remove();
                bannedManufactures.add(id);
                eventBus.unsubscribe(manufacturer);
                break;
            }
        }
    }

    public void swapPart(ComponentType type, String newComponentId) {
        partsCatalog.swap(type, newComponentId);
        eventBus.publish(new CatalogChangedEvent(type, newComponentId));
    }

    // Order acceptance and dispatch
    public synchronized BuildReceipt placeOrder(ComputerType type) {
        long id = orderSeq.incrementAndGet();
        Order order = new Order(id, type);

        // Notify all manufactures that a new request has arrived
        eventBus.publish(new NewOrderEvent(order));

        Manufacturer manufacturer = workAllocator.nextCapable(type);
        if(Objects.nonNull(manufacturer)) {
            Computer build = factory.assemble(type);
            return manufacturer.fulfill(order, build);
        } else {
            throw new IllegalStateException("No capable manufacturer available for order type: " + type);
        }
    }

    public synchronized List<String> listManufacturers() {
        List<String> names = new ArrayList<>();
        for (Manufacturer m : manufacturers) {
            names.add(m.getDisplayName());
        }
        return names;
    }

    public Map<ComponentType, String> currentCatalog() {
        return partsCatalog.snapshot();
    }
}
