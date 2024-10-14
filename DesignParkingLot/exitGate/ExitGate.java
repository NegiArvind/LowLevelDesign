package exitGate;

import entranceGate.Ticket;
import parkingSpot.ParkingSpotManager;
import parkingSpot.ParkingSpotManagerFactory;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ExitGate {
    private CostComputation costComputation;
    private Payment payment;
    private ParkingSpotManager parkingSpotManager;
    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private CostComputationFactory costComputationFactory;

    ExitGate() {
        parkingSpotManagerFactory = new ParkingSpotManagerFactory();
        costComputationFactory = new CostComputationFactory();
        payment = new UPIPayment();
    }

    void initializeProcessing(VehicleType vehicleType) {
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicleType);
        costComputation = costComputationFactory.getCostComputation(vehicleType);
    }

    public int calculatePrice(Ticket ticket) {
        return costComputation.getPrice(ticket);
    }

    public boolean doPayment(int amount) {
        return payment.doPayment(amount);
    }

    public void leaveParkingSpace(Vehicle vehicle) {
        parkingSpotManager.removeVehicle(vehicle);
    }
}
