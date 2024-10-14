package exitGate;

import vehicle.VehicleType;

public class CostComputationFactory {

    CostComputation getCostComputation(VehicleType vehicleType) {
        if(vehicleType == VehicleType.TWO_WHEELER) {
            return new TwoWheelerCostComputation();
        }
        return new FourWheelerCostComputation();
    }

}
