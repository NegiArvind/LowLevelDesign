public class UpdateTemperatureCommand implements ICommand {

    private AirConditioner ac;
    private int temperature;

    UpdateTemperatureCommand(AirConditioner ac, int temperature) {
        this.ac = ac;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        // Do set operation here
        ac.setTemperature(temperature);
    }

    @Override
    public void undo() {
        // Do undo operation here
    }
}
