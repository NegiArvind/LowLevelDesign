package eventObservers;

import enums.ComponentType;

public class CatalogChangedEvent implements DomainEvent {
    private final ComponentType componentType;
    private final String componentId;

    public CatalogChangedEvent(ComponentType componentType, String componentId) {
        this.componentType = componentType;
        this.componentId = componentId;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public String getComponentId() {
        return componentId;
    }
}
