package entranceGate;

import parkingSpot.ParkingSpot;
import parkingSpot.ParkingSpotManager;
import parkingSpot.ParkingSpotManagerFactory;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class EntranceGate {
    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private ParkingSpotManager parkingSpotManager;

    public EntranceGate() {
        parkingSpotManagerFactory = new ParkingSpotManagerFactory();
    }


    public ParkingSpot findSpace(VehicleType vehicleType, int entranceGateNumber) {
        // We can update here to use different strategy
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicleType);
        return parkingSpotManager.findParkingSpace();
    }

    public Ticket bookSpot(Vehicle vehicle, int entranceGateNumber) {
        ParkingSpot parkingSpot = findSpace(vehicle.getVehicleType(), entranceGateNumber);
        if(Objects.nonNull(parkingSpot)) {
            parkingSpotManager.parkVehicle(vehicle, parkingSpot);
            Ticket ticket = generateTicket(vehicle, parkingSpot);
            System.out.println("Here is your ticket detail: " + "\nEntry Time: "+ ticket.getEntryTime() + "\nTicket Id: " + ticket.getId()
                    + "\nParking Spot Number: " + ticket.getParkingSpot().getId() + "\nVehicle Type: "+ ticket.getVehicle().getVehicleType());
            return ticket;
        } else {
            System.out.println("Parking spot is full for "+ vehicle.getVehicleType());
            return null;
        }
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket(UUID.randomUUID(), LocalDateTime.now(), vehicle, parkingSpot);
    }
}
