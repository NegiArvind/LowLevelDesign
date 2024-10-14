import entranceGate.EntranceGate;
import entranceGate.Ticket;
import exitGate.ExitGateManager;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class Client {
    public static void main(String[] args) {
        EntranceGate entranceGate = new EntranceGate();

        Vehicle car = new Vehicle("UK071792", VehicleType.FOUR_WHEELER);
        Vehicle bike = new Vehicle("UK072453", VehicleType.TWO_WHEELER);

        Ticket carTicket = entranceGate.bookSpot(car, 1);
        Ticket bikeTicket = entranceGate.bookSpot(bike, 2);

        ExitGateManager exitGateManager = new ExitGateManager();
        exitGateManager.exitVehicle(carTicket);
    }
}
