package models;

import enums.ComponentType;

public class Psu implements Component{
    private final String componentId;

    public Psu(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String getComponentId() {
        return componentId;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.PSU;
    }
}
