package exitGate;

public class TwoWheelerCostComputation extends CostComputation {

    TwoWheelerCostComputation() {
        super(new HourlyPricingStrategy());
    }


}
