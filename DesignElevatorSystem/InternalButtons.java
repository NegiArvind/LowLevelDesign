public class InternalButtons {

    InternalButtonDispatcher internalButtonDispatcher = new InternalButtonDispatcher();

    int[] availableButtons = {1,2,3,4,5,6,7,8};
    int buttonSelected;

    void pressButton(int destinationFloor, ElevatorCar elevatorCar) {
        this.buttonSelected = destinationFloor;
        internalButtonDispatcher.submitRequest(destinationFloor, elevatorCar);
    }
}
