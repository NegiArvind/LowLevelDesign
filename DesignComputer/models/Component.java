package models;

import enums.ComponentType;

public interface Component {
    String getComponentId();
    ComponentType getComponentType();
}
