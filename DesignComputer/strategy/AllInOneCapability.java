package strategy;

import enums.ComponentType;
import enums.ComputerType;
import services.ComputerFactory;

public class AllInOneCapability implements CapabilityStrategy {

    @Override
    public boolean canBuild(ComputerType computerType) {
        return !ComputerFactory.requiredComponents(computerType).contains(ComponentType.PSU);
    }

    @Override
    public String getName() {
        return "AllInOne";
    }
}
