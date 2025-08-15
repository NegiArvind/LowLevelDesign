package services;

import enums.ComponentType;

import java.util.HashMap;
import java.util.Map;

public class PartsCatalog {

    private final Map<ComponentType, String> activeComponentIdMap = new HashMap<>();

    public PartsCatalog(String cpuComponentId, String ramComponentId, String psuComponentId, String screenComponentId, String gpuComponentId) {
        activeComponentIdMap.put(ComponentType.CPU, cpuComponentId);
        activeComponentIdMap.put(ComponentType.RAM, ramComponentId);
        activeComponentIdMap.put(ComponentType.PSU, psuComponentId);
        activeComponentIdMap.put(ComponentType.SCREEN, screenComponentId);
        activeComponentIdMap.put(ComponentType.GPU, gpuComponentId);
    }

    public synchronized void swap(ComponentType componentType, String newComponentId) {
        activeComponentIdMap.put(componentType, newComponentId);
    }

    public synchronized String getComponentId(ComponentType componentType) {
        return activeComponentIdMap.get(componentType);
    }

    public synchronized Map<ComponentType, String> snapshot() {
        return new HashMap<>(activeComponentIdMap);
    }
}
