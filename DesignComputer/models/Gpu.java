package models;

import enums.ComponentType;

public class Gpu implements Component{
    private final String componentId;

    public Gpu(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String getComponentId() {
        return componentId;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.GPU;
    }
}
