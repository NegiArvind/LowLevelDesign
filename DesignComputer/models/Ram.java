package models;

import enums.ComponentType;

public class Ram implements Component{
    private final String componentId;

    public Ram(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String getComponentId() {
        return componentId;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.RAM;
    }
}
