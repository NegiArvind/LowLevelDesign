import java.util.PriorityQueue;

public class ElevatorController {

    private ElevatorCar elevatorCar;
    private PriorityQueue<Integer> upMinPQ;
    private PriorityQueue<Integer> downMaxPQ;

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b-a);
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if(direction == Direction.UP) {
            upMinPQ.add(floor);
        } else {
            downMaxPQ.add(floor);
        }
    }

    public void submitInternalRequest(int floor) {
        if(elevatorCar.getDirection() == Direction.UP) {
            upMinPQ.add(floor);
        } else {
            downMaxPQ.add(floor);
        }
    }

    public void controlElevator() {

    }

    public ElevatorCar getElevatorCar() {
        return this.elevatorCar;
    }
}
