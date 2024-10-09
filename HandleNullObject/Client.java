public class Client {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("CAR");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {

        // If vehicles would have been null then we need to add null check here but we have made sure that vehicle can never
        // be null by creating a null vehicle object with default values
        System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
    }
}
