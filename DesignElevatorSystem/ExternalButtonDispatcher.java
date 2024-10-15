import java.util.List;

public class ExternalButtonDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction) {
        // Odd/event pattern for choosing which elevator should come to serve this request
        for(ElevatorController elevatorController: elevatorControllerList) {
            int elevatorId = elevatorController.getElevatorCar().getId();
            if(elevatorId % 2 == 1 && floor %2 == 1) {
                elevatorController.submitExternalRequest(floor, direction);
            } else {
                elevatorController.submitExternalRequest(floor, direction);
            }
        }
    }
}
