package strategy;

import enums.ComputerType;

public interface CapabilityStrategy {
    boolean canBuild(ComputerType computerType);
    String getName();
}
