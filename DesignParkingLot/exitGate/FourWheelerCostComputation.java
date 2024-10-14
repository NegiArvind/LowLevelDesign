package exitGate;

public class FourWheelerCostComputation extends CostComputation {

    FourWheelerCostComputation() {
        super(new MinutesPricingStrategy());
    }
}
