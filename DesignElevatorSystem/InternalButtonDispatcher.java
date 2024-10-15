import java.util.List;

public class InternalButtonDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    void submitRequest(int floor, ElevatorCar elevatorCar) {
        // Get controller of given elevator car
        ElevatorController elevatorController = elevatorControllerList.stream().filter(elevatorController1 ->
                elevatorController1.getElevatorCar().getId() == elevatorCar.getId()).findFirst().orElse(null);
        if(elevatorController != null) {
            elevatorController.submitInternalRequest(floor);
        }
    }
}
