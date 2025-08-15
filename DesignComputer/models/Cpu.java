package models;

import enums.ComponentType;

public class Cpu implements Component {
    private final String componentId;

    public Cpu(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String getComponentId() {
        return componentId;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.CPU;
    }
}
