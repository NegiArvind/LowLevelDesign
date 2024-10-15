import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    public static List<ElevatorController> elevatorControllerList = new ArrayList<>();

    static {
        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.setId(1);
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.setId(2);
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);

        ElevatorCar elevatorCar3 = new ElevatorCar();
        elevatorCar1.setId(3);
        ElevatorController elevatorController3 = new ElevatorController(elevatorCar3);

        elevatorControllerList.add(elevatorController1);
        elevatorControllerList.add(elevatorController2);
        elevatorControllerList.add(elevatorController3);
    }
}
