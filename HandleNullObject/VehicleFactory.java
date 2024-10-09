public class VehicleFactory {

    public static Vehicle getVehicleObject(String vehicleType) {
        if(vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        }
        // Here instead of return null value, I'm returning a null vehicle class object which contains default value
        // By this way consuming class doesn't have to explicitly need null check
        return new NullVehicle();
    }
}
