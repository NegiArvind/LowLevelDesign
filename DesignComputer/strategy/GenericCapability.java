package strategy;

import enums.ComputerType;

public class GenericCapability implements CapabilityStrategy {
    @Override
    public boolean canBuild(ComputerType computerType) {
        return true;
    }

    @Override
    public String getName() {
        return "Generic";
    }
}
