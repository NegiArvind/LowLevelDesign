package strategy;

import enums.ComponentType;
import enums.ComputerType;
import services.ComputerFactory;

public class ScreenLessCapability implements CapabilityStrategy {
    @Override
    public boolean canBuild(ComputerType computerType) {
        return !ComputerFactory.requiredComponents(computerType).contains(ComponentType.SCREEN);
    }

    @Override
    public String getName() {
        return "ScreenLess";
    }
}
