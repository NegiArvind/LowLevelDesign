public class Floor {

    private int floor;
    private ExternalButtonDispatcher externalButtonDispatcher;

    Floor(int floor) {
        this.floor = floor;
        externalButtonDispatcher = new ExternalButtonDispatcher();
    }

    public void pressButton(Direction direction) {
        externalButtonDispatcher.submitExternalRequest(floor, direction);
    }
}
