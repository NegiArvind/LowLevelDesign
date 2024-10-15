public class ElevatorCar {

    private int id;
    private ElevatorDisplay display;
    private Direction direction;
    private ElevatorState state;
    private int currentFloor;
    private InternalButtons internalButtons;
    private ElevatorDoor door;

    public ElevatorCar() {
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        state = ElevatorState.IDLE;
        currentFloor = 0;
        direction = Direction.UP;
        door = new ElevatorDoor();
    }

    public void pressButton(int destinationFloor) {
        internalButtons.pressButton(destinationFloor, this);
    }

    public void setDisplay() {
        display.setDisplay(currentFloor, direction);
    }

    public void showDisplay() {
        display.showDisplay();
    }

    boolean moveElevator(Direction dir, int destinationFloor) {
        int startFloor = currentFloor;
        if(dir == Direction.UP) {
            for(int i= startFloor; i <= destinationFloor; i++) {
                this.currentFloor = i;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println("Exception occurred while thread sleep");
                }
            }
        }

        if(dir == Direction.DOWN) {
            for(int i= startFloor; i >= destinationFloor; i--) {
                this.currentFloor = i;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElevatorDisplay getDisplay() {
        return display;
    }

    public void setDisplay(ElevatorDisplay display) {
        this.display = display;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public InternalButtons getInternalButtons() {
        return internalButtons;
    }

    public void setInternalButtons(InternalButtons internalButtons) {
        this.internalButtons = internalButtons;
    }

    public ElevatorDoor getDoor() {
        return door;
    }

    public void setDoor(ElevatorDoor door) {
        this.door = door;
    }
}
