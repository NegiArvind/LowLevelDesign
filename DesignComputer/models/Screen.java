package models;

import enums.ComponentType;

public class Screen implements Component {
    private final String componentId;

    public Screen(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String getComponentId() {
        return componentId;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.SCREEN;
    }
}
