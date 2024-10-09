public class Car implements Vehicle {

    @Override
    public int getSeatingCapacity() {
        return 5;
    }

    @Override
    public int getTankCapacity() {
        return 40;
    }
}
