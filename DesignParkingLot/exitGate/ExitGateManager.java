package exitGate;

import entranceGate.Ticket;

public class ExitGateManager {
    private final ExitGate exitGate;

    public ExitGateManager() {
        exitGate = new ExitGate();
    }

    public void exitVehicle(Ticket ticket) {
        exitGate.initializeProcessing(ticket.getVehicle().getVehicleType());
        int price = exitGate.calculatePrice(ticket);
        boolean paymentDone = exitGate.doPayment(price);
        if(paymentDone) {
            exitGate.leaveParkingSpace(ticket.getVehicle());
        }
    }
}
